package com.example.notesappwithsync.ui.screens.recycleBinScreen

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
class RecycleBinViewModel @Inject constructor(
    private val repo: RecycleBinRepository,
    private val repoN: NotesRepository
) :
    ViewModel() {

    val allRecycledNotes = repo.recycledNotesList

    fun deleteRecycledNote(note: RecycleBinModel) = viewModelScope.launch(Dispatchers.IO) {
        repo.deleteNote(note)
    }

    fun recycleNote(noteR: RecycleBinModel) = viewModelScope.launch(Dispatchers.IO) {

        val noteN = NoteModel(
            id = noteR.recycleId,
            title = noteR.recycleTitle,
            description = noteR.recycleDescription,
            category = noteR.recycleCategory
        )

        repoN.addNewNote(noteN)
        repo.deleteNote(noteR)
    }

}