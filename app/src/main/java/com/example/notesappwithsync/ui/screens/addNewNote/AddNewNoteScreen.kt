package com.example.notesappwithsync.ui.screens.addNewNote

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.notesappwithsync.navigation.ScreensObj
import com.example.notesappwithsync.room.entity.NoteModel
import com.example.notesappwithsync.ui.theme.*

@Composable
fun AddNewNoteScreen(navHostController: NavHostController) {
    var title by rememberSaveable {
        mutableStateOf("")
    }
    var description by rememberSaveable {
        mutableStateOf("")
    }

    val category by remember {
        mutableStateOf(listOf("blue", "yellow", "orange", "gray", "cyan"))
    }
    var categoryState by rememberSaveable {
        mutableStateOf("blue")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Box(
            modifier = Modifier
                .weight(0.95f)
                .padding(bottom = 10.dp)
        ) {

            Column(modifier = Modifier.fillMaxWidth()) {

                OutlinedTextField(
                    value = title,
                    onValueChange = {
                        title = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.08f),
                    label = {
                        Text(text = "Title")
                    }
                )

                // Radio Buttons for selection of Categories.
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.06f)
                        .padding(top = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    category.forEach { categoryColor ->
                        RadioButton(
                            selected = categoryState == categoryColor,
                            onClick = { categoryState = categoryColor },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = when (categoryColor) {
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
                                },
                                unselectedColor = when (categoryColor) {
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
                            )
                        )
                    }
                }

                OutlinedTextField(
                    value = description,
                    onValueChange = {
                        description = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.86f),
                    label = {
                        Text(text = "Description")
                    }
                )

            }
        }

        Box(modifier = Modifier.weight(0.05f)) {
            SaveButton(
                title = title,
                des = description,
                category = categoryState,
                navHostController = navHostController
            )
        }

    }

}

@Composable
fun SaveButton(
    navHostController: NavHostController,
    title: String,
    des: String,
    category: String,
    viewModel: NewNoteViewModel = hiltViewModel(),
) {

    val context = LocalContext.current

    OutlinedButton(
        modifier = Modifier.fillMaxWidth(),
        onClick = {
            if (title != "") {
                Toast.makeText(context, "Note Saved.", Toast.LENGTH_SHORT).show()

                val note = NoteModel(
                    title = title,
                    description = des,
                    category = category
                )

                viewModel.addNote(note)
                navHostController.navigate(ScreensObj.HomeNotesScreen.route) {
                    launchSingleTop = true
                }
            } else {
                Toast.makeText(context, "Title can't be empty.", Toast.LENGTH_SHORT).show()
            }


        },
        border = BorderStroke(1.dp, Color.Transparent)
//        border = BorderStroke(1.dp, greenC)

    ) {
        Icon(
            imageVector = Icons.Default.Done,
            contentDescription = "Save",
            tint = greenC
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = "Save",
            fontSize = 16.sp,
            color = greenC
        )
    }
}