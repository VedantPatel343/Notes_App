package com.example.notesappwithsync.ui.screens.addNewNote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesappwithsync.room.entity.NoteModel
import com.example.notesappwithsync.room.repository.NotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewNoteViewModel @Inject constructor(private val repo: NotesRepository) : ViewModel() {

    fun addNote(note: NoteModel) = viewModelScope.launch(Dispatchers.IO){
        repo.addNewNote(note)
    }

}