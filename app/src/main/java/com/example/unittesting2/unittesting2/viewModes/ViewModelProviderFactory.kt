package com.example.unittesting2.unittesting2.viewModes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class ViewModelProvFactory @Inject constructor( creator :  Map<Class<out ViewModel>,@JvmSuppressWildcards Provider<ViewModel>>) :
    ViewModelProvider.Factory{

    private val TAG = "ViewModelProviderFactor"
    private var  creators: Map<Class<out ViewModel>, Provider<ViewModel>> = creator


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        var creator: Provider<out ViewModel>? = creators.get(modelClass)
        if (creator == null) { // if the viewmodel has not been created

            // loop through the allowable keys (aka allowed classes with the @ViewModelKeyJava)
            for ((key, value) in creators) {

                // if it's allowed, set the Provider<ViewModel>
                if (modelClass.isAssignableFrom(key)) {
                    creator = value
                    break
                }
            }
        }

        // if this is not one of the allowed keys, throw exception
        requireNotNull(creator) { "unknown model class $modelClass" }

        // return the Provider
        try {
            return creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

}