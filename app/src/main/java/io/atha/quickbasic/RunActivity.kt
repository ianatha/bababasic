/*******************************************************************************
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
 ******************************************************************************/

package io.atha.quickbasic

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.termux.terminal.TerminalOutput
import io.atha.quickbasic.databinding.ActivityRunBinding


class AndroidTerminal : TerminalOutput() {
    override fun write(data: ByteArray?, offset: Int, count: Int) {
        Log.i("AndroidTerminal", "write")
    }

    override fun titleChanged(oldTitle: String?, newTitle: String?) {
        Log.i("AndroidTerminal", "title")
    }

    override fun clipboardText(text: String?) {
        Log.i("AndroidTerminal", "clipboard")
    }

    override fun onBell() {
        Log.i("AndroidTerminal", "bell")
    }

    override fun onColorsChanged() {
        Log.i("AndroidTerminal", "colors")
    }
}

class RunActivity : AppCompatActivity() {
    //    private lateinit var editor: CodeEditor
    private lateinit var binding: ActivityRunBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRunBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val s = "Hello, world!\n"

//        binding.terminal.currentSession.emulator.append(s.toByteArray(), s.length)
//        val renderer = TerminalRenderer(10, Typeface.defaultFromStyle(Typeface.MONOSPACE.style))
//        val emulator = TerminalEmulator(AndroidTerminal(), 80, 24, 100)
//        setContentView(editor)
//        editor.typefaceText = Typeface.createFromAsset(assets, "Roboto-Regular.ttf")
//        editor.setEditorLanguage(JavaLanguage())
//        switchThemeIfRequired(this, editor)
//        val text = StringBuilder("    private final PopupWindow mWindow;\r\n" +
//                "    private final CodeEditor mEditor;\r\n" +
//                "    private final int mFeatures;\n\r" +
//                "    private final int[] mLocationBuffer = new int[2];\r" +
//                "    private final EventReceiver<ScrollEvent> mScrollListener;\r\n" +
//                "    private boolean mShowState;\r" +
//                "    private boolean mRegisterFlag;\n" +
//                "    private boolean mRegistered;\n" +
//                "    private int mOffsetX, mOffsetY, mX, mY, mWidth, mHeight;")
//        for (i in 0..31) {
//            text.append(i.toChar())
//        }
//        text.append(127.toChar())
//        editor.setText(text)
//        editor.diagnostics = DiagnosticsContainer().also {
//            it.addDiagnostic(DiagnosticRegion(37, 50, DiagnosticRegion.SEVERITY_ERROR, 0L, DiagnosticDetail("TestMessage", "This is a test error message\nYou can add your content here\ntest scroll\ntest\ntest\ntest\ntest", listOf(
//                Quickfix("Fix Quick", 0L, {}), Quickfix("Test", 0L, {})
//            ))))
//        }
//        val stringText = text.toString()
//        assert(stringText == editor.text.toString()) { "Text check failed" }
    }

}