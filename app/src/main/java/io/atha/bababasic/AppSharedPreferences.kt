package io.atha.bababasic

import android.content.Context
import android.util.TypedValue

class AppSharedPreferences {
    private var MIN_FONTSIZE = 0
    private var MAX_FONTSIZE = 0
    private var DEFAULT_FONTSIZE = 0

    init {
    }

    fun shouldShowTerminalToolbar(): Boolean {
        return true
    }

    fun setShowTerminalToolbar(value: Boolean) {
    }

    fun toogleShowTerminalToolbar(): Boolean {
        val currentValue = shouldShowTerminalToolbar()
        setShowTerminalToolbar(!currentValue)
        return !currentValue
    }

    val isTerminalMarginAdjustmentEnabled: Boolean = true

    fun setTerminalMarginAdjustment(value: Boolean) {
        //
    }

    var isSoftKeyboardEnabled: Boolean = true

    var isSoftKeyboardEnabledOnlyIfNoHardware = false

    fun shouldKeepScreenOn(): Boolean {
        return true
    }

    fun setKeepScreenOn(value: Boolean) {

    }

    fun setFontVariables(context: Context) {
        val sizes = getDefaultFontSizes(context)
        DEFAULT_FONTSIZE = sizes[0]
        MIN_FONTSIZE = sizes[1]
        MAX_FONTSIZE = sizes[2]
    }

    var fontSize: Int = 36

    fun changeFontSize(increase: Boolean) {
        var fontSize = fontSize
        fontSize += (if (increase) 1 else -1) * 2
        fontSize = Math.max(MIN_FONTSIZE, Math.min(fontSize, MAX_FONTSIZE))
        this.fontSize = fontSize
    }

    var currentSession: String? = null
    val logLevel: Int = 0

    fun setLogLevel(context: Context?, logLevel: Int) {
    }

    var lastNotificationId: Int = 0

    @get:Synchronized
    val andIncrementAppShellNumberSinceBoot: Int = 1

    @Synchronized
    fun resetAppShellNumberSinceBoot() {
    }

    @get:Synchronized
    val andIncrementTerminalSessionNumberSinceBoot: Int = 2

    @Synchronized
    fun resetTerminalSessionNumberSinceBoot() {
    }

    var isTerminalViewKeyLoggingEnabled: Boolean = false

    fun arePluginErrorNotificationsEnabled(readFromFile: Boolean): Boolean {
        return true

    }

    fun setPluginErrorNotificationsEnabled(value: Boolean) {
    }

    fun areCrashReportNotificationsEnabled(readFromFile: Boolean): Boolean {
        return true
    }

    fun setCrashReportNotificationsEnabled(value: Boolean) {
    }

    companion object {
        private const val LOG_TAG = "TermuxAppSharedPreferences"

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