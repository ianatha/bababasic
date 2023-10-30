package io.atha.quickbasic

import android.annotation.SuppressLint
import android.content.Context
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase

class CrashHandler private constructor() : Thread.UncaughtExceptionHandler {
    private val handler = Handler(Looper.getMainLooper())
    private var context: Context? = null

    fun init(context: Context) {
        this.context = context.applicationContext
        Thread.setDefaultUncaughtExceptionHandler(this)
    }

    override fun uncaughtException(thread: Thread, ex: Throwable) {
        Firebase.crashlytics.recordException(ex)

        handler.post {
            Toast.makeText(
                context,
                "err_crash",
                Toast.LENGTH_SHORT
            ).show()
        }
        // Save the world, hopefully
        if (Looper.myLooper() != null) {
            while (true) {
                try {
                    Looper.loop()
                    return  // Quit loop if no exception
                } catch (t: Throwable) {
                    handler.post {
                        Toast.makeText(
                            context,
                            "err_crash",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        val INSTANCE = CrashHandler()
    }
}