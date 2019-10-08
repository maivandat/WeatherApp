package vn.hueic.student.maivan.dat.weatherapp.utils.helper

import android.graphics.drawable.Drawable
import android.media.Image
import vn.hueic.student.maivan.dat.weatherapp.R
import java.math.RoundingMode
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

fun String.formatDateHourly(date : String) : String {
    val dateTemp = date.split(" ")
    val dateParse = dateTemp[1].split(":")
    return "${dateParse[0]}:${dateParse[1]}"
}

fun String.formatDateHourly(date : Long) : String {
    val sdf : SimpleDateFormat = SimpleDateFormat("HH : mm")
    val dateTemp = Date(date * 1000)
    return sdf.format(dateTemp)
}

fun String.formatDateDaily(date: Long) : String {
    val sdf : SimpleDateFormat = SimpleDateFormat("dd - MM - yyyy")
    val dateTemp = Date(date * 1000)
    return sdf.format(dateTemp)
}

fun String.Rounding(data : Float) : String {
    val numberFormat = NumberFormat.getNumberInstance()
    numberFormat.maximumFractionDigits = 0

    numberFormat.roundingMode = RoundingMode.UP
    return numberFormat.format(data)
}


