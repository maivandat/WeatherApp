package vn.hueic.student.maivan.dat.weatherapp.ui.adapter

import androidx.databinding.ViewDataBinding
import vn.hueic.student.maivan.dat.weatherapp.R
import vn.hueic.student.maivan.dat.weatherapp.base.BaseAdapter
import vn.hueic.student.maivan.dat.weatherapp.base.BaseViewHolder
import vn.hueic.student.maivan.dat.weatherapp.data.model.weather.daily.Daily
import vn.hueic.student.maivan.dat.weatherapp.databinding.ItemDailyBinding
import vn.hueic.student.maivan.dat.weatherapp.ui.viewmodel.ItemDailyViewModel

class DailyWeatherAdapter : BaseAdapter<Daily>() {

    override fun layout(row: Int): Int = R.layout.item_daily

    override fun viewHolder(binding: ViewDataBinding): BaseViewHolder<Daily> {
        return DailyViewHolder(
            binding
        )
    }

    class DailyViewHolder(binding: ViewDataBinding) : BaseViewHolder<Daily>(binding) {
        override fun bindData(data: Daily) {
            if (binding is ItemDailyBinding) {

                binding.viewmodel = ItemDailyViewModel()
                binding.viewmodel!!.setData(data)
                binding.executePendingBindings()
            }
        }

    }

}