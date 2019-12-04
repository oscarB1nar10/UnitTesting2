package com.example.unittesting2.unittesting2.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

object LiveDataTestUtil {

    @Throws(InterruptedException::class)
   fun <T> getValue( liveData: LiveData<T>): T?{
        var data = ArrayList<T>()
        // latch for blocking thread until data is set
        var latch = CountDownLatch(1)

        val observer: Observer<T> = object : Observer<T>{
            override fun onChanged(t: T) {
             data.add(t)
                latch.countDown()
                liveData.removeObserver(this)

            }
        }
        liveData.observeForever(observer)
        try {
            latch.await(2, TimeUnit.SECONDS)
        }catch (e: InterruptedException){
            throw InterruptedException("Latch failure")
        }

        if(data.size > 0){
            return data[0]
        }
        return null
    }

}