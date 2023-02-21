package com.example.notesappwithsync.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notesappwithsync.room.dao.NotesDao
import com.example.notesappwithsync.room.dao.RecycleBinDao
import com.example.notesappwithsync.room.entity.NoteModel
import com.example.notesappwithsync.room.entity.RecycleBinModel

@Database(entities = [NoteModel::class, RecycleBinModel::class], version = 2)
abstract class AppDB : RoomDatabase(){

    abstract val notesDao: NotesDao
    abstract val recycleDao: RecycleBinDao

}