package vn.hueic.student.maivan.dat.weatherapp.data.source.remote.response.daily

import com.google.gson.annotations.SerializedName
import vn.hueic.student.maivan.dat.weatherapp.data.model.weather.daily.Daily
import java.util.ArrayList

class DailyWeatherResponse {
    @SerializedName("list")
    var weathers = ArrayList<Daily>()
}