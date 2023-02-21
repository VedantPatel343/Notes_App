package com.example.notesappwithsync.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.notesappwithsync.ui.screens.addNewNote.AddNewNoteScreen
import com.example.notesappwithsync.ui.screens.editNoteScreen.EditNotesScreen
import com.example.notesappwithsync.ui.screens.homeNotesScreen.HomeNotesScreen
import com.example.notesappwithsync.ui.screens.recycleBinScreen.RecycleBinScreen

@Composable
fun Navigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = ScreensObj.HomeNotesScreen.route) {

        composable(route = ScreensObj.HomeNotesScreen.route) {
            HomeNotesScreen(navController)
        }

        composable(route = ScreensObj.RecycleBinScreen.route) {
            RecycleBinScreen()
        }

        composable(route = ScreensObj.AddNewNoteScreen.route) {
            AddNewNoteScreen(navController)
        }

        composable(
            route = ScreensObj.EditNotesScreen.route,
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }
            )
        ) {
            val id = it.arguments?.getInt("id")
            EditNotesScreen(navController, id = id)
        }

    }

}