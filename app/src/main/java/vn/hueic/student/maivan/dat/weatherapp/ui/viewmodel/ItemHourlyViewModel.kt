package vn.hueic.student.maivan.dat.weatherapp.ui.viewmodel

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import vn.hueic.student.maivan.dat.weatherapp.data.model.weather.hourly.Hourly
import vn.hueic.student.maivan.dat.weatherapp.utils.extension.AnyExtension
import vn.hueic.student.maivan.dat.weatherapp.utils.helper.Rounding
import vn.hueic.student.maivan.dat.weatherapp.utils.helper.formatDateHourly

class ItemHourlyViewModel : BaseObservable() {

    @Bindable
    var hourly : Hourly? = null

    fun setData(data: Hourly?) {
        if (data != null ){
            hourly = data
            notifyPropertyChanged(BR.hourly)
        }
    }

    fun getDate(date: Long) : String = String().formatDateHourly(date)

    fun getTempRounding(data: Float) : String = String().Rounding(data)

    fun getWeatherImage(data: String) : Int = AnyExtension.setWheatherImage(data)

}