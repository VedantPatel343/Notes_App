package com.example.notesappwithsync.room.dao

import androidx.room.*
import com.example.notesappwithsync.room.entity.NoteModel
import kotlinx.coroutines.flow.Flow


@Dao
interface NotesDao {

    @Query("SELECT * FROM notes WHERE id LIKE :id")
    fun getNoteToEdit(id: Int): NoteModel

    @Query("SELECT * FROM notes ORDER BY id DESC")
    fun getNotes(): Flow<List<NoteModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNote(note: NoteModel)

    @Delete
    suspend fun deleteNote(note: NoteModel)

}