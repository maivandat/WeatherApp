package vn.hueic.student.maivan.dat.weatherapp.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.inflate
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T> : RecyclerView.Adapter<BaseViewHolder<T>>() {
    private var data= mutableListOf<T>()

    fun replaceItems(items: List<T>) {
        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }

    fun addItem(item : T) {
        data.add(item)
        notifyDataSetChanged()
    }

    fun clearList() {
        data.clear()
        notifyDataSetChanged()
    }

    protected abstract fun layout(row: Int) : Int

    protected abstract fun viewHolder(binding: ViewDataBinding) : BaseViewHolder<T>

    override fun onCreateViewHolder(parent: ViewGroup, @LayoutRes layout: Int): BaseViewHolder<T> {
        val binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), layout, parent, false) as ViewDataBinding
        return viewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.bindData(objectFromPosition(position))
    }

    private fun objectFromPosition(position: Int) = data[position]!!

    override fun getItemCount(): Int = data.size

    override fun getItemViewType(position: Int): Int  = layout(position)
}