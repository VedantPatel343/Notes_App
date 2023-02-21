package com.example.notesappwithsync.room.repository

import com.example.notesappwithsync.room.dao.RecycleBinDao
import com.example.notesappwithsync.room.entity.RecycleBinModel

class RecycleBinRepository(private val dao: RecycleBinDao) {

    val recycledNotesList = dao.getRecycleNotes()

    suspend fun addNote(note: RecycleBinModel){
        dao.addNoteToRecycleBin(note)
    }

    suspend fun deleteNote(note: RecycleBinModel){
        dao.deleteRecycledNote(note)
    }

}