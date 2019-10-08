package vn.hueic.student.maivan.dat.weatherapp.utils.binding


import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import vn.hueic.student.maivan.dat.weatherapp.base.BaseAdapter

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("bindAdapter")
    fun <T> bindAdapter(recycler: RecyclerView?, adapter: BaseAdapter<T>) {
        recycler!!.adapter = adapter
    }

}
