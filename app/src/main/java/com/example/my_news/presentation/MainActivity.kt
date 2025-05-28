package com.example.my_news.presentation

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.lifecycleScope
import com.example.my_news.data.local.NewsDao
import com.example.my_news.domain.model.Article
import com.example.my_news.domain.model.Source
import com.example.my_news.presentation.Navgraph.NavGraph
import com.example.my_news.presentation.Viewmodel.MainViewmodel
import com.example.my_news.ui.theme.My_newsTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewmodel by viewModels<MainViewmodel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        enableEdgeToEdge()

        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewmodel.splashCondition
            }
        }

        setContent {
            My_newsTheme {

                val systemdarkMode = isSystemInDarkTheme()
                val window = window
                WindowCompat.setDecorFitsSystemWindows(window, false)

                window.statusBarColor = Color.GRAY
                WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars =
                    true

                val startDestination = viewmodel.startDestination
                NavGraph(startDestination = startDestination)
            }
        }

    }
}