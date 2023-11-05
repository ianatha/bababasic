package io.atha.quickbasic.terminal

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.media.AudioManager
import android.os.Build
import android.os.Environment
import android.util.Log
import android.view.InputDevice
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.widget.AdapterView
import androidx.core.view.WindowInsetsCompat
import com.termux.shared.activities.ReportActivity
import com.termux.shared.android.AndroidUtils
import com.termux.shared.data.DataUtils
import com.termux.shared.file.FileUtils
import com.termux.shared.interact.MessageDialogUtils
import com.termux.shared.interact.ShareUtils
import com.termux.shared.logger.Logger
import com.termux.shared.markdown.MarkdownUtils
import com.termux.shared.models.ReportInfo
import com.termux.shared.shell.ShellUtils
import com.termux.shared.termux.TermuxBootstrap
import com.termux.shared.termux.TermuxConstants
import com.termux.shared.termux.TermuxUtils
import com.termux.shared.termux.data.TermuxUrlUtils
import com.termux.shared.termux.extrakeys.SpecialButton
import com.termux.shared.termux.terminal.TermuxTerminalViewClientBase
import com.termux.shared.view.KeyboardUtils
import com.termux.terminal.KeyHandler
import com.termux.terminal.TerminalEmulator
import com.termux.terminal.TerminalSession
import io.atha.quickbasic.RunActivity
import java.util.Arrays
import java.util.Collections

