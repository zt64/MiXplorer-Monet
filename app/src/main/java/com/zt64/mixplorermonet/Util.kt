package com.zt64.mixplorermonet

import android.content.Context
import android.content.Intent
import androidx.core.net.toUri

object Util {
    fun generateTheme(
        context: Context,
        isDarkTheme: Boolean
    ) {
        val themeFile = context.cacheDir.resolve("mix-monet-theme.mit")

        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND

            putExtra(Intent.EXTRA_STREAM, themeFile.toUri())
            putExtra(Intent.EXTRA_TITLE, "MiXplorer monet ${if (isDarkTheme) "dark" else "theme"} theme")

            type = "*/*"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)

//        context.startActivity(shareIntent)
    }
}