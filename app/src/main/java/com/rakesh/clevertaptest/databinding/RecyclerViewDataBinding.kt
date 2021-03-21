package com.rakesh.clevertaptest.databinding

import android.graphics.Bitmap
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingComponent
import androidx.recyclerview.widget.RecyclerView
import com.rakesh.clevertaptest.adapter.DataAdapter
import com.rakesh.clevertaptest.model.DataModel

class RecyclerViewDataBinding : DataBindingComponent {

}
@BindingAdapter("app:adapter", "app:data")
fun bind(recyclerView: RecyclerView, adapter: DataAdapter, data: List<DataModel?>?) {
    recyclerView.adapter = adapter
    adapter.updateData(data as List<DataModel>?)
}

@BindingAdapter("app:setBitmap")
fun bind(imageView: ImageView, bitmap: Bitmap?) {
    imageView.setImageBitmap(bitmap)
}