package com.example.watchlistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.watchlistapp.ui.theme.WatchListAppTheme

class MainActivity : ComponentActivity() {
    private val viewModel: WatchListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WatchListAppTheme {
                WatchListScreen(viewModel)
            }
        }
    }
}