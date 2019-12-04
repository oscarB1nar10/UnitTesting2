package com.example.unittesting2.unittesting2.di

import android.app.Application
import com.example.unittesting2.BaseApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = [AndroidSupportInjectionModule::class,
                        AppModule::class,
                        ActivityBuildersModule::class,
                        ViewModelFactoryModule::class])
interface AppComponent : AndroidInjector<BaseApplication>{

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

}