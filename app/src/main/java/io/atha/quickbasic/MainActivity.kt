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

//import com.itsaky.androidide.treesitter.java.TSLanguageJava

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.Intent.EXTRA_LOCAL_ONLY
import android.content.res.Configuration
import android.graphics.Typeface
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.KeyEvent
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.contract.ActivityResultContracts.GetContent
import androidx.appcompat.app.AppCompatActivity
import com.google.android.play.core.appupdate.AppUpdateManagerFactory
import com.google.android.play.core.install.model.AppUpdateType
import com.google.android.play.core.install.model.UpdateAvailability
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import io.atha.quickbasic.databinding.ActivityMainBinding
import io.atha.quickbasic.editor.switchThemeIfRequired
import io.github.rosemoe.sora.event.ContentChangeEvent
import io.github.rosemoe.sora.event.EditorKeyEvent
import io.github.rosemoe.sora.event.KeyBindingEvent
import io.github.rosemoe.sora.event.PublishSearchResultEvent
import io.github.rosemoe.sora.event.SelectionChangeEvent
import io.github.rosemoe.sora.event.SideIconClickEvent
import io.github.rosemoe.sora.lang.diagnostic.DiagnosticRegion
import io.github.rosemoe.sora.lang.diagnostic.DiagnosticsContainer
import io.github.rosemoe.sora.langs.textmate.TextMateColorScheme
import io.github.rosemoe.sora.langs.textmate.TextMateLanguage
import io.github.rosemoe.sora.langs.textmate.registry.FileProviderRegistry
import io.github.rosemoe.sora.langs.textmate.registry.GrammarRegistry
import io.github.rosemoe.sora.langs.textmate.registry.ThemeRegistry
import io.github.rosemoe.sora.langs.textmate.registry.model.DefaultGrammarDefinition
import io.github.rosemoe.sora.langs.textmate.registry.model.ThemeModel
import io.github.rosemoe.sora.langs.textmate.registry.provider.AssetsFileResolver
import io.github.rosemoe.sora.text.LineSeparator
import io.github.rosemoe.sora.widget.CodeEditor
import io.github.rosemoe.sora.widget.EditorSearcher.SearchOptions
import io.github.rosemoe.sora.widget.component.EditorAutoCompletion
import io.github.rosemoe.sora.widget.component.Magnifier
import io.github.rosemoe.sora.widget.getComponent
import io.github.rosemoe.sora.widget.subscribeEvent
import org.eclipse.tm4e.core.registry.IGrammarSource
import org.eclipse.tm4e.core.registry.IThemeSource
import org.puffinbasic.PuffinBasicInterpreterMain.checkSyntax
import org.puffinbasic.error.PuffinBasicSyntaxError
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStream
import java.util.regex.PatternSyntaxException
import java.util.stream.Collectors


