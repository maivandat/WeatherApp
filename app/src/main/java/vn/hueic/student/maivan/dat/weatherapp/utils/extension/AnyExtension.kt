package vn.hueic.student.maivan.dat.weatherapp.utils.extension

import vn.hueic.student.maivan.dat.weatherapp.R
import android.text.format.Time

object AnyExtension {

    fun setWheatherImage(data: String) : Int {

        if (data.startsWith("Rain")){
            return R.drawable.ic_rain_white_100dp
        } else if (data.startsWith("Clouds")) {
            return R.drawable.ic_clouds_white_100dp
        } else if (data.startsWith("Clear")) {
            return R.drawable.ic_clear_white_100dp
        } else {
            val arr = data.split(" ")
            for (i in arr) {
                return when(i) {
                    "Rain" -> R.drawable.ic_rain_white_100dp
                    "Clouds" -> R.drawable.ic_clouds_white_100dp
                    "Clear" -> R.drawable.ic_clear_white_100dp
                    else -> R.drawable.ic_sunny_white_100dp
                }
            }
        }

        return R.drawable.ic_sunny_white_100dp
    }
}

