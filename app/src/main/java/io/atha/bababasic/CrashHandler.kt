package io.atha.bababasic

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.ApplicationInfo
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase

class CrashHandler private constructor() : Thread.UncaughtExceptionHandler {
    private val handler = Handler(Looper.getMainLooper())
    private lateinit var context: Context
    private var isDebugBuild: Boolean = false

    fun init(context: Context) {
        this.context = context.applicationContext
        val applicationInfo = context.packageManager.getApplicationInfo(context.packageName, 0)
        isDebugBuild = 0 != applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE
        Thread.setDefaultUncaughtExceptionHandler(this)
    }

    private fun handleException(ex: Throwable) {
        Log.e("CrashHandler", "Trapped exception", ex)
        if (!isDebugBuild) {
            Firebase.crashlytics.recordException(ex)
        }

        handler.post {
            Toast.makeText(
                context,
                context.resources.getString(R.string.crash),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun uncaughtException(thread: Thread, ex: Throwable) {
        handleException(ex)

        // Save the world, hopefully
        if (Looper.myLooper() != null) {
            while (true) {
                try {
                    Looper.loop()
                    return
                } catch (t: Throwable) {
                    handleException(t)
                }
            }
        }
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        val INSTANCE = CrashHandler()
    }
}