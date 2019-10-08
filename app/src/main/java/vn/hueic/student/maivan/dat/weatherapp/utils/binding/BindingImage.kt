package vn.hueic.student.maivan.dat.weatherapp.utils.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter

object BindingImage {

    @JvmStatic
    @BindingAdapter("bindImageRes")
    fun bindImageRes(imageView: ImageView, res: Int) {
        imageView.setImageResource(res)
    }
}