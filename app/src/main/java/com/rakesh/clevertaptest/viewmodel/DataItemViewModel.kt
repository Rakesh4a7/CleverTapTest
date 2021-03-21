package com.rakesh.clevertaptest.viewmodel

import android.text.TextUtils
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.rakesh.clevertaptest.model.DataModel

class DataItemViewModel(private val dataModel: DataModel) : BaseObservable() {
    fun setUp() {
        // perform set up tasks, such as adding listeners
    }

    fun tearDown() {
        // perform tear down tasks, such as removing listeners
    }

    @get:Bindable
    val title: String?
        get() = if (!TextUtils.isEmpty(dataModel.title)) dataModel.title else ""
}