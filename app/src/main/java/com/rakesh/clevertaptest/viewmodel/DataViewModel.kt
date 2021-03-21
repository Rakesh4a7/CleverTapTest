package com.rakesh.clevertaptest.viewmodel

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import com.rakesh.clevertaptest.BR
import com.rakesh.clevertaptest.adapter.DataAdapter
import com.rakesh.clevertaptest.model.DataModel
import com.rakesh.convertdrawable.DrawableToBitmap
import kotlin.collections.ArrayList

class DataViewModel : BaseObservable() {
    @get:Bindable
    val adapter: DataAdapter
    private var data: MutableList<DataModel>
    var imageData = MutableLiveData<Bitmap>()

    fun setUp() {
        // perform set up tasks, such as adding listeners, data population, etc.
       // populateData()
    }

    fun tearDown() {
        // perform tear down tasks, such as removing listeners
    }

    @Bindable
    fun getData(): List<DataModel> {
        return data
    }

    fun setData(dataModelList: ArrayList<DataModel?>) {
        data = dataModelList as MutableList<DataModel>
        notifyPropertyChanged(BR.data)
    }

    init {
        data = ArrayList()
        adapter = DataAdapter {
            //imageData.value = it.drawable
            imageData.value =  DrawableToBitmap.instance.drawableToBitmap(it.drawable!!)
        }
    }
}