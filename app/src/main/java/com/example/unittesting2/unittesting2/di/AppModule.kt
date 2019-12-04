package com.example.unittesting2.unittesting2.di

import android.app.Application
import androidx.room.Room
import com.example.unittesting2.unittesting2.persistence.NoteDao
import com.example.unittesting2.unittesting2.persistence.NoteDatabase
import com.example.unittesting2.unittesting2.persistence.NoteDatabase.Companion.DATABASENAME
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Module
    companion object{

        @JvmStatic
        @Singleton
        @Provides
        fun provideNoteDatabase(application: Application):NoteDatabase{
            return Room.databaseBuilder(
                application,
                NoteDatabase::class.java,
                DATABASENAME
                ).build()
        }

        @JvmStatic
        @Singleton
        @Provides
        fun provideNoteDao(noteDatabase: NoteDatabase): NoteDao{
            return noteDatabase.getNoteDao()
        }


    }




}
