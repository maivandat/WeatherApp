package vn.hueic.student.maivan.dat.weatherapp.data.model.weather

import com.google.gson.annotations.SerializedName

class Rain {
    @SerializedName("3h")
    var h3: Float = 0.toFloat()
}