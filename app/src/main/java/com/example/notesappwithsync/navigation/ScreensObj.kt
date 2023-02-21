package com.example.notesappwithsync.navigation

sealed class ScreensObj(val title: String, val route: String){

    object HomeNotesScreen : ScreensObj(title = "All Notes", route = "home_notes_screen")
    object EditNotesScreen : ScreensObj(title = "Edit Notes", route = "edit_notes_screen/{id}")
    object RecycleBinScreen : ScreensObj(title = "Recycle Bin", route = "recycle_bin_screen")
    object AddNewNoteScreen : ScreensObj(title = "Add Note", route = "add_new_note_screen")

}
