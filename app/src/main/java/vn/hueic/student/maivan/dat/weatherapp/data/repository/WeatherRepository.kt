package vn.hueic.student.maivan.dat.weatherapp.data.repository
import io.reactivex.Observable
import vn.hueic.student.maivan.dat.weatherapp.data.source.WeatherDataSource
import vn.hueic.student.maivan.dat.weatherapp.data.source.local.WeatherLocalDataSource
import vn.hueic.student.maivan.dat.weatherapp.data.source.remote.WeatherRemoteDataSource
import vn.hueic.student.maivan.dat.weatherapp.data.source.remote.response.current.WeatherResponse
import vn.hueic.student.maivan.dat.weatherapp.data.source.remote.response.daily.DailyWeatherResponse
import vn.hueic.student.maivan.dat.weatherapp.data.source.remote.response.hourly.HourlyWeatherResponse

class WeatherRepository(private var local: WeatherLocalDataSource,
                        private var remote: WeatherRemoteDataSource)
    : WeatherDataSource.Local , WeatherDataSource.Remote {


    override fun getCurrentWeather(
        lat: Float,
        lng: Float,
        apiId: String
    ): Observable<WeatherResponse> {
        return remote.getCurrentWeather(lat, lng, apiId)
    }

    override fun getHourlyWeathers(
        lat: Float,
        lng: Float,
        apiId: String
    ): Observable<HourlyWeatherResponse> {
        return remote.getHourlyWeathers(lat, lng, apiId)
    }

    override fun getDailyWeathers(
        lat: Float,
        lng: Float,
        ctn: Int,
        appId: String
    ): Observable<DailyWeatherResponse> {
        return remote.getDailyWeathers(lat, lng, ctn, appId)
    }

    companion object {
        private var mInstance : WeatherRepository? = null

        fun getInstance(local: WeatherLocalDataSource, remote: WeatherRemoteDataSource) : WeatherRepository? {
            if (mInstance == null) {
                mInstance = WeatherRepository(local, remote)
            }
            return mInstance
        }
    }


}