package vn.hueic.student.maivan.dat.weatherapp.data.source.remote

import io.reactivex.Observable
import vn.hueic.student.maivan.dat.weatherapp.data.source.WeatherDataSource
import vn.hueic.student.maivan.dat.weatherapp.data.source.remote.api.WeatherService
import vn.hueic.student.maivan.dat.weatherapp.data.source.remote.connect.RetrofitClient
import vn.hueic.student.maivan.dat.weatherapp.data.source.remote.response.current.WeatherResponse
import vn.hueic.student.maivan.dat.weatherapp.data.source.remote.response.daily.DailyWeatherResponse
import vn.hueic.student.maivan.dat.weatherapp.data.source.remote.response.hourly.HourlyWeatherResponse

class WeatherRemoteDataSource private constructor(retrofitClient: RetrofitClient): WeatherDataSource.Remote {


    private var requestService : WeatherService = retrofitClient.getWeatherService()!!

    override fun getCurrentWeather(
        lat: Float,
        lng: Float,
        apiId: String
    ) : Observable<WeatherResponse> {
        return requestService.getCurrentWeatherData(lat, lng, apiId)
    }

    override fun getHourlyWeathers(
        lat: Float,
        lng: Float,
        apiId: String
    ): Observable<HourlyWeatherResponse> {
        return requestService.getHourlyWeathers(lat, lng, apiId)
    }

    override fun getDailyWeathers(lat: Float, lng: Float, ctn: Int, appId: String) : Observable<DailyWeatherResponse> {
        return requestService.getDailyWeathers(lat, lng, ctn, appId)
    }

    companion object {
        private var mInstance : WeatherRemoteDataSource? = null

        fun getInstance(retrofitClient: RetrofitClient) : WeatherRemoteDataSource? {
            if (mInstance == null) {
                mInstance = WeatherRemoteDataSource(retrofitClient)
            }
            return mInstance
        }

    }
}