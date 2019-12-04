package com.example.unittesting2.unittesting2.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.unittesting2.unittesting2.models.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase(){

    companion object{
        //const
        const val DATABASENAME = "notes_db"
    }



    abstract fun getNoteDao(): NoteDao

}
