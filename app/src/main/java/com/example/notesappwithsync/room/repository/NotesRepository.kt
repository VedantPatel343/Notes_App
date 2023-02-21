package com.example.notesappwithsync.room.repository

import com.example.notesappwithsync.room.dao.NotesDao
import com.example.notesappwithsync.room.entity.NoteModel

class NotesRepository(private val dao: NotesDao) {

    val notesList = dao.getNotes()

    fun getNote(id: Int): NoteModel{
        return dao.getNoteToEdit(id)
    }

    suspend fun addNewNote(note: NoteModel){
        dao.addNote(note)
    }

    suspend fun deleteNote(note: NoteModel){
        dao.deleteNote(note)
    }

}