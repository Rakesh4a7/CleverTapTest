package com.rakesh.clevertaptest.view

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rakesh.clevertaptest.R
import com.rakesh.clevertaptest.databinding.ActivityMainBinding
import com.rakesh.clevertaptest.model.DataModel
import com.rakesh.clevertaptest.viewmodel.DataViewModel
import java.io.InputStream


class MainActivity : AppCompatActivity() {
    private var dataViewModel: DataViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = bind()
        initRecyclerView(view)
        fetchData()
    }

    private fun bind(): View {
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        dataViewModel = DataViewModel()
        binding.viewModel = dataViewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    private fun initRecyclerView(view: View) {
        val recyclerView: RecyclerView = view.findViewById(R.id.data_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                LinearLayout.VERTICAL
            )
        )
    }

    private fun fetchData() {
      /*  This code to fetch drawable items*/
      /* val drawablesFields: Array<Field> = R.drawable::class.java.declaredFields
        val drawables: ArrayList<Drawable> = ArrayList()

        for (field in drawablesFields) {
            try {
                Log.i("LOG_TAG", "com.your.project.R.drawable  $field.name")
                drawables.add(resources.getDrawable(field.getInt(null), this.theme))
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }*/

        /*  This code to fetch assets items*/
        val dataModelList: ArrayList<DataModel?> = ArrayList()

        assets.list("random")?.forEach {
            var inputStream: InputStream = assets.open("random/$it")
            val d = Drawable.createFromStream(inputStream, null)
            val dataModel = DataModel()
            dataModel.title = it
            dataModel.drawable = d
            dataModelList.add(dataModel)
        }

        dataViewModel!!.setData(dataModelList)
    }
}