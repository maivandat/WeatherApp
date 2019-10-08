package vn.hueic.student.maivan.dat.weatherapp.ui.weather

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.activity_weather.*
import vn.hueic.student.maivan.dat.weatherapp.R
import vn.hueic.student.maivan.dat.weatherapp.databinding.ActivityWeatherBinding
import vn.hueic.student.maivan.dat.weatherapp.utils.extension.provideWeatherRepository
import vn.hueic.student.maivan.dat.weatherapp.utils.extension.setUpToolbar

class WeatherActivity : AppCompatActivity() {

    lateinit var weatherViewModel: WeatherViewModel
    lateinit var weatherBinding: ActivityWeatherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        weatherViewModel =
            WeatherViewModel(this, applicationContext.provideWeatherRepository())

        weatherBinding = DataBindingUtil.setContentView(this, R.layout.activity_weather)
        setUpToolbar(toolbar, getString(R.string.app_name))
        initializeUI()

    }

    private fun initializeUI() {
        weatherBinding.viewmodel = weatherViewModel
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu_weather, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.managerCities -> Log.d("menu", "Manager Cities")
            R.id.weatherWidget -> Log.d("menu", "Weather Widget")
            R.id.updateFrequency -> Log.d("menu", "Update Frequency")
        }
        return super.onOptionsItemSelected(item)
    }



}
