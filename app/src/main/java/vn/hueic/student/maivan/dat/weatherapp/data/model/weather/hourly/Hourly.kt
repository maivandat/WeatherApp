package vn.hueic.student.maivan.dat.weatherapp.data.model.weather.hourly

import com.google.gson.annotations.SerializedName
import vn.hueic.student.maivan.dat.weatherapp.data.model.weather.Main
import vn.hueic.student.maivan.dat.weatherapp.data.model.weather.Weather

class Hourly {
    @SerializedName("dt")
    var dt: Long = 0
    @SerializedName("main")
    var main: Main? = null
    @SerializedName("weather")
    var weather : ArrayList<Weather>? = null
    @SerializedName("dt_txt")
    var dateText : String = ""
}