package com.example.notesappwithsync.room.dao

import androidx.room.*
import com.example.notesappwithsync.room.entity.NoteModel
import com.example.notesappwithsync.room.entity.RecycleBinModel
import kotlinx.coroutines.flow.Flow

@Dao
interface RecycleBinDao {

    @Query("SELECT * FROM recycleBin ORDER BY recycleId DESC")
    fun getRecycleNotes(): Flow<List<RecycleBinModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNoteToRecycleBin(note: RecycleBinModel)

    @Delete
    suspend fun deleteRecycledNote(note: RecycleBinModel)

}