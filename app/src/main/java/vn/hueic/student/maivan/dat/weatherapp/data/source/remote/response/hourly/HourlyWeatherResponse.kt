package vn.hueic.student.maivan.dat.weatherapp.data.source.remote.response.hourly

import com.google.gson.annotations.SerializedName
import vn.hueic.student.maivan.dat.weatherapp.data.model.weather.hourly.Hourly

class HourlyWeatherResponse {
    @SerializedName("list")
    var weathers = ArrayList<Hourly>()
}