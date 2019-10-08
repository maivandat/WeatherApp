package vn.hueic.student.maivan.dat.weatherapp.data.source.remote.response.current

import com.google.gson.annotations.SerializedName
import vn.hueic.student.maivan.dat.weatherapp.data.model.sys.Sys
import vn.hueic.student.maivan.dat.weatherapp.data.model.weather.*

import kotlin.collections.ArrayList

class WeatherResponse {
    @SerializedName("coord")
    var coord: Coord? = null
    @SerializedName("sys")
    var sys: Sys? = null
    @SerializedName("weather")
    var weather = ArrayList<Weather>()
    @SerializedName("main")
    var main: Main? = null
    @SerializedName("wind")
    var wind: Wind? = null
    @SerializedName("rain")
    var rain: Rain? = null
    @SerializedName("clouds")
    var clouds: Clouds? = null
    @SerializedName("dt")
    var dt: Long = 0
    @SerializedName("id")
    var id: Int = 0
    @SerializedName("name")
    var location: String? = null
    @SerializedName("cod")
    var cod: Float = 0.toFloat()
}