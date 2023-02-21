package com.example.notesappwithsync.ui.screens.homeNotesScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesappwithsync.room.entity.NoteModel
import com.example.notesappwithsync.room.entity.RecycleBinModel
import com.example.notesappwithsync.room.repository.NotesRepository
import com.example.notesappwithsync.room.repository.RecycleBinRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val noteRepo: NotesRepository,
    private val delRepo: RecycleBinRepository
) : ViewModel() {

    val allNotes = noteRepo.notesList

    fun addToRecycleBin(note: NoteModel) = viewModelScope.launch(Dispatchers.IO) {
        val delNote = RecycleBinModel(
            recycleId = note.id,
            recycleTitle = note.title,
            recycleDescription = note.description,
            recycleCategory = note.category
        )

        delRepo.addNote(delNote)
        noteRepo.deleteNote(note)
    }

}