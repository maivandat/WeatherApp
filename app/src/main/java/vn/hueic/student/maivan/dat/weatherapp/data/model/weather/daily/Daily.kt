package vn.hueic.student.maivan.dat.weatherapp.data.model.weather.daily

import com.google.gson.annotations.SerializedName
import vn.hueic.student.maivan.dat.weatherapp.data.model.weather.Temp
import vn.hueic.student.maivan.dat.weatherapp.data.model.weather.Weather

class Daily {
    @SerializedName("dt")
    var date: Long = 0
    @SerializedName("temp")
    var temp = Temp()
    @SerializedName("weather")
    var weather = ArrayList<Weather>()

}