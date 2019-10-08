package vn.hueic.student.maivan.dat.weatherapp.ui.weather

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.util.Log
import vn.hueic.student.maivan.dat.weatherapp.R
import androidx.databinding.BaseObservable
import androidx.databinding.ObservableField
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import vn.hueic.student.maivan.dat.weatherapp.BuildConfig
import vn.hueic.student.maivan.dat.weatherapp.data.model.weather.daily.Daily
import vn.hueic.student.maivan.dat.weatherapp.data.model.weather.hourly.Hourly
import vn.hueic.student.maivan.dat.weatherapp.data.repository.WeatherRepository
import vn.hueic.student.maivan.dat.weatherapp.data.source.remote.api.Api
import vn.hueic.student.maivan.dat.weatherapp.data.source.remote.response.current.WeatherResponse
import vn.hueic.student.maivan.dat.weatherapp.ui.adapter.DailyWeatherAdapter
import vn.hueic.student.maivan.dat.weatherapp.ui.adapter.HourlyWeatherAdapter
import vn.hueic.student.maivan.dat.weatherapp.utils.extension.AnyExtension
import vn.hueic.student.maivan.dat.weatherapp.utils.helper.Rounding
import vn.hueic.student.maivan.dat.weatherapp.utils.helper.formatDateDaily
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class WeatherViewModel (
    private val context: Context,
    private val weatherRepository: WeatherRepository
) : BaseObservable() {

    val weatherObservable: ObservableField<WeatherResponse> = ObservableField()
    val adapterHourlyObservable: ObservableField<HourlyWeatherAdapter> = ObservableField()
    val adapterDailyObservable: ObservableField<DailyWeatherAdapter> = ObservableField()

    init {
        setupAdapter()
        loadData()
    }

    private fun setupAdapter() {
        adapterHourlyObservable.set(HourlyWeatherAdapter())
        adapterDailyObservable.set(DailyWeatherAdapter())
    }

    private fun loadData() {
        getCurrentWeather(Api.lat, Api.lng, BuildConfig.APPID)
        getHourlyWeather(Api.lat, Api.lng, BuildConfig.APPID)
        getDailyWeather(Api.lat, Api.lng, Api.ctn, BuildConfig.APPID)
    }

    @SuppressLint("CheckResult")
    fun getCurrentWeather(lat: Float, lng: Float, appId: String) {
        weatherRepository.getCurrentWeather(lat, lng, appId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                weatherObservable.set(it)
                Log.d("response", "${it.main!!.temp}")
                Log.d("response", "${it.wind!!.speed}")
                Log.d("response", "${it.wind!!.deg}")
            }, {
                Log.e("Error", it.message)
            })
    }

    @SuppressLint("CheckResult")
    fun getHourlyWeather(lat: Float, lng: Float, appId: String) {
        weatherRepository.getHourlyWeathers(lat, lng, appId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                adapterHourlyObservable.get()!!.replaceItems(it.weathers)
            }, {
                Log.e("Error", it.message.toString())
            })

    }

    @SuppressLint("CheckResult")
    fun getDailyWeather(lat: Float, lng: Float, ctn: Int, appId: String) {
        weatherRepository.getDailyWeathers(lat, lng, ctn, appId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d("responseDaily", String().formatDateDaily(it.weathers[0].date * 1000))
                adapterDailyObservable.get()!!.replaceItems(filterTimeDaily(it.weathers))
            }, {
                Log.e("Error", it.message.toString())
            })

    }

    fun getTempRounding(data: Float): String = String().Rounding(data)

    fun windDirection(data: Float?): String? {
        if (data!! >= 337.5f || data!! <= 22.5f) {
            return context.resources.getString(R.string.north)
        }
        if (data!! >= 22.5f || data!! <= 67.5) {
            return context.resources.getString(R.string.northEast)
        }
        if (data!! >= 67.5f || data!! <= 112.5) {
            return context.resources.getString(R.string.east)
        }
        if (data!! >= 112.5f || data!! <= 157.5) {
            return context.resources.getString(R.string.southEast)
        }
        if (data!! >= 157.5f || data!! <= 202.5) {
            return context.resources.getString(R.string.south)
        }
        if (data!! >= 202.5f || data!! <= 247.5) {
            return context.resources.getString(R.string.southWest)
        }
        if (data!! >= 247.5f || data!! <= 292.5) {
            return context.resources.getString(R.string.west)
        }
        if (data!! >= 292.5f || data!! <= 337.5) {
            return context.resources.getString(R.string.northWest)
        }
        return ""
    }

    fun filterTimeDaily(arr: ArrayList<Daily>?) : ArrayList<Daily> {
        val sdfCurrent = SimpleDateFormat("dd-MM-yyyy").format(Date())
        val itemDayCurrent = sdfCurrent.split("-")[0]
        val itemMonthCurrent = sdfCurrent.split("-")[1]
        Log.d("sdfCurrent", sdfCurrent)
        var arrD = ArrayList<Daily>()
        if (arr!!.size == 0) {
            Log.d("filterTimeDaily", "Data null")
        }else {
            for (d in arr) {
                val sdfItem = SimpleDateFormat("dd-MM-yyyy").format(d.date * 1000)
                val itemDayItem = sdfItem.split("-")[0]
                val itemMonthItem = sdfItem.split("-")[1]
                Log.d("sdfItem", sdfItem)
                if (!sdfItem.equals(sdfCurrent)) {
                    if (itemDayItem.toInt() > itemDayCurrent.toInt()) {
                        if (arrD.size <= 7) {
                            arrD.add(d)

                        }
                    }else {
                        if (itemMonthItem.toInt() > itemMonthCurrent.toInt()) {
                            if (arrD.size <= 7){
                                arrD.add(d)
                            }
                        }
                    }
                }
            }
        }
        return arrD
    }


}