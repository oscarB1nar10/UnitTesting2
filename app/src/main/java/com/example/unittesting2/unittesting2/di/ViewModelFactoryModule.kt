package com.example.unittesting2.unittesting2.di

import androidx.lifecycle.ViewModelProvider
import com.example.unittesting2.unittesting2.viewModes.ViewModelProvFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule{

    @Binds
    abstract fun bindViewModelFactory(viewModelProvFactory: ViewModelProvFactory): ViewModelProvider.Factory

}