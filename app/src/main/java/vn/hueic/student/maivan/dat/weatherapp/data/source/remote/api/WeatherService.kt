package vn.hueic.student.maivan.dat.weatherapp.data.source.remote.api


import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import vn.hueic.student.maivan.dat.weatherapp.data.source.remote.response.hourly.HourlyWeatherResponse
import vn.hueic.student.maivan.dat.weatherapp.data.source.remote.response.current.WeatherResponse
import vn.hueic.student.maivan.dat.weatherapp.data.source.remote.response.daily.DailyWeatherResponse

interface WeatherService {
    @GET("data/2.5/weather?")
    fun getCurrentWeatherData(@Query("lat") lat: Float,
                              @Query("lon") lon: Float,
                              @Query("appid") app_id: String) : Observable<WeatherResponse>

    @GET("data/2.5/forecast/hourly?")
    fun getHourlyWeathers(@Query("lat") lat: Float,
                          @Query("lon") lon: Float,
                          @Query("appid") app_id: String) : Observable<HourlyWeatherResponse>

    @GET("data/2.5/forecast/daily?")
    fun getDailyWeathers(@Query("lat") lat: Float,
                          @Query("lon") lon: Float,
                          @Query("ctn") ctn: Int,
                          @Query("appid") app_id: String) : Observable<DailyWeatherResponse>
}
