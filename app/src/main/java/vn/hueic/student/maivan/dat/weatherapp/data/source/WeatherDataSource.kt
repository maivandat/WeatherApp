package vn.hueic.student.maivan.dat.weatherapp.data.source

import io.reactivex.Observable
import vn.hueic.student.maivan.dat.weatherapp.data.source.remote.response.current.WeatherResponse
import vn.hueic.student.maivan.dat.weatherapp.data.source.remote.response.daily.DailyWeatherResponse
import vn.hueic.student.maivan.dat.weatherapp.data.source.remote.response.hourly.HourlyWeatherResponse

interface WeatherDataSource {
    interface Local {

    }

    interface Remote {
        fun getCurrentWeather(lat : Float, lng: Float, appId : String) : Observable<WeatherResponse>
        fun getHourlyWeathers(lat : Float, lng: Float, appId : String) : Observable<HourlyWeatherResponse>
        fun getDailyWeathers(lat: Float, lng: Float, ctn: Int, appId: String) : Observable<DailyWeatherResponse>
    }
}