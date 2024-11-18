package com.example.watchlistapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun WatchListItem(
    item: WatchItem,
    onToggleWatched: (Int) -> Unit,
    onDelete: (Int) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = item.isWatched,
            onCheckedChange = { onToggleWatched(item.id) }
        )
        Text(
            text = item.title,
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp)
        )
        IconButton(onClick = { onDelete(item.id) }) {
            Icon(Icons.Default.Delete, contentDescription = "Delete")
        }
    }
}

// Preview
@Preview(showBackground = true)
@Composable
fun PreviewWatchListItem() {
    WatchListItem(
        item = WatchItem(id = 1, title = "Breaking Bad", isWatched = false),
        onToggleWatched = {},
        onDelete = {}
    )
}
