package com.rakesh.clevertaptest

import android.app.Application
import androidx.databinding.DataBindingUtil
import com.rakesh.clevertaptest.databinding.RecyclerViewDataBinding

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        DataBindingUtil.setDefaultComponent(RecyclerViewDataBinding())
    }
}