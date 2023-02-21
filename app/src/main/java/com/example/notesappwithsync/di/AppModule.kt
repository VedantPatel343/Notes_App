package com.example.notesappwithsync.di

import android.app.Application
import androidx.room.Room
import com.example.notesappwithsync.room.AppDB
import com.example.notesappwithsync.room.repository.NotesRepository
import com.example.notesappwithsync.room.repository.RecycleBinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun appDB(application: Application): AppDB {
        return Room.databaseBuilder(
            application,
            AppDB::class.java,
            "app_database"
        ).allowMainThreadQueries()
         .build()
    }

    @Singleton
    @Provides
    fun notesRepo(db: AppDB): NotesRepository {
        return NotesRepository(db.notesDao)
    }

    @Singleton
    @Provides
    fun recycledNotesRepo(db: AppDB): RecycleBinRepository {
        return RecycleBinRepository(db.recycleDao)
    }

}