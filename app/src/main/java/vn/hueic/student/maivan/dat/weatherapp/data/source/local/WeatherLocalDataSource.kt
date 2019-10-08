package vn.hueic.student.maivan.dat.weatherapp.data.source.local

import vn.hueic.student.maivan.dat.weatherapp.data.source.WeatherDataSource

class WeatherLocalDataSource : WeatherDataSource.Local {
    companion object {
        private var mInstance : WeatherLocalDataSource? = null

        fun getInstance() : WeatherLocalDataSource? {
            if (mInstance == null) {
                mInstance = WeatherLocalDataSource()
            }
            return mInstance
        }

    }
}