package vn.hueic.student.maivan.dat.weatherapp.ui.viewmodel

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import vn.hueic.student.maivan.dat.weatherapp.data.model.weather.daily.Daily
import vn.hueic.student.maivan.dat.weatherapp.utils.extension.AnyExtension
import vn.hueic.student.maivan.dat.weatherapp.utils.helper.Rounding
import vn.hueic.student.maivan.dat.weatherapp.utils.helper.formatDateDaily

class ItemDailyViewModel : BaseObservable() {

    @Bindable
    var daily : Daily? = null

    fun setData(data: Daily) {
        if (data != null) {
            daily = data
            notifyPropertyChanged(BR.daily)
        }
    }

    fun getDate(date: Long) : String = String().formatDateDaily(date)

    fun getTempRounding(data: Float) : String = String().Rounding(data)

    fun getWeatherImage(data: String) : Int = AnyExtension.setWheatherImage(data)

}