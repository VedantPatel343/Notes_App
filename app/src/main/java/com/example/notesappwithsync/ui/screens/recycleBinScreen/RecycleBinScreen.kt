package com.example.notesappwithsync.ui.screens.recycleBinScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RecycleBinScreen(viewModel: RecycleBinViewModel = hiltViewModel()) {

    val list by viewModel.allRecycledNotes.collectAsState(initial = emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Recycle Bin",
            fontSize = 35.sp,
            color = Color.Blue,
            modifier = Modifier.padding(vertical = 20.dp),
            style = MaterialTheme.typography.h2,
            fontWeight = FontWeight.Bold
        )

        LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Fixed(2), content = {
            items(list){ note ->
                RecycledNoteItem(note = note)
            }
        })

    }

}