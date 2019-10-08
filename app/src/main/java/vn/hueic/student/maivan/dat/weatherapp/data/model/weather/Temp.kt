package vn.hueic.student.maivan.dat.weatherapp.data.model.weather

import com.google.gson.annotations.SerializedName

class Temp {
    @SerializedName("day")
    var day: Float = 0.toFloat()
    @SerializedName("min")
    var min: Float = 0.toFloat()
    @SerializedName("max")
    var max: Float = 0.toFloat()
    @SerializedName("night")
    var night: Float = 0.toFloat()
    @SerializedName("eve")
    var eve: Float = 0.toFloat()
    @SerializedName("morn")
    var morn: Float = 0.toFloat()
}