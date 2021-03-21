package com.rakesh.clevertaptest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.rakesh.clevertaptest.R
import com.rakesh.clevertaptest.adapter.DataAdapter.DataViewHolder
import com.rakesh.clevertaptest.databinding.ItemDataBinding
import com.rakesh.clevertaptest.model.DataModel
import com.rakesh.clevertaptest.viewmodel.DataItemViewModel
import java.util.*

class DataAdapter(private val listener: (DataModel) -> Unit) : RecyclerView.Adapter<DataViewHolder>() {

    private val data: MutableList<DataModel>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_data,
            FrameLayout(parent.context), false
        )
        return DataViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val dataModel = data[position]
        holder.setViewModel(DataItemViewModel(dataModel))
        holder.itemView.setOnClickListener { listener(dataModel) }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onViewAttachedToWindow(holder: DataViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.bind()
    }

    override fun onViewDetachedFromWindow(holder: DataViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.unbind()
    }

    fun updateData(data: List<DataModel>?) {
        if (data == null || data.isEmpty()) {
            this.data.clear()
        } else {
            this.data.addAll(data)
        }
       internalNotifyDataSetChanged()
    }

    fun internalNotifyDataSetChanged() {
        notifyDataSetChanged()
    }

    class DataViewHolder(itemView: View?) : RecyclerView.ViewHolder(
        itemView!!
    ) {
        var binding: ItemDataBinding? = null
        fun bind() {
            if (binding == null) {
                binding = DataBindingUtil.bind(itemView)
            }
        }

        fun unbind() {
            binding?.unbind()
        }

        fun setViewModel(viewModel: DataItemViewModel?) {
            binding?.viewModel = viewModel
        }

        init {
            bind()
        }
    }

    init {
        data = ArrayList()
    }
}