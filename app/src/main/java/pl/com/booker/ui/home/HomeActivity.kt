package pl.com.booker.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.github.ahmadnemati.wind.enums.TrendType
import com.kwabenaberko.openweathermaplib.models.currentweather.CurrentWeather
import kotlinx.android.synthetic.main.activity_home.windView
import pl.com.booker.R
import pl.com.booker.databinding.ActivityHomeBinding
import pl.com.booker.ui.base.BaseActivity

class HomeActivity
    : BaseActivity<
        ActivityHomeBinding,
        HomeMvvm.View,
        HomeMvvm.ViewModel>(),
      HomeMvvm.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent.inject(this)
        setAndBindContentView(savedInstanceState, R.layout.activity_home)
    }


    override fun weatherFetched(weather: CurrentWeather) {
        windView.pressure = weather.main.pressure.toFloat()
        windView.pressureUnit = "in Hg"
        windView.setWindSpeed(weather.wind.speed.toFloat())
        windView.windSpeedUnit = "km/h"
        windView.trendType = TrendType.UP
        windView.start()
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.home_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
        }
        return true
    }

    companion object {
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, HomeActivity::class.java))
        }
    }
}