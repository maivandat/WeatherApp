package vn.hueic.student.maivan.dat.weatherapp.utils.extension

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import vn.hueic.student.maivan.dat.weatherapp.data.repository.WeatherRepository
import vn.hueic.student.maivan.dat.weatherapp.data.source.local.WeatherLocalDataSource
import vn.hueic.student.maivan.dat.weatherapp.data.source.remote.WeatherRemoteDataSource
import vn.hueic.student.maivan.dat.weatherapp.data.source.remote.connect.RetrofitClient


fun AppCompatActivity.setUpToolbar(toolbar: Toolbar, titleText: String = "") {
    setSupportActionBar(toolbar)
    supportActionBar?.run {
        title = titleText
    }
}
fun Context.provideWeatherRepository() : WeatherRepository {
    return WeatherRepository.getInstance(
        WeatherLocalDataSource.getInstance()!!,
        WeatherRemoteDataSource.getInstance(
        RetrofitClient(this)
    )!!)!!
}

fun Context.isNetworkStatusAvailable() : Boolean {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
    return connectivityManager?.activeNetworkInfo?.isConnected ?: false
}