class MainActivity : AppCompatActivity() {
    private lateinit var firebaseAnalytics: FirebaseAnalytics
    private lateinit var binding: ActivityMainBinding
    private lateinit var searchMenu: PopupMenu
    private var searchOptions = SearchOptions(false, false)
    private var undo: MenuItem? = null
    private var redo: MenuItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firebaseAnalytics = Firebase.analytics
        CrashHandler.INSTANCE.init(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val inputView = binding.symbolInput
        inputView.bindEditor(binding.editor)
        val typeface = Typeface.createFromAsset(assets, "JetBrainsMono-Regular.ttf")
        inputView.addSymbols(
            arrayOf(
                "->",
                "=",
                "$",
                "%",
                "(",
                ")",
                "\"",
                ",",
                ".",
                "+",
                "-",
                "*",
                "/"
            ), arrayOf("\t", "=", "$", "%", "(", ")", "\"", ",", ".", "+", "-", "*", "/")
        )
        inputView.forEachButton {
            it.typeface = typeface
        }
        binding.searchEditor.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                tryCommitSearch()
            }
        })
        searchMenu = PopupMenu(this, binding.searchOptions)
        searchMenu.inflate(R.menu.menu_search_options)
        searchMenu.setOnMenuItemClickListener {
            it.isChecked = !it.isChecked
            val ignoreCase = !searchMenu.menu.findItem(R.id.search_option_match_case)!!.isChecked
            if (it.isChecked) {
                when (it.itemId) {
                    R.id.search_option_regex -> {
                        searchMenu.menu.findItem(R.id.search_option_whole_word)!!.isChecked = false
                    }

                    R.id.search_option_whole_word -> {
                        searchMenu.menu.findItem(R.id.search_option_regex)!!.isChecked = false
                    }
                }
            }
            var type = SearchOptions.TYPE_NORMAL
            val regex = searchMenu.menu.findItem(R.id.search_option_regex)!!.isChecked
            if (regex) {
                type = SearchOptions.TYPE_REGULAR_EXPRESSION
            }
            val wholeWord = searchMenu.menu.findItem(R.id.search_option_whole_word)!!.isChecked
            if (wholeWord) {
                type = SearchOptions.TYPE_WHOLE_WORD
            }
            searchOptions = SearchOptions(type, ignoreCase)
            tryCommitSearch()
            true
        }
        binding.editor.apply {
            typefaceText = typeface
            props.stickyScroll = true
            setLineSpacing(2f, 1.1f)
            nonPrintablePaintingFlags =
                CodeEditor.FLAG_DRAW_WHITESPACE_LEADING or CodeEditor.FLAG_DRAW_LINE_SEPARATOR or CodeEditor.FLAG_DRAW_WHITESPACE_IN_SELECTION
            // Update display dynamically
            subscribeEvent<SelectionChangeEvent> { _, _ -> updatePositionText() }
            subscribeEvent<PublishSearchResultEvent> { _, _ -> updatePositionText() }
            subscribeEvent<ContentChangeEvent> { _, _ ->
                postDelayedInLifecycle(
                    ::updateBtnState,
                    50
                )
            }
            subscribeEvent<SideIconClickEvent> { _, _ ->
                Toast.makeText(this@MainActivity, "Side icon clicked", Toast.LENGTH_SHORT).show()
            }

            subscribeEvent<KeyBindingEvent> { event, _ ->
                if (event.eventType != EditorKeyEvent.Type.DOWN) {
                    return@subscribeEvent
                }
            }

            getComponent<EditorAutoCompletion>()
                .setEnabledAnimation(true)
        }


        loadDefaultThemes()
        loadDefaultLanguages()

        ensureTextmateTheme()

        val editor = binding.editor
        val language = TextMateLanguage.create(
            "source.qbasic", true
        )

        editor.setEditorLanguage(language)
        editor.isLineNumberEnabled = true
        editor.setPinLineNumber(true)
        editor.getComponent(Magnifier::class.java).isEnabled = true

        updatePositionText()
        updateBtnState()

        switchThemeIfRequired(this, binding.editor)

        checkForUpdates()
    }

    private fun checkForUpdates() {
        val appUpdateManager = AppUpdateManagerFactory.create(this)
        val appUpdateInfoTask = appUpdateManager.appUpdateInfo

        val activityResultLauncher =
            registerForActivityResult(ActivityResultContracts.StartIntentSenderForResult()) { result: ActivityResult ->
                Log.i("app", "info $result")
            }

        appUpdateInfoTask.addOnSuccessListener { appUpdateInfo ->
            if (appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE
                && appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.IMMEDIATE)
            ) {
                appUpdateManager.startUpdateFlowForResult(
                    appUpdateInfo,
                    AppUpdateType.IMMEDIATE,
                    this,
                    1011
                )
            } else {
                Log.i("app", "no update available")
            }
        }
    }

    private fun tryCommitSearch() {
        val editable = binding.searchEditor.editableText
        if (editable.isNotEmpty()) {
            try {
                binding.editor.searcher.search(
                    editable.toString(),
                    searchOptions
                )
            } catch (e: PatternSyntaxException) {
                // Regex error
            }
        } else {
            binding.editor.searcher.stopSearch()
        }
    }


    private /*suspend*/ fun loadDefaultThemes() /*= withContext(Dispatchers.IO)*/ {

        //add assets file provider
        FileProviderRegistry.getInstance().addFileProvider(
            AssetsFileResolver(
                applicationContext.assets
            )
        )


        val themes = arrayOf("darcula", "abyss", "quietlight", "solarized_drak")
        val themeRegistry = ThemeRegistry.getInstance()
        themes.forEach { name ->
            val path = "textmate/$name.json"
            themeRegistry.loadTheme(
                ThemeModel(
                    IThemeSource.fromInputStream(
                        FileProviderRegistry.getInstance().tryGetInputStream(path), path, null
                    ), name
                ).apply {
                    if (name != "quietlight") {
                        isDark = true
                    }
                }
            )
        }

        themeRegistry.setTheme("quietlight")
    }

    private /*suspend*/ fun loadDefaultLanguages() /*= withContext(Dispatchers.Main)*/ {
        GrammarRegistry.getInstance().loadGrammars("textmate/languages.json")
    }

    private fun setupDiagnostics() {
        val editor = binding.editor
        val container = DiagnosticsContainer()
        for (i in 0 until editor.text.lineCount) {
            val index = editor.text.getCharIndex(i, 0)
            container.addDiagnostic(
                DiagnosticRegion(
                    index,
                    index + editor.text.getColumnCount(i),
                    DiagnosticRegion.SEVERITY_ERROR
                )
            )
        }
        editor.diagnostics = container
    }

    private fun ensureTextmateTheme() {
        val editor = binding.editor
        var editorColorScheme = editor.colorScheme
        if (editorColorScheme !is TextMateColorScheme) {
            editorColorScheme = TextMateColorScheme.create(ThemeRegistry.getInstance())
            editor.colorScheme = editorColorScheme
        }
    }

    private fun generateKeybindingString(event: KeyBindingEvent): String {
        val sb = StringBuilder()
        if (event.isCtrlPressed) {
            sb.append("Ctrl + ")
        }

        if (event.isAltPressed) {
            sb.append("Alt + ")
        }

        if (event.isShiftPressed) {
            sb.append("Shift + ")
        }

        sb.append(KeyEvent.keyCodeToString(event.keyCode))
        return sb.toString()
    }

    private fun updateBtnState() {
        undo?.isEnabled = binding.editor.canUndo()
        redo?.isEnabled = binding.editor.canRedo()
    }

    private fun updatePositionText() {
        val cursor = binding.editor.cursor
        var text =
            (1 + cursor.leftLine).toString() + ":" + cursor.leftColumn + ";" + cursor.left + " "
        text += if (cursor.isSelected) {
            "(" + (cursor.right - cursor.left) + " chars)"
        } else {
            val content = binding.editor.text
            if (content.getColumnCount(cursor.leftLine) == cursor.leftColumn) {
                "(<" + content.getLine(cursor.leftLine).lineSeparator.let {
                    if (it == LineSeparator.NONE) {
                        "EOF"
                    } else {
                        it.name
                    }
                } + ">)"
            } else {
                val char = binding.editor.text.charAt(
                    cursor.leftLine,
                    cursor.leftColumn
                )
                if (char.isLowSurrogate() && cursor.leftColumn > 0) {
                    "(" + String(
                        charArrayOf(
                            binding.editor.text.charAt(
                                cursor.leftLine,
                                cursor.leftColumn - 1
                            ), char
                        )
                    ) + ")"
                } else if (char.isHighSurrogate() && cursor.leftColumn + 1 < binding.editor.text.getColumnCount(
                        cursor.leftLine
                    )
                ) {
                    "(" + String(
                        charArrayOf(
                            char, binding.editor.text.charAt(
                                cursor.leftLine,
                                cursor.leftColumn + 1
                            )
                        )
                    ) + ")"
                } else {
                    "(" + escapeIfNecessary(
                        binding.editor.text.charAt(
                            cursor.leftLine,
                            cursor.leftColumn
                        )
                    ) + ")"
                }
            }
        }
        val searcher = binding.editor.searcher
        if (searcher.hasQuery()) {
            val idx = searcher.currentMatchedPositionIndex
            val matchText = when (val count = searcher.matchedPositionCount) {
                0 -> {
                    "no match"
                }

                1 -> {
                    "1 match"
                }

                else -> {
                    "$count matches"
                }
            }
            text += if (idx == -1) {
                "($matchText)"
            } else {
                "(${idx + 1} of $matchText)"
            }
        }
    }

    private fun escapeIfNecessary(c: Char): String {
        return when (c) {
            '\n' -> "\\n"
            '\t' -> "\\t"
            '\r' -> "\\r"
            ' ' -> "<ws>"
            else -> c.toString()
        }
    }

    private val loadTMLLauncher = registerForActivityResult(GetContent()) { result: Uri? ->
        try {
            if (result == null) return@registerForActivityResult


            val editorLanguage = binding.editor.editorLanguage

            val language = if (editorLanguage is TextMateLanguage) {
                editorLanguage.updateLanguage(
                    DefaultGrammarDefinition.withGrammarSource(
                        IGrammarSource.fromInputStream(
                            contentResolver.openInputStream(result),
                            result.path, null
                        ),
                    )
                )
                editorLanguage
            } else {
                TextMateLanguage.create(
                    DefaultGrammarDefinition.withGrammarSource(
                        IGrammarSource.fromInputStream(
                            contentResolver.openInputStream(result),
                            result.path, null
                        ),
                    ), true
                )
            }
            binding.editor.setEditorLanguage(language)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        switchThemeIfRequired(this, binding.editor)
    }

    override fun onPause() {
        Log.i("qb", "pause")
        val sharedPref = getPreferences(Context.MODE_PRIVATE)!!
        with (sharedPref.edit()) {
            putString("editor_context", binding.editor.text.toString())
            apply()
        }

        super.onPause()
    }

    override fun onResume() {
        Log.i("qb", "resume")
        super.onResume()
        val sharedPref = getPreferences(Context.MODE_PRIVATE)!!
        sharedPref.getString("editor_context", "10 PRINT \"HELLO WORLD\"")?.let {
            binding.editor.setText(it)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        undo = menu.findItem(R.id.text_undo)
        redo = menu.findItem(R.id.text_redo)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == OPEN_DOCUMENT_REQUEST_ID && resultCode == RESULT_OK) {
            val selectedfile = data!!.data!!
            val inputStream = contentResolver.openInputStream(selectedfile)
            val reader = BufferedReader(InputStreamReader(inputStream))
            val contents = reader.lines().collect(Collectors.joining("\n"))
            binding.editor.setText(contents)
            val sharedPref = getPreferences(Context.MODE_PRIVATE)!!
            with (sharedPref.edit()) {
                putString("editor_context", contents)
                apply()
            }
        } else if (requestCode == CREATE_DOCUMENT_REQUEST_ID && resultCode == RESULT_OK) {
            val uri: Uri = data!!.data!!
            try {
                val output: OutputStream = contentResolver.openOutputStream(uri)!!
                output.write(binding.editor.text.toString().toByteArray(Charsets.UTF_8))
                output.flush()
                output.close()
            } catch (e: IOException) {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private val OPEN_DOCUMENT_REQUEST_ID = 0x87133
    private val CREATE_DOCUMENT_REQUEST_ID = 0x87134
    override fun onDestroy() {
        super.onDestroy()
        binding.editor.release()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        val editor = binding.editor
        when (id) {
            R.id.open_file -> {
                val intent = Intent()
                    .setType("text/plain")
                    .putExtra(EXTRA_LOCAL_ONLY, true)
                    .setAction(Intent.ACTION_GET_CONTENT)

                startActivityForResult(
                    Intent.createChooser(
                        intent,
                        resources.getString(R.string.open_file)
                    ), OPEN_DOCUMENT_REQUEST_ID
                )
            }

            R.id.save_file -> {
                val intent = Intent()
                    .setType("text/plain")
                    .putExtra(EXTRA_LOCAL_ONLY, true)
                    .putExtra(Intent.EXTRA_TITLE, "untitled.bas")
                    .setAction(Intent.ACTION_CREATE_DOCUMENT)
                    .addCategory(Intent.CATEGORY_OPENABLE)

                startActivityForResult(
                    Intent.createChooser(
                        intent,
                        resources.getString(R.string.save_file)
                    ), CREATE_DOCUMENT_REQUEST_ID
                )
            }

            R.id.text_undo -> editor.undo()
            R.id.text_redo -> editor.redo()

            R.id.run_script -> {
                val text = editor.text.toString()
                try {
                    checkSyntax("input.bas", text)
                } catch (e: PuffinBasicSyntaxError) {
                    val lines = text.split("\n")
                    val rowToIndex = (0 until ((e.row ?: 1) - 1)).sumOf { lines[it].length } + (e.col ?: 0)
                    val diagnostics = DiagnosticsContainer()
                    diagnostics.addDiagnostic(
                        DiagnosticRegion(
                            rowToIndex,
                            rowToIndex + 2,
                            DiagnosticRegion.SEVERITY_ERROR
                        )
                    )
                    binding.editor.diagnostics = diagnostics
                    AlertDialog.Builder(this)
                        .setTitle("Syntax Error")
                        .setMessage(e.message)
                        .setPositiveButton(
                            android.R.string.ok
                        ) { dialog, which ->
                            // Continue with delete operation
                        } // A null listener allows the button to dismiss the dialog and take no further action.
                        .show()
                    return true
                }
                // run the RunActivity intent
                val intent = Intent(this, RunActivity::class.java)
                intent.putExtra(
                    "datum", RunDatum(text)
                )
                startActivity(intent)
            }

            R.id.about -> {
                // Trigger the AboutActivity
                startActivity(Intent(this, AboutActivity::class.java))
            }

            R.id.search_panel_st -> {
                if (binding.searchPanel.visibility == View.GONE) {
                    binding.apply {
                        replaceEditor.setText("")
                        searchEditor.setText("")
                        editor.searcher.stopSearch()
                        searchPanel.visibility = View.VISIBLE
                    }
                } else {
                    binding.searchPanel.visibility = View.GONE
                    editor.searcher.stopSearch()
                }
            }

            R.id.text_wordwrap -> {
                item.isChecked = !item.isChecked
                editor.isWordwrap = item.isChecked
            }

            R.id.editor_line_number -> {
                editor.isLineNumberEnabled = !editor.isLineNumberEnabled
                item.isChecked = editor.isLineNumberEnabled
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun gotoNext(view: View?) {
        try {
            binding.editor.searcher.gotoNext()
        } catch (e: IllegalStateException) {
            e.printStackTrace()
        }
    }

    fun closeSearchPanel(view: View?) {
        binding.searchPanel.visibility = View.GONE
        binding.editor.searcher.stopSearch()
    }

    fun gotoLast(view: View?) {
        try {
            binding.editor.searcher.gotoPrevious()
        } catch (e: IllegalStateException) {
            e.printStackTrace()
        }
    }

    fun replace(view: View?) {
        try {
            binding.editor.searcher.replaceThis(binding.replaceEditor.text.toString())
        } catch (e: IllegalStateException) {
            e.printStackTrace()
        }
    }

    fun replaceAll(view: View?) {
        try {
            binding.editor.searcher.replaceAll(binding.replaceEditor.text.toString())
        } catch (e: IllegalStateException) {
            e.printStackTrace()
        }
    }

    fun showSearchOptions(view: View?) {
        searchMenu.show()
    }
}