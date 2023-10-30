/*
 *    sora-editor - the awesome code editor for Android
 *    https://github.com/Rosemoe/sora-editor
 *    Copyright (C) 2020-2023  Rosemoe
 *
 *     This library is free software; you can redistribute it and/or
 *     modify it under the terms of the GNU Lesser General Public
 *     License as published by the Free Software Foundation; either
 *     version 2.1 of the License, or (at your option) any later version.
 *
 *     This library is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *     Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public
 *     License along with this library; if not, write to the Free Software
 *     Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301
 *     USA
 *
 *     Please contact Rosemoe by email 2073412493@qq.com if you need
 *     additional information or have any questions
 */
package io.atha.quickbasic

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import java.io.PrintWriter
import java.io.StringWriter
import java.io.Writer
import java.text.SimpleDateFormat
import java.util.Arrays
import java.util.Date

/**
 * CrashHandler handles uncaught exceptions
 * And force the main thread continue to work
 *
 * @author Rosemoe
 */
class CrashHandler private constructor() : Thread.UncaughtExceptionHandler {
    private val handler = Handler(Looper.getMainLooper())
    private var context: Context? = null
    private val info: MutableMap<String, String> = HashMap()
    fun init(context: Context) {
        this.context = context.applicationContext
        collectDeviceInfo(this.context)
        Thread.setDefaultUncaughtExceptionHandler(this)
    }

    override fun uncaughtException(thread: Thread, ex: Throwable) {
        saveCrashInfo(thread.name, ex)
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
                    saveCrashInfo(thread.name, t)
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

    fun collectDeviceInfo(ctx: Context?) {
        try {
            val pm = ctx!!.packageManager
            val pi = pm.getPackageInfo(ctx.packageName, PackageManager.GET_ACTIVITIES)
            if (pi != null) {
                val versionName = if (pi.versionName == null) "null" else pi.versionName
                @Suppress("DEPRECATION") val versionCode = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    pi.longVersionCode.toString()
                } else {
                    pi.versionCode.toString()
                }
                info["versionName"] = versionName
                info["versionCode"] = versionCode
            }
        } catch (e: PackageManager.NameNotFoundException) {
            Log.e(LOG_TAG, "an error occurred while collecting package info", e)
        }
        var fields = Build::class.java.declaredFields
        for (field in fields) {
            try {
                field.isAccessible = true
                val obj = field[null]
                if (obj is Array<*> && obj.isArrayOf<String>()) {
                    info[field.name] = Arrays.toString(obj as Array<String?>)
                } else {
                    info[field.name] = obj.toString()
                }
            } catch (e: Exception) {
                Log.e(LOG_TAG, "an error occurred while collecting crash info", e)
            }
        }
        fields = Build.VERSION::class.java.declaredFields
        for (field in fields) {
            try {
                field.isAccessible = true
                val obj = field[null]
                if (obj is Array<*> && obj.isArrayOf<String>()) {
                    info[field.name] = Arrays.toString(obj as Array<String?>)
                } else {
                    info[field.name] = obj.toString()
                }
            } catch (e: Exception) {
                Log.e(LOG_TAG, "an error occurred while collecting crash info", e)
            }
        }
    }

    private fun saveCrashInfo(threadName: String, ex: Throwable) {
        val sb = StringBuilder()
        val timestamp = System.currentTimeMillis()
        sb.append("Crash at ").append(timestamp).append("(timestamp) in thread named '")
            .append(threadName).append("'\n")
        sb.append("Local date and time:")
            .append(SimpleDateFormat.getDateTimeInstance().format(Date(timestamp))).append('\n')
        info.forEach { (key, value) ->
            sb.append(key).append("=").append(value).append("\n")
        }
        val writer: Writer = StringWriter()
        val printWriter = PrintWriter(writer)
        ex.printStackTrace(printWriter)
        var cause = ex.cause
        while (cause != null) {
            cause.printStackTrace(printWriter)
            cause = cause.cause
        }
        printWriter.close()
        val result = writer.toString()
        sb.append(result).append('\n')
        try {
            Log.e(LOG_TAG, sb.toString())
            val fos = context!!.openFileOutput("crash-journal.log", Context.MODE_APPEND)
            fos.write(sb.toString().toByteArray())
            fos.close()
        } catch (e: Exception) {
            Log.e(LOG_TAG, "an error occurred while writing file...", e)
        }
    }

    companion object {
        const val LOG_TAG = "CrashHandler"

        @SuppressLint("StaticFieldLeak")
        val INSTANCE = CrashHandler()
    }
}