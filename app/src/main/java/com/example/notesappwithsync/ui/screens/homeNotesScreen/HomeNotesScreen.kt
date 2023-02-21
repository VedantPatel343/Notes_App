package com.example.notesappwithsync.ui.screens.homeNotesScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.notesappwithsync.R
import com.example.notesappwithsync.navigation.ScreensObj

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeNotesScreen(
    navController: NavHostController,
    viewModel: HomeScreenViewModel = hiltViewModel(),
) {

    val list by viewModel.allNotes.collectAsState(initial = emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()) {
            Column(modifier = Modifier.fillMaxWidth()) {
                TopBar(navController)
                LazyVerticalStaggeredGrid(
                    columns = StaggeredGridCells.Fixed(2),
                    content = {
                        items(list) { note ->
                            NotesItem(
                                note = note,
                                editNote = { editNoteId ->
                                    navController.navigate("edit_notes_screen/$editNoteId"){
                                        launchSingleTop = true
                                    }
                                }
                            )
                        }
                    }
                )
            }
        }
    }

}


@Composable
fun TopBar(navController: NavHostController) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "All Notes",
            fontSize = 35.sp,
            color = Color.Blue,
            modifier = Modifier.padding(vertical = 20.dp),
            style = MaterialTheme.typography.h2,
            fontWeight = FontWeight.Bold
        )

        Icon(
            modifier = Modifier
                .size(30.dp)
                .clickable {
                    navController.navigate(ScreensObj.RecycleBinScreen.route) {
                        launchSingleTop = true
                    }
                },
            painter = painterResource(id = R.drawable.recycle_bin_icon),
            contentDescription = "Recycle Bin",
        )
    }


}