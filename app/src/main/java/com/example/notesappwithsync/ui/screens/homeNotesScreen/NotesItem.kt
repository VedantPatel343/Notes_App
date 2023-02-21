package com.example.notesappwithsync.ui.screens.homeNotesScreen

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.notesappwithsync.R
import com.example.notesappwithsync.room.entity.NoteModel
import com.example.notesappwithsync.ui.theme.*

@Composable
fun NotesItem(
    note: NoteModel,
    viewModel: HomeScreenViewModel = hiltViewModel(),
    editNote: (Int) -> Unit,
) {

    val context = LocalContext.current

    Surface(
        elevation = 1.dp,
        modifier = Modifier
            .padding(5.dp)
            .clickable {
                editNote(note.id)
            },
        color = when (note.category) {
            "blue" -> {
                blueC
            }
            "yellow" -> {
                yellowC
            }
            "orange" -> {
                orangeC
            }
            "gray" -> {
                grayC
            }
            else -> {
                cyanC
            }
        }
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = note.title, fontSize = 20.sp)
                Icon(
                    painter = painterResource(id = R.drawable.recycle_bin_icon),
                    contentDescription = "Delete",
                    modifier = Modifier
                        .size(15.dp)
                        .clickable {
                            viewModel.addToRecycleBin(note)
                            Toast
                                .makeText(context, "Added to Recycler Bin.", Toast.LENGTH_SHORT)
                                .show()
                        }
                )
            }
            Text(text = note.description, fontSize = 15.sp)
        }
    }

}