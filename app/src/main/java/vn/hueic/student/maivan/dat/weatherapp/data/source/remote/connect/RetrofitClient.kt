package vn.hueic.student.maivan.dat.weatherapp.data.source.remote.connect

import android.content.Context
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import vn.hueic.student.maivan.dat.weatherapp.data.source.remote.api.Api
import vn.hueic.student.maivan.dat.weatherapp.data.source.remote.api.WeatherService
import java.util.concurrent.TimeUnit
import vn.hueic.student.maivan.dat.weatherapp.utils.extension.isNetworkStatusAvailable


class RetrofitClient(private val context: Context) {

    private var weatherService: WeatherService? = null
    private var internetConnectionListener : InternetConnectionListener? = null

    fun getWeatherService() : WeatherService? {
        if (weatherService == null) {
            weatherService = getClient(Api.BASE_URL).create(WeatherService::class.java)
        }
        return weatherService
    }

    private fun getClient (baseUrl: String) : Retrofit {
        val builder = OkHttpClient.Builder()
            .readTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.MILLISECONDS)
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
            .addInterceptor(object : NetworkConnectionInterceptor() {

                override fun isInternetAvailable(): Boolean = checkInternetAvailable()

                override fun onInternetAvailable() {
                    internetConnectionListener?.onInternetAvailable()
                }

                override fun onInternetUnavailable() {
                    internetConnectionListener?.onInternetUnavailable()
                }

            })
            .retryOnConnectionFailure(true)
            .build()

        var gson = GsonBuilder().setLenient().create()
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(builder)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    private fun checkInternetAvailable() : Boolean = context.isNetworkStatusAvailable()

    companion object {
        const val READ_TIMEOUT = 5000L
        const val WRITE_TIMEOUT = 5000L
        const val CONNECT_TIMEOUT = 8000L
    }

}