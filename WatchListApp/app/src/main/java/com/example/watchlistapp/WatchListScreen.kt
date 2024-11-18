package com.example.watchlistapp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun WatchListScreen(viewModel: WatchListViewModel) {
    var newTitle by remember { mutableStateOf(TextFieldValue("")) }

    Column(Modifier.padding(16.dp)) {
        // Input field to add new items
        TextField(
            value = newTitle,
            onValueChange = { newTitle = it },
            label = { Text("Add a movie or series") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                if (newTitle.text.isNotEmpty()) {
                    viewModel.addWatchItem(newTitle.text)
                    newTitle = TextFieldValue("") // Clear the input field
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add")
        }
        Spacer(modifier = Modifier.height(16.dp))
        // Display the watch list
        LazyColumn {
            items(viewModel.watchList) { item ->
                WatchListItem(
                    item = item,
                    onToggleWatched = { viewModel.toggleWatchedStatus(it) },
                    onDelete = { viewModel.deleteWatchItem(it) }
                )
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewWatchListScreen() {
    // Temporary fake ViewModel for preview
    val fakeViewModel = WatchListViewModel().apply {
        addWatchItem("Stranger Things")
        addWatchItem("Inception")
        addWatchItem("Game of Thrones")
    }
    WatchListScreen(viewModel = fakeViewModel)
}