package com.example.unittesting2.unittesting2.di

import com.example.unittesting2.NotesListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract fun providerNoteListActivity(): NotesListActivity


}