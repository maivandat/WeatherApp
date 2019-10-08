package vn.hueic.student.maivan.dat.weatherapp.ui.adapter

import androidx.databinding.ViewDataBinding
import vn.hueic.student.maivan.dat.weatherapp.R
import vn.hueic.student.maivan.dat.weatherapp.base.BaseAdapter
import vn.hueic.student.maivan.dat.weatherapp.base.BaseViewHolder
import vn.hueic.student.maivan.dat.weatherapp.data.model.weather.hourly.Hourly
import vn.hueic.student.maivan.dat.weatherapp.databinding.ItemHourlyBinding
import vn.hueic.student.maivan.dat.weatherapp.ui.viewmodel.ItemHourlyViewModel

class HourlyWeatherAdapter : BaseAdapter<Hourly>() {

    override fun layout(row: Int): Int = R.layout.item_hourly

    override fun viewHolder(binding: ViewDataBinding): BaseViewHolder<Hourly> {
        return HourlyViewHolder(
            binding
        )
    }

    class HourlyViewHolder(
        binding: ViewDataBinding
    ) : BaseViewHolder<Hourly>(binding) {
        override fun bindData(data: Hourly) {
            if (binding is ItemHourlyBinding) {
                binding.viewmodel = ItemHourlyViewModel()
                binding.viewmodel!!.setData(data)
                binding.executePendingBindings()
            }
        }
    }

}