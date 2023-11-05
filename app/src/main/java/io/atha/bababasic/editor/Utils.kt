package io.atha.bababasic.editor

import android.content.Context
import android.content.res.Configuration
import io.github.rosemoe.sora.langs.textmate.TextMateColorScheme
import io.github.rosemoe.sora.langs.textmate.registry.ThemeRegistry
import io.github.rosemoe.sora.widget.CodeEditor
import io.github.rosemoe.sora.widget.schemes.EditorColorScheme
import io.github.rosemoe.sora.widget.schemes.SchemeDarcula

fun switchThemeIfRequired(context: Context, editor: CodeEditor) {
    if ((context.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES) {
        if (editor.colorScheme is TextMateColorScheme) {
            ThemeRegistry.getInstance().setTheme("darcula")
        } else {
            editor.colorScheme = SchemeDarcula()
        }
    } else {
        if (editor.colorScheme is TextMateColorScheme) {
            ThemeRegistry.getInstance().setTheme("quietlight")
        } else {
            editor.colorScheme = EditorColorScheme()
        }
    }
    editor.invalidate()
}