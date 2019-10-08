package vn.hueic.student.maivan.dat.weatherapp.data.source.remote.connect

interface InternetConnectionListener {
    fun onInternetAvailable()
    fun onInternetUnavailable()
}