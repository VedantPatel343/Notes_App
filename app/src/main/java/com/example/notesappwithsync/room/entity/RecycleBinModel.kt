package com.example.notesappwithsync.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recycleBin")
data class RecycleBinModel(
    @PrimaryKey(autoGenerate = false) val recycleId: Int,
    @ColumnInfo(name = "recycledTitle") val recycleTitle: String,
    @ColumnInfo(name = "recycledDescription") val recycleDescription: String,
    @ColumnInfo(name = "recycledCategory") val recycleCategory: String
)