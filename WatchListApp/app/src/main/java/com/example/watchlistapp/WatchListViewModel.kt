package com.example.watchlistapp

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class WatchListViewModel : ViewModel() {

    private val _watchList = mutableStateListOf(
        WatchItem(1, "Breaking Bad"),
        WatchItem(2, "Stranger Things"),
        WatchItem(3, "Inception")
    )
    val watchList: List<WatchItem> = _watchList

    fun addWatchItem(title: String) {
        val newItem = WatchItem(id = (_watchList.maxOfOrNull { it.id } ?: 0) + 1, title = title)
        _watchList.add(newItem)
    }

    fun toggleWatchedStatus(itemId: Int) {
        val index = _watchList.indexOfFirst { it.id == itemId }
        if (index != -1) {
            val item = _watchList[index]
            _watchList[index] = item.copy(isWatched = !item.isWatched)
        }
    }

    fun deleteWatchItem(itemId: Int) {
        _watchList.removeAll { it.id == itemId }
    }
}