class TermuxTerminalViewClient(
    activity: RunActivity,
//    termuxTerminalSessionActivityClient: TermuxTerminalSessionActivityClient
) :
    TermuxTerminalViewClientBase() {
    val mActivity: RunActivity
//    val mTermuxTerminalSessionActivityClient: TermuxTerminalSessionActivityClient

    /** Keeping track of the special keys acting as Ctrl and Fn for the soft keyboard and other hardware keys.  */
    var mVirtualControlKeyDown = false
    var mVirtualFnKeyDown = false
    private var mShowSoftKeyboardRunnable: Runnable? = null
    private var mShowSoftKeyboardIgnoreOnce = false
    private var mShowSoftKeyboardWithDelayOnce = false
    private var mTerminalCursorBlinkerStateAlreadySet = false
//    private var mSessionShortcuts: MutableList<KeyboardShortcut>? = null

    init {
        mActivity = activity
//        mTermuxTerminalSessionActivityClient = termuxTerminalSessionActivityClient
    }

    val activity: RunActivity
        get() = mActivity

    /**
     * Should be called when mActivity.onCreate() is called
     */
    fun onCreate() {
        onReloadProperties()
        mActivity.binding.terminal.setTextSize(mActivity.getPreferences().fontSize)
        mActivity.binding.terminal.keepScreenOn = mActivity.getPreferences().shouldKeepScreenOn()
    }

    /**
     * Should be called when mActivity.onStart() is called
     */
    fun onStart() {
        // Set {@link TerminalView#TERMINAL_VIEW_KEY_LOGGING_ENABLED} value
        // Also required if user changed the preference from {@link TermuxSettings} activity and returns
        val isTerminalViewKeyLoggingEnabled: Boolean =
            mActivity.getPreferences().isTerminalViewKeyLoggingEnabled
        mActivity.getTerminalView()
            .setIsTerminalViewKeyLoggingEnabled(isTerminalViewKeyLoggingEnabled)

        // Piggyback on the terminal view key logging toggle for now, should add a separate toggle in future
//        mActivity.getTermuxActivityRootView()
//            .setIsRootViewLoggingEnabled(isTerminalViewKeyLoggingEnabled)
//        ViewUtils.setIsViewUtilsLoggingEnabled(isTerminalViewKeyLoggingEnabled)
    }

    /**
     * Should be called when mActivity.onResume() is called
     */
    fun onResume() {
        // Show the soft keyboard if required
        setSoftKeyboardState(true, mActivity.isActivityRecreated())
        mTerminalCursorBlinkerStateAlreadySet = false
        if (mActivity.getTerminalView().mEmulator != null) {
            // Start terminal cursor blinking if enabled
            // If emulator is already set, then start blinker now, otherwise wait for onEmulatorSet()
            // event to start it. This is needed since onEmulatorSet() may not be called after
            // TermuxActivity is started after device display timeout with double tap and not power button.
            setTerminalCursorBlinkerState(true)
            mTerminalCursorBlinkerStateAlreadySet = true
        }
    }

    /**
     * Should be called when mActivity.onStop() is called
     */
    fun onStop() {
        // Stop terminal cursor blinking if enabled
        setTerminalCursorBlinkerState(false)
    }

    /**
     * Should be called when mActivity.reloadProperties() is called
     */
    fun onReloadProperties() {
        setSessionShortcuts()
    }

    /**
     * Should be called when mActivity.reloadActivityStyling() is called
     */
    fun onReloadActivityStyling() {
        // Show the soft keyboard if required
        setSoftKeyboardState(false, true)

        // Start terminal cursor blinking if enabled
        setTerminalCursorBlinkerState(true)
    }

    /**
     * Should be called when [com.termux.view.TerminalView.mEmulator] is set
     */
    override fun onEmulatorSet() {
        if (!mTerminalCursorBlinkerStateAlreadySet) {
            // Start terminal cursor blinking if enabled
            // We need to wait for the first session to be attached that's set in
            // TermuxActivity.onServiceConnected() and then the multiple calls to TerminalView.updateSize()
            // where the final one eventually sets the mEmulator when width/height is not 0. Otherwise
            // blinker will not start again if TermuxActivity is started again after exiting it with
            // double back press. Check TerminalView.setTerminalCursorBlinkerState().
            setTerminalCursorBlinkerState(true)
            mTerminalCursorBlinkerStateAlreadySet = true
        }
    }

    override fun onScale(scale: Float): Float {
        if (scale < 0.9f || scale > 1.1f) {
            val increase = scale > 1f
            changeFontSize(increase)
            return 1.0f
        }
        return scale
    }

    override fun onSingleTapUp(e: MotionEvent) {
        val term: TerminalEmulator = mActivity.getCurrentSession()!!.emulator
//        if (mActivity.getProperties().shouldOpenTerminalTranscriptURLOnClick()) {
//            val columnAndRow: IntArray = mActivity.getTerminalView().getColumnAndRow(e, true)
//            val wordAtTap = term.screen.getWordAtLocation(columnAndRow[0], columnAndRow[1])
//            val urlSet = TermuxUrlUtils.extractUrls(wordAtTap)
//            if (!urlSet.isEmpty()) {
//                val url = urlSet.iterator().next() as String
//                ShareUtils.openUrl(mActivity, url)
//                return
//            }
//        }
//        if (!term.isMouseTrackingActive && !e.isFromSource(InputDevice.SOURCE_MOUSE)) {
//            if (!KeyboardUtils.areDisableSoftKeyboardFlagsSet(mActivity)) KeyboardUtils.showSoftKeyboard(
//                mActivity,
//                mActivity.getTerminalView()
//            ) else Logger.logVerbose(
//                LOG_TAG, "Not showing soft keyboard onSingleTapUp since its disabled"
//            )
//        }
    }

    override fun shouldBackButtonBeMappedToEscape(): Boolean {
        return false // mActivity.getProperties().isBackKeyTheEscapeKey()
    }

    override fun shouldEnforceCharBasedInput(): Boolean {
        return false // mActivity.getProperties().isEnforcingCharBasedInput()
    }

    override fun shouldUseCtrlSpaceWorkaround(): Boolean {
        return false // mActivity.getProperties().isUsingCtrlSpaceWorkaround()
    }

    override fun isTerminalViewSelected(): Boolean {
        return mActivity.getTerminalView().hasFocus()
    }

    override fun copyModeChanged(copyMode: Boolean) {
        // Disable drawer while copying.
//        mActivity.getDrawer()
//            .setDrawerLockMode(if (copyMode) DrawerLayout.LOCK_MODE_LOCKED_CLOSED else DrawerLayout.LOCK_MODE_UNLOCKED)
    }

    @SuppressLint("RtlHardcoded")
    override fun onKeyDown(keyCode: Int, e: KeyEvent, currentSession: TerminalSession): Boolean {
        if (handleVirtualKeys(keyCode, e, true)) return true
        if (keyCode == KeyEvent.KEYCODE_ENTER && !currentSession.isRunning) {
//            mTermuxTerminalSessionActivityClient.removeFinishedSession(currentSession)
            return true
        } else if (!false /*mActivity.getProperties().areHardwareKeyboardShortcutsDisabled()*/ &&
            e.isCtrlPressed && e.isAltPressed
        ) {
            // Get the unmodified code point:
            val unicodeChar = e.getUnicodeChar(0)
            if (keyCode == KeyEvent.KEYCODE_DPAD_DOWN || unicodeChar == 'n'.code /* next */) {
//                mTermuxTerminalSessionActivityClient.switchToSession(true)
            } else if (keyCode == KeyEvent.KEYCODE_DPAD_UP || unicodeChar == 'p'.code /* previous */) {
//                mTermuxTerminalSessionActivityClient.switchToSession(false)
            } else if (keyCode == KeyEvent.KEYCODE_DPAD_RIGHT) {
//                mActivity.getDrawer().openDrawer(Gravity.LEFT)
            } else if (keyCode == KeyEvent.KEYCODE_DPAD_LEFT) {
//                mActivity.getDrawer().closeDrawers()
            } else if (unicodeChar == 'k'.code /* keyboard */) {
                onToggleSoftKeyboardRequest()
            } else if (unicodeChar == 'm'.code /* menu */) {
//                mActivity.getTerminalView().showContextMenu()
            } else if (unicodeChar == 'r'.code /* rename */) {
//                mTermuxTerminalSessionActivityClient.renameSession(currentSession)
            } else if (unicodeChar == 'c'.code /* create */) {
//                mTermuxTerminalSessionActivityClient.addNewSession(false, null)
            } else if (unicodeChar == 'u'.code /* urls */) {
                showUrlSelection()
            } else if (unicodeChar == 'v'.code) {
                doPaste()
            } else if (unicodeChar == '+'.code || e.getUnicodeChar(KeyEvent.META_SHIFT_ON) == '+'.code) {
                // We also check for the shifted char here since shift may be required to produce '+',
                // see https://github.com/termux/termux-api/issues/2
                changeFontSize(true)
            } else if (unicodeChar == '-'.code) {
                changeFontSize(false)
            } else if (unicodeChar >= '1'.code && unicodeChar <= '9'.code) {
                val index = unicodeChar - '1'.code
//                mTermuxTerminalSessionActivityClient.switchToSession(index)
            }
            return true
        }
        return false
    }

    override fun onKeyUp(keyCode: Int, e: KeyEvent): Boolean {
        // If emulator is not set, like if bootstrap installation failed and user dismissed the error
        // dialog, then just exit the activity, otherwise they will be stuck in a broken state.
        if (keyCode == KeyEvent.KEYCODE_BACK && mActivity.getTerminalView().mEmulator == null) {
//            mActivity.finishActivityIfNotFinishing()
            return true
        }
        return handleVirtualKeys(keyCode, e, false)
    }

    /** Handle dedicated volume buttons as virtual keys if applicable.  */
    private fun handleVirtualKeys(keyCode: Int, event: KeyEvent, down: Boolean): Boolean {
        Log.i("k", "handle virtual keys $keyCode")
        val inputDevice = event.device
//        if (mActivity.getProperties().areVirtualVolumeKeysDisabled()) {
//            return false
//        } else
        if (inputDevice != null && inputDevice.keyboardType == InputDevice.KEYBOARD_TYPE_ALPHABETIC) {
            // Do not steal dedicated buttons from a full external keyboard.
            return false
        } else if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
            mVirtualControlKeyDown = down
            return true
        } else if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
            mVirtualFnKeyDown = down
            return true
        }
        return false
    }

    override fun readControlKey(): Boolean {
        return readExtraKeysSpecialButton(SpecialButton.CTRL) || mVirtualControlKeyDown
    }

    override fun readAltKey(): Boolean {
        return readExtraKeysSpecialButton(SpecialButton.ALT)
    }

    override fun readShiftKey(): Boolean {
        return readExtraKeysSpecialButton(SpecialButton.SHIFT)
    }

    override fun readFnKey(): Boolean {
        return readExtraKeysSpecialButton(SpecialButton.FN)
    }

    fun readExtraKeysSpecialButton(specialButton: SpecialButton): Boolean {
//        if (mActivity.getExtraKeysView() == null) return false
//        val state: Boolean = mActivity.getExtraKeysView().readSpecialButton(specialButton, true)
//        if (state == null) {
//            Logger.logError(
//                LOG_TAG,
//                "Failed to read an unregistered $specialButton special button value from extra keys."
//            )
        return false
//        }
//        return state
    }

    override fun onLongPress(event: MotionEvent): Boolean {
        return false
    }

    override fun onCodePoint(codePoint: Int, ctrlDown: Boolean, session: TerminalSession): Boolean {
        if (mVirtualFnKeyDown) {
            var resultingKeyCode = -1
            var resultingCodePoint = -1
            var altDown = false
            when (val lowerCase = Character.toLowerCase(codePoint).toChar()) {
                'w' -> resultingKeyCode = KeyEvent.KEYCODE_DPAD_UP
                'a' -> resultingKeyCode = KeyEvent.KEYCODE_DPAD_LEFT
                's' -> resultingKeyCode = KeyEvent.KEYCODE_DPAD_DOWN
                'd' -> resultingKeyCode = KeyEvent.KEYCODE_DPAD_RIGHT
                'p' -> resultingKeyCode = KeyEvent.KEYCODE_PAGE_UP
                'n' -> resultingKeyCode = KeyEvent.KEYCODE_PAGE_DOWN
                't' -> resultingKeyCode = KeyEvent.KEYCODE_TAB
                'i' -> resultingKeyCode = KeyEvent.KEYCODE_INSERT
                'h' -> resultingCodePoint = '~'.code
                'u' -> resultingCodePoint = '_'.code
                'l' -> resultingCodePoint = '|'.code
                '1', '2', '3', '4', '5', '6', '7', '8', '9' -> resultingKeyCode =
                    codePoint - '1'.code + KeyEvent.KEYCODE_F1

                '0' -> resultingKeyCode = KeyEvent.KEYCODE_F10
                'e' -> resultingCodePoint =  /*Escape*/27
                '.' -> resultingCodePoint =  /*^.*/28
                'b', 'f', 'x' -> {
                    resultingCodePoint = lowerCase.code
                    altDown = true
                }

                'v' -> {
                    resultingCodePoint = -1
                    val audio = mActivity.getSystemService(Context.AUDIO_SERVICE) as AudioManager
                    audio.adjustSuggestedStreamVolume(
                        AudioManager.ADJUST_SAME,
                        AudioManager.USE_DEFAULT_STREAM_TYPE,
                        AudioManager.FLAG_SHOW_UI
                    )
                }

                'q', 'k' -> {
                    mActivity.toggleTerminalToolbar()
                    mVirtualFnKeyDown =
                        false // force disable fn key down to restore keyboard input into terminal view, fixes termux/termux-app#1420
                }
            }
            if (resultingKeyCode != -1) {
                val term = session.emulator
                Log.i("qb", "resulting key code $resultingKeyCode session.write")
                session.write(
                    KeyHandler.getCode(
                        resultingKeyCode,
                        0,
                        term.isCursorKeysApplicationMode,
                        term.isKeypadApplicationMode
                    )
                )
            } else if (resultingCodePoint != -1) {
                session.writeCodePoint(altDown, resultingCodePoint)
            }
            return true
        } else if (ctrlDown) {
            if (codePoint == 106 /* Ctrl+j or \n */ && !session.isRunning) {
//                mTermuxTerminalSessionActivityClient.removeFinishedSession(session)
                return true
            }
//            val shortcuts: List<KeyboardShortcut>? = mSessionShortcuts
//            if (shortcuts != null && !shortcuts.isEmpty()) {
//                val codePointLowerCase: Int = codePoint.lowercaseChar()
//                for (i in shortcuts.indices.reversed()) {
//                    val shortcut: KeyboardShortcut = shortcuts[i]
//                    if (codePointLowerCase == shortcut.codePoint) {
//                        when (shortcut.shortcutAction) {
//                            TermuxPropertyConstants.ACTION_SHORTCUT_CREATE_SESSION -> {
//                                mTermuxTerminalSessionActivityClient.addNewSession(false, null)
//                                return true
//                            }
//
//                            TermuxPropertyConstants.ACTION_SHORTCUT_NEXT_SESSION -> {
//                                mTermuxTerminalSessionActivityClient.switchToSession(true)
//                                return true
//                            }
//
//                            TermuxPropertyConstants.ACTION_SHORTCUT_PREVIOUS_SESSION -> {
//                                mTermuxTerminalSessionActivityClient.switchToSession(false)
//                                return true
//                            }
//
//                            TermuxPropertyConstants.ACTION_SHORTCUT_RENAME_SESSION -> {
//                                mTermuxTerminalSessionActivityClient.renameSession(mActivity.getCurrentSession())
//                                return true
//                            }
//                        }
//                    }
//                }
//            }
        }
        return false
    }

    /**
     * Set the terminal sessions shortcuts.
     */
    private fun setSessionShortcuts() {
//        mSessionShortcuts = ArrayList<KeyboardShortcut>()
//
//        // The {@link TermuxPropertyConstants#MAP_SESSION_SHORTCUTS} stores the session shortcut key and action pair
//        for ((key, value): Map.Entry<String, Int> in TermuxPropertyConstants.MAP_SESSION_SHORTCUTS) {
//            // The mMap stores the code points for the session shortcuts while loading properties
//            val codePoint = mActivity.getProperties().getInternalPropertyValue(key, true) as Int
//            // If codePoint is null, then session shortcut did not exist in properties or was invalid
//            // as parsed by {@link #getCodePointForSessionShortcuts(String,String)}
//            // If codePoint is not null, then get the action for the MAP_SESSION_SHORTCUTS key and
//            // add the code point to sessionShortcuts
//            if (codePoint != null) mSessionShortcuts!!.add(KeyboardShortcut(codePoint, value))
//        }
    }

    fun changeFontSize(increase: Boolean) {
        mActivity.getPreferences().changeFontSize(increase)
//        mActivity.getTerminalView().setTextSize(mActivity.getPreferences().getFontSize())
        mActivity.getTerminalView().setTextSize(mActivity.getPreferences().fontSize)
    }

    /**
     * Called when user requests the soft keyboard to be toggled via "KEYBOARD" toggle button in
     * drawer or extra keys, or with ctrl+alt+k hardware keyboard shortcut.
     */
    fun onToggleSoftKeyboardRequest() {
        // If soft keyboard toggle behaviour is enable/disabled
//        if (mActivity.getProperties().shouldEnableDisableSoftKeyboardOnToggle()) {
//            // If soft keyboard is visible
//            if (!KeyboardUtils.areDisableSoftKeyboardFlagsSet(mActivity)) {
//                Logger.logVerbose(LOG_TAG, "Disabling soft keyboard on toggle")
//                mActivity.getPreferences().setSoftKeyboardEnabled(false)
//                KeyboardUtils.disableSoftKeyboard(mActivity, mActivity.getTerminalView())
//            } else {
//                // Show with a delay, otherwise pressing keyboard toggle won't show the keyboard after
//                // switching back from another app if keyboard was previously disabled by user.
//                // Also request focus, since it wouldn't have been requested at startup by
//                // setSoftKeyboardState if keyboard was disabled. #2112
//                Logger.logVerbose(LOG_TAG, "Enabling soft keyboard on toggle")
//                mActivity.getPreferences().setSoftKeyboardEnabled(true)
//                KeyboardUtils.clearDisableSoftKeyboardFlags(mActivity)
//                if (mShowSoftKeyboardWithDelayOnce) {
//                    mShowSoftKeyboardWithDelayOnce = false
//                    mActivity.getTerminalView().postDelayed(showSoftKeyboardRunnable, 500)
//                    mActivity.getTerminalView().requestFocus()
//                } else KeyboardUtils.showSoftKeyboard(mActivity, mActivity.getTerminalView())
//            }
//        } else {
//            // If soft keyboard is disabled by user for Termux
//            if (!mActivity.getPreferences().isSoftKeyboardEnabled()) {
//                Logger.logVerbose(LOG_TAG, "Maintaining disabled soft keyboard on toggle")
//                KeyboardUtils.disableSoftKeyboard(mActivity, mActivity.getTerminalView())
//            } else {
//                Logger.logVerbose(LOG_TAG, "Showing/Hiding soft keyboard on toggle")
//                KeyboardUtils.clearDisableSoftKeyboardFlags(mActivity)
//                KeyboardUtils.toggleSoftKeyboard(mActivity)
//            }
//        }
    }

    fun setSoftKeyboardState(isStartup: Boolean, isReloadTermuxProperties: Boolean) {
        var noShowKeyboard = false

        // Requesting terminal view focus is necessary regardless of if soft keyboard is to be
        // disabled or hidden at startup, otherwise if hardware keyboard is attached and user
        // starts typing on hardware keyboard without tapping on the terminal first, then a colour
        // tint will be added to the terminal as highlight for the focussed view. Test with a light
        // theme. For android 8.+, the "defaultFocusHighlightEnabled" attribute is also set to false
        // in TerminalView layout to fix the issue.

        // If soft keyboard is disabled by user for Termux (check function docs for Termux behaviour info)
        if (KeyboardUtils.shouldSoftKeyboardBeDisabled(
                mActivity,
                mActivity.getPreferences().isSoftKeyboardEnabled,
                mActivity.getPreferences().isSoftKeyboardEnabledOnlyIfNoHardware
            )
        ) {
//            Logger.logVerbose(LOG_TAG, "Maintaining disabled soft keyboard")
            KeyboardUtils.disableSoftKeyboard(mActivity, mActivity.getTerminalView())
            mActivity.getTerminalView().requestFocus()
            noShowKeyboard = true
            // Delay is only required if onCreate() is called like when Termux app is exited with
            // double back press, not when Termux app is switched back from another app and keyboard
            // toggle is pressed to enable keyboard
//            if (isStartup && mActivity.isOnResumeAfterOnCreate()) mShowSoftKeyboardWithDelayOnce =  true
        } else {
            // Set flag to automatically push up TerminalView when keyboard is opened instead of showing over it
            KeyboardUtils.setSoftInputModeAdjustResize(mActivity)

            // Clear any previous flags to disable soft keyboard in case setting updated
            KeyboardUtils.clearDisableSoftKeyboardFlags(mActivity)

            // If soft keyboard is to be hidden on startup
            if (isStartup && false /* mActivity.getProperties().shouldSoftKeyboardBeHiddenOnStartup() */) {
                Logger.logVerbose(LOG_TAG, "Hiding soft keyboard on startup")
                // Required to keep keyboard hidden when Termux app is switched back from another app
                KeyboardUtils.setSoftKeyboardAlwaysHiddenFlags(mActivity)
                KeyboardUtils.hideSoftKeyboard(mActivity, mActivity.getTerminalView())
                mActivity.getTerminalView().requestFocus()
                noShowKeyboard = true
                // Required to keep keyboard hidden on app startup
                mShowSoftKeyboardIgnoreOnce = true
            }
        }
        mActivity.getTerminalView().setOnFocusChangeListener { view, hasFocus ->
            Log.i("qb", "terminal view has focus")
                            // Force show soft keyboard if TerminalView or toolbar text input view has
                            // focus and close it if they don't
                            var textInputViewHasFocus = false
//                            val textInputView: EditText =
//                                mActivity.findViewById(R.id.terminal_toolbar_text_input)
//                            if (textInputView != null) textInputViewHasFocus = textInputView.hasFocus()
            ////                if (hasFocus || textInputViewHasFocus) {
            ////                    if (mShowSoftKeyboardIgnoreOnce) {
            ////                        mShowSoftKeyboardIgnoreOnce = false
            ////                        return
            ////                    }
            ////                    Logger.logVerbose(LOG_TAG, "Showing soft keyboard on focus change")
            ////                } else {
            ////                    Logger.logVerbose(LOG_TAG, "Hiding soft keyboard on focus change")
            ////                }
            Log.i("qb", "show kbd")
                            KeyboardUtils.setSoftKeyboardVisibility(
                                showSoftKeyboardRunnable,
                                mActivity,
                                mActivity.getTerminalView(),
                                true
                            )
        }

        // Do not force show soft keyboard if termux-reload-settings command was run with hardware keyboard
        // or soft keyboard is to be hidden or is disabled
        if (!isReloadTermuxProperties && !noShowKeyboard) {
            // Request focus for TerminalView
            // Also show the keyboard, since onFocusChange will not be called if TerminalView already
            // had focus on startup to show the keyboard, like when opening url with context menu
            // "Select URL" long press and returning to Termux app with back button. This
            // will also show keyboard even if it was closed before opening url. #2111
            Logger.logVerbose(LOG_TAG, "Requesting TerminalView focus and showing soft keyboard")
            mActivity.getTerminalView().requestFocus()
            mActivity.getTerminalView().postDelayed(showSoftKeyboardRunnable, 300)
        }
    }

    private val showSoftKeyboardRunnable: Runnable
        private get() {
            if (mShowSoftKeyboardRunnable == null) {
                mShowSoftKeyboardRunnable = Runnable {
                    KeyboardUtils.showSoftKeyboard(
                        mActivity,
                        mActivity.getTerminalView()
                    )
                }
            }
            return mShowSoftKeyboardRunnable as Runnable
        }

    fun setTerminalCursorBlinkerState(start: Boolean) {
        if (start) {
            // If set/update the cursor blinking rate is successful, then enable cursor blinker
//            if (mActivity.getTerminalView().setTerminalCursorBlinkerRate(
//                    mActivity.getProperties().getTerminalCursorBlinkRate()
//                )
//            ) mActivity.getTerminalView()
//                .setTerminalCursorBlinkerState(true, true) else Logger.logError(
//                LOG_TAG, "Failed to start cursor blinker"
//            )
        } else {
            // Disable cursor blinker
            mActivity.getTerminalView().setTerminalCursorBlinkerState(false, true)
        }
    }

    fun shareSessionTranscript() {
        val session: TerminalSession = mActivity.getCurrentSession() ?: return
        var transcriptText =
            ShellUtils.getTerminalSessionTranscriptText(session, false, true) ?: return

        // See https://github.com/termux/termux-app/issues/1166.
        transcriptText = DataUtils.getTruncatedCommandOutput(
            transcriptText,
            DataUtils.TRANSACTION_SIZE_LIMIT_IN_BYTES,
            false,
            true,
            false
        ).trim { it <= ' ' }
        ShareUtils.shareText(
            mActivity, "mActivity.getString(R.string.title_share_transcript)",
            transcriptText, "mActivity.getString(R.string.title_share_transcript_with)"
        )
    }

    fun shareSelectedText() {
        val selectedText: String = mActivity.getTerminalView().storedSelectedText!!
        if (DataUtils.isNullOrEmpty(selectedText)) return
        ShareUtils.shareText(
            mActivity, "mActivity.getString(R.string.title_share_selected_text)",
            selectedText, "mActivity.getString(R.string.title_share_selected_text_with)"
        )
    }

    fun showUrlSelection() {
        val session: TerminalSession = mActivity.getCurrentSession() ?: return
        val text = ShellUtils.getTerminalSessionTranscriptText(session, true, true)
        val urlSet = TermuxUrlUtils.extractUrls(text)
        if (urlSet.isEmpty()) {
            AlertDialog.Builder(mActivity).setMessage("R.string.title_select_url_none_found").show()
            return
        }
        val urls = urlSet.toTypedArray()
        Collections.reverse(Arrays.asList(*urls)) // Latest first.

        // Click to copy url to clipboard:
        val dialog: AlertDialog = AlertDialog.Builder(mActivity).setItems(
            urls
        ) { di: DialogInterface?, which: Int ->
            val url = urls[which] as String
            ShareUtils.copyTextToClipboard(
                mActivity,
                url,
                "mActivity.getString(R.string.msg_select_url_copied_to_clipboard)"
            )
        }.setTitle("R.string.title_select_url_dialog").create()

        // Long press to open URL:
        dialog.setOnShowListener { di: DialogInterface? ->
            val lv =
                dialog.listView // this is a ListView with your "buds" in it
            lv.onItemLongClickListener =
                AdapterView.OnItemLongClickListener { parent: AdapterView<*>?, view: View?, position: Int, id: Long ->
                    dialog.dismiss()
                    val url = urls[position] as String
                    ShareUtils.openUrl(mActivity, url)
                    true
                }
        }
        dialog.show()
    }

    fun reportIssueFromTranscript() {
        val session: TerminalSession = mActivity.getCurrentSession() ?: return
        val transcriptText =
            ShellUtils.getTerminalSessionTranscriptText(session, false, true) ?: return
        MessageDialogUtils.showMessage(
            mActivity, TermuxConstants.TERMUX_APP_NAME + " Report Issue",
            "debug info?", //mActivity.getString(R.string.msg_add_termux_debug_info),
            "yes", // mActivity.getString(R.string.action_yes),
            { dialog: DialogInterface?, which: Int ->
                reportIssueFromTranscript(
                    transcriptText,
                    true
                )
            },
            "no", //mActivity.getString(R.string.action_no),
            { dialog: DialogInterface?, which: Int ->
                reportIssueFromTranscript(
                    transcriptText,
                    false
                )
            },
            null
        )
    }

    private fun reportIssueFromTranscript(transcriptText: String, addTermuxDebugInfo: Boolean) {
//        Logger.showToast(mActivity, "report", true)
        object : Thread() {
            override fun run() {
                val reportString = StringBuilder()
                val title = TermuxConstants.TERMUX_APP_NAME + " Report Issue"
                reportString.append("## Transcript\n")
                reportString.append("\n")
                    .append(MarkdownUtils.getMarkdownCodeForString(transcriptText, true))
                reportString.append("\n##\n")
                if (addTermuxDebugInfo) {
                    reportString.append("\n\n").append(
                        TermuxUtils.getAppInfoMarkdownString(
                            mActivity,
                            TermuxUtils.AppInfoMode.TERMUX_AND_PLUGIN_PACKAGES
                        )
                    )
                } else {
                    reportString.append("\n\n").append(
                        TermuxUtils.getAppInfoMarkdownString(
                            mActivity,
                            TermuxUtils.AppInfoMode.TERMUX_PACKAGE
                        )
                    )
                }
                reportString.append("\n\n")
                    .append(AndroidUtils.getDeviceInfoMarkdownString(mActivity, true))
                if (TermuxBootstrap.isAppPackageManagerAPT()) {
                    val termuxAptInfo = TermuxUtils.geAPTInfoMarkdownString(mActivity)
                    if (termuxAptInfo != null) reportString.append("\n\n").append(termuxAptInfo)
                }
                if (addTermuxDebugInfo) {
                    val termuxDebugInfo = TermuxUtils.getTermuxDebugMarkdownString(mActivity)
                    if (termuxDebugInfo != null) reportString.append("\n\n").append(termuxDebugInfo)
                }
                val userActionName: String = "userActionName"
                val reportInfo = ReportInfo(
                    userActionName,
                    TermuxConstants.TERMUX_APP.TERMUX_ACTIVITY_NAME, title
                )
                reportInfo.setReportString(reportString.toString())
                reportInfo.setReportStringSuffix(
                    """
                        
                        
                        ${TermuxUtils.getReportIssueMarkdownString(mActivity)}
                        """.trimIndent()
                )
                reportInfo.setReportSaveFileLabelAndPath(
                    userActionName,
                    Environment.getExternalStorageDirectory().toString() + "/" +
                            FileUtils.sanitizeFileName(
                                TermuxConstants.TERMUX_APP_NAME + "-" + userActionName + ".log",
                                true,
                                true
                            )
                )
                ReportActivity.startReportActivity(mActivity, reportInfo)
            }
        }.start()
    }

    fun doPaste() {
        val session: TerminalSession = mActivity.getCurrentSession() ?: return
        if (!session.isRunning) return
        val text = ShareUtils.getTextStringFromClipboardIfSet(mActivity, true)
        if (text != null) session.emulator.paste(text)
    }

    companion object {
        private const val LOG_TAG = "TermuxTerminalViewClient"
    }
}