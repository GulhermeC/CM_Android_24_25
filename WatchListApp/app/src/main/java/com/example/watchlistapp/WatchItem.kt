package com.example.watchlistapp

data class WatchItem(
    val id: Int,
    val title: String,
    val isWatched: Boolean = false
)