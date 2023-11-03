package io.atha.quickbasic

import android.content.Context
import android.util.TypedValue
import com.termux.shared.android.PackageUtils
import com.termux.shared.data.DataUtils
import com.termux.shared.logger.Logger
import com.termux.shared.settings.preferences.AppSharedPreferences
import com.termux.shared.settings.preferences.SharedPreferenceUtils
import com.termux.shared.termux.TermuxConstants
import com.termux.shared.termux.TermuxUtils
import com.termux.shared.termux.settings.preferences.TermuxPreferenceConstants

class AppSharedPreferences private constructor(context: Context) :
    AppSharedPreferences(
        context,
        SharedPreferenceUtils.getPrivateSharedPreferences(
            context,
            "io.atha.quickbasic" + "_preferences"
        ),
        SharedPreferenceUtils.getPrivateAndMultiProcessSharedPreferences(
            context,
            "io.atha.quickbasic" + "_preferences"
        )
    ) {
    private var MIN_FONTSIZE = 0
    private var MAX_FONTSIZE = 0
    private var DEFAULT_FONTSIZE = 0

    init {
        setFontVariables(context)
    }

    fun shouldShowTerminalToolbar(): Boolean {
        return SharedPreferenceUtils.getBoolean(
            mSharedPreferences,
            TermuxPreferenceConstants.TERMUX_APP.KEY_SHOW_TERMINAL_TOOLBAR,
            TermuxPreferenceConstants.TERMUX_APP.DEFAULT_VALUE_SHOW_TERMINAL_TOOLBAR
        )
    }

    fun setShowTerminalToolbar(value: Boolean) {
        SharedPreferenceUtils.setBoolean(
            mSharedPreferences,
            TermuxPreferenceConstants.TERMUX_APP.KEY_SHOW_TERMINAL_TOOLBAR,
            value,
            false
        )
    }

    fun toogleShowTerminalToolbar(): Boolean {
        val currentValue = shouldShowTerminalToolbar()
        setShowTerminalToolbar(!currentValue)
        return !currentValue
    }

    val isTerminalMarginAdjustmentEnabled: Boolean
        get() = SharedPreferenceUtils.getBoolean(
            mSharedPreferences,
            TermuxPreferenceConstants.TERMUX_APP.KEY_TERMINAL_MARGIN_ADJUSTMENT,
            TermuxPreferenceConstants.TERMUX_APP.DEFAULT_TERMINAL_MARGIN_ADJUSTMENT
        )

    fun setTerminalMarginAdjustment(value: Boolean) {
        SharedPreferenceUtils.setBoolean(
            mSharedPreferences,
            TermuxPreferenceConstants.TERMUX_APP.KEY_TERMINAL_MARGIN_ADJUSTMENT,
            value,
            false
        )
    }

    var isSoftKeyboardEnabled: Boolean
        get() = SharedPreferenceUtils.getBoolean(
            mSharedPreferences,
            TermuxPreferenceConstants.TERMUX_APP.KEY_SOFT_KEYBOARD_ENABLED,
            TermuxPreferenceConstants.TERMUX_APP.DEFAULT_VALUE_KEY_SOFT_KEYBOARD_ENABLED
        )
        set(value) {
            SharedPreferenceUtils.setBoolean(
                mSharedPreferences,
                TermuxPreferenceConstants.TERMUX_APP.KEY_SOFT_KEYBOARD_ENABLED,
                value,
                false
            )
        }
    var isSoftKeyboardEnabledOnlyIfNoHardware: Boolean
        get() = SharedPreferenceUtils.getBoolean(
            mSharedPreferences,
            TermuxPreferenceConstants.TERMUX_APP.KEY_SOFT_KEYBOARD_ENABLED_ONLY_IF_NO_HARDWARE,
            TermuxPreferenceConstants.TERMUX_APP.DEFAULT_VALUE_KEY_SOFT_KEYBOARD_ENABLED_ONLY_IF_NO_HARDWARE
        )
        set(value) {
            SharedPreferenceUtils.setBoolean(
                mSharedPreferences,
                TermuxPreferenceConstants.TERMUX_APP.KEY_SOFT_KEYBOARD_ENABLED_ONLY_IF_NO_HARDWARE,
                value,
                false
            )
        }

    fun shouldKeepScreenOn(): Boolean {
        return SharedPreferenceUtils.getBoolean(
            mSharedPreferences,
            TermuxPreferenceConstants.TERMUX_APP.KEY_KEEP_SCREEN_ON,
            TermuxPreferenceConstants.TERMUX_APP.DEFAULT_VALUE_KEEP_SCREEN_ON
        )
    }

    fun setKeepScreenOn(value: Boolean) {
        SharedPreferenceUtils.setBoolean(
            mSharedPreferences,
            TermuxPreferenceConstants.TERMUX_APP.KEY_KEEP_SCREEN_ON,
            value,
            false
        )
    }

    fun setFontVariables(context: Context) {
        val sizes = getDefaultFontSizes(context)
        DEFAULT_FONTSIZE = sizes[0]
        MIN_FONTSIZE = sizes[1]
        MAX_FONTSIZE = sizes[2]
    }

    var fontSize: Int
        get() {
            val fontSize = SharedPreferenceUtils.getIntStoredAsString(
                mSharedPreferences,
                TermuxPreferenceConstants.TERMUX_APP.KEY_FONTSIZE,
                DEFAULT_FONTSIZE
            )
            return DataUtils.clamp(fontSize, MIN_FONTSIZE, MAX_FONTSIZE)
        }
        set(value) {
            SharedPreferenceUtils.setIntStoredAsString(
                mSharedPreferences,
                TermuxPreferenceConstants.TERMUX_APP.KEY_FONTSIZE,
                value,
                false
            )
        }

    fun changeFontSize(increase: Boolean) {
        var fontSize = fontSize
        fontSize += (if (increase) 1 else -1) * 2
        fontSize = Math.max(MIN_FONTSIZE, Math.min(fontSize, MAX_FONTSIZE))
        this.fontSize = fontSize
    }

    var currentSession: String?
        get() = SharedPreferenceUtils.getString(
            mSharedPreferences,
            TermuxPreferenceConstants.TERMUX_APP.KEY_CURRENT_SESSION,
            null,
            true
        )
        set(value) {
            SharedPreferenceUtils.setString(
                mSharedPreferences,
                TermuxPreferenceConstants.TERMUX_APP.KEY_CURRENT_SESSION,
                value,
                false
            )
        }
    val logLevel: Int
        get() = SharedPreferenceUtils.getInt(
            mSharedPreferences,
            TermuxPreferenceConstants.TERMUX_APP.KEY_LOG_LEVEL,
            Logger.DEFAULT_LOG_LEVEL
        )

    fun setLogLevel(context: Context?, logLevel: Int) {
        var logLevel = logLevel
        logLevel = Logger.setLogLevel(context, logLevel)
        SharedPreferenceUtils.setInt(
            mSharedPreferences,
            TermuxPreferenceConstants.TERMUX_APP.KEY_LOG_LEVEL,
            logLevel,
            false
        )
    }

    var lastNotificationId: Int
        get() = SharedPreferenceUtils.getInt(
            mSharedPreferences,
            TermuxPreferenceConstants.TERMUX_APP.KEY_LAST_NOTIFICATION_ID,
            TermuxPreferenceConstants.TERMUX_APP.DEFAULT_VALUE_KEY_LAST_NOTIFICATION_ID
        )
        set(notificationId) {
            SharedPreferenceUtils.setInt(
                mSharedPreferences,
                TermuxPreferenceConstants.TERMUX_APP.KEY_LAST_NOTIFICATION_ID,
                notificationId,
                false
            )
        }

    @get:Synchronized
    val andIncrementAppShellNumberSinceBoot: Int
        get() =// Keep value at MAX_VALUE on integer overflow and not 0, since not first shell
            SharedPreferenceUtils.getAndIncrementInt(
                mSharedPreferences,
                TermuxPreferenceConstants.TERMUX_APP.KEY_APP_SHELL_NUMBER_SINCE_BOOT,
                TermuxPreferenceConstants.TERMUX_APP.DEFAULT_VALUE_APP_SHELL_NUMBER_SINCE_BOOT,
                true,
                Int.MAX_VALUE
            )

    @Synchronized
    fun resetAppShellNumberSinceBoot() {
        SharedPreferenceUtils.setInt(
            mSharedPreferences,
            TermuxPreferenceConstants.TERMUX_APP.KEY_APP_SHELL_NUMBER_SINCE_BOOT,
            TermuxPreferenceConstants.TERMUX_APP.DEFAULT_VALUE_APP_SHELL_NUMBER_SINCE_BOOT,
            true
        )
    }

    @get:Synchronized
    val andIncrementTerminalSessionNumberSinceBoot: Int
        get() =// Keep value at MAX_VALUE on integer overflow and not 0, since not first shell
            SharedPreferenceUtils.getAndIncrementInt(
                mSharedPreferences,
                TermuxPreferenceConstants.TERMUX_APP.KEY_TERMINAL_SESSION_NUMBER_SINCE_BOOT,
                TermuxPreferenceConstants.TERMUX_APP.DEFAULT_VALUE_TERMINAL_SESSION_NUMBER_SINCE_BOOT,
                true,
                Int.MAX_VALUE
            )

    @Synchronized
    fun resetTerminalSessionNumberSinceBoot() {
        SharedPreferenceUtils.setInt(
            mSharedPreferences,
            TermuxPreferenceConstants.TERMUX_APP.KEY_TERMINAL_SESSION_NUMBER_SINCE_BOOT,
            TermuxPreferenceConstants.TERMUX_APP.DEFAULT_VALUE_TERMINAL_SESSION_NUMBER_SINCE_BOOT,
            true
        )
    }

    var isTerminalViewKeyLoggingEnabled: Boolean
        get() = SharedPreferenceUtils.getBoolean(
            mSharedPreferences,
            TermuxPreferenceConstants.TERMUX_APP.KEY_TERMINAL_VIEW_KEY_LOGGING_ENABLED,
            TermuxPreferenceConstants.TERMUX_APP.DEFAULT_VALUE_TERMINAL_VIEW_KEY_LOGGING_ENABLED
        )
        set(value) {
            SharedPreferenceUtils.setBoolean(
                mSharedPreferences,
                TermuxPreferenceConstants.TERMUX_APP.KEY_TERMINAL_VIEW_KEY_LOGGING_ENABLED,
                value,
                false
            )
        }

    fun arePluginErrorNotificationsEnabled(readFromFile: Boolean): Boolean {
        return if (readFromFile) SharedPreferenceUtils.getBoolean(
            mMultiProcessSharedPreferences,
            TermuxPreferenceConstants.TERMUX_APP.KEY_PLUGIN_ERROR_NOTIFICATIONS_ENABLED,
            TermuxPreferenceConstants.TERMUX_APP.DEFAULT_VALUE_PLUGIN_ERROR_NOTIFICATIONS_ENABLED
        ) else SharedPreferenceUtils.getBoolean(
            mSharedPreferences,
            TermuxPreferenceConstants.TERMUX_APP.KEY_PLUGIN_ERROR_NOTIFICATIONS_ENABLED,
            TermuxPreferenceConstants.TERMUX_APP.DEFAULT_VALUE_PLUGIN_ERROR_NOTIFICATIONS_ENABLED
        )
    }

    fun setPluginErrorNotificationsEnabled(value: Boolean) {
        SharedPreferenceUtils.setBoolean(
            mSharedPreferences,
            TermuxPreferenceConstants.TERMUX_APP.KEY_PLUGIN_ERROR_NOTIFICATIONS_ENABLED,
            value,
            false
        )
    }

    fun areCrashReportNotificationsEnabled(readFromFile: Boolean): Boolean {
        return if (readFromFile) SharedPreferenceUtils.getBoolean(
            mMultiProcessSharedPreferences,
            TermuxPreferenceConstants.TERMUX_APP.KEY_CRASH_REPORT_NOTIFICATIONS_ENABLED,
            TermuxPreferenceConstants.TERMUX_APP.DEFAULT_VALUE_CRASH_REPORT_NOTIFICATIONS_ENABLED
        ) else SharedPreferenceUtils.getBoolean(
            mSharedPreferences,
            TermuxPreferenceConstants.TERMUX_APP.KEY_CRASH_REPORT_NOTIFICATIONS_ENABLED,
            TermuxPreferenceConstants.TERMUX_APP.DEFAULT_VALUE_CRASH_REPORT_NOTIFICATIONS_ENABLED
        )
    }

    fun setCrashReportNotificationsEnabled(value: Boolean) {
        SharedPreferenceUtils.setBoolean(
            mSharedPreferences,
            TermuxPreferenceConstants.TERMUX_APP.KEY_CRASH_REPORT_NOTIFICATIONS_ENABLED,
            value,
            false
        )
    }

    companion object {
        private const val LOG_TAG = "TermuxAppSharedPreferences"

        /**
         * Get [AppSharedPreferences].
         *
         * @param context The [Context] to use to get the [Context] of the
         * [TermuxConstants.TERMUX_PACKAGE_NAME].
         * @return Returns the [AppSharedPreferences]. This will `null` if an exception is raised.
         */
        fun build(context: Context): io.atha.quickbasic.AppSharedPreferences? {
            val termuxPackageContext =
                PackageUtils.getContextForPackage(context, "io.atha.quickbasic")
            return termuxPackageContext?.let { AppSharedPreferences(it) }
        }

        /**
         * Get [AppSharedPreferences].
         *
         * @param context The [Context] to use to get the [Context] of the
         * [TermuxConstants.TERMUX_PACKAGE_NAME].
         * @param exitAppOnError If `true` and failed to get package context, then a dialog will
         * be shown which when dismissed will exit the app.
         * @return Returns the [AppSharedPreferences]. This will `null` if an exception is raised.
         */
        fun build(
            context: Context,
            exitAppOnError: Boolean
        ): io.atha.quickbasic.AppSharedPreferences {
            val termuxPackageContext = TermuxUtils.getContextForPackageOrExitApp(
                context,
                "io.atha.quickbasic",
                exitAppOnError
            )
            return termuxPackageContext?.let { AppSharedPreferences(it) }!!
        }

        fun getDefaultFontSizes(context: Context): IntArray {
            val dipInPixels = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                1f,
                context.resources.displayMetrics
            )
            val sizes = IntArray(3)

            // This is a bit arbitrary and sub-optimal. We want to give a sensible default for minimum font size
            // to prevent invisible text due to zoom be mistake:
            sizes[1] = (4f * dipInPixels).toInt() // min

            // http://www.google.com/design/spec/style/typography.html#typography-line-height
            var defaultFontSize = Math.round(12 * dipInPixels)
            // Make it divisible by 2 since that is the minimal adjustment step:
            if (defaultFontSize % 2 == 1) defaultFontSize--
            sizes[0] = defaultFontSize // default
            sizes[2] = 256 // max
            return sizes
        }
    }
}