package com.example.notesappwithsync.ui.screens.recycleBinScreen

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.notesappwithsync.R
import com.example.notesappwithsync.room.entity.RecycleBinModel
import com.example.notesappwithsync.ui.theme.*

@Composable
fun RecycledNoteItem(note: RecycleBinModel, viewModel: RecycleBinViewModel = hiltViewModel()) {

    val context = LocalContext.current

    Surface(
        elevation = 1.dp,
        modifier = Modifier.padding(5.dp),
        color = when (note.recycleCategory) {
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
                Text(text = note.recycleTitle, fontSize = 20.sp)
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.recycle_icon),
                        contentDescription = "Recycle",
                        modifier = Modifier
                            .size(18.dp)
                            .clickable {
                                viewModel.recycleNote(note)
                                Toast
                                    .makeText(context, "Note Saved.", Toast.LENGTH_SHORT)
                                    .show()
                            }
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.recycle_bin_icon),
                        contentDescription = "Delete",
                        modifier = Modifier
                            .size(18.dp)
                            .clickable {
                                viewModel.deleteRecycledNote(note)
                                Toast
                                    .makeText(context, "Note Deleted.", Toast.LENGTH_SHORT)
                                    .show()
                            }
                    )
                }
            }
            Text(text = note.recycleDescription, fontSize = 15.sp)
        }
    }
}