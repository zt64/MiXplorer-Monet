package com.zt64.mixplorermonet

import android.os.Bundle
import android.view.animation.AccelerateInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.zt64.mixplorermonet.ui.theme.MixplorerMonetTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().setOnExitAnimationListener { provider ->
            provider.view.animate().apply {
                interpolator = AccelerateInterpolator()
                duration = 200L

                alpha(0f)
                withEndAction(provider::remove)
                start()
            }
        }

        setContent {
            MixplorerMonetTheme {
                Scaffold { paddingValues ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        val context = LocalContext.current

                        Icon(
                            modifier = Modifier.size(48.dp),
                            imageVector = Icons.Default.Palette,
                            contentDescription = getString(R.string.palette)
                        )

                        Spacer(modifier = Modifier.height(2.dp))

                        Text(
                            text = "MiXplorer Monet",
                            style = MaterialTheme.typography.titleLarge
                        )

                        Spacer(modifier = Modifier.height(40.dp))

                        Button(
                            onClick = { Util.generateTheme(context, false) }
                        ) {
                            Icon(imageVector = Icons.Default.LightMode, contentDescription = getString(R.string.light_mode))
                            Spacer(Modifier.width(10.dp))
                            Text(text = getString(R.string.generate_light_theme))
                        }

                        Spacer(modifier = Modifier.height(2.dp))

                        Button(
                            onClick = { Util.generateTheme(context, true) }
                        ) {
                            Icon(imageVector = Icons.Default.DarkMode, contentDescription = getString(R.string.dark_mode))
                            Spacer(Modifier.width(10.dp))
                            Text(text = getString(R.string.generate_dark_theme))
                        }
                    }
                }
            }
        }
    }
}