package pl.com.booker.ui.home

import android.content.Context
import android.databinding.ObservableField
import android.os.Bundle
import com.kwabenaberko.openweathermaplib.Units
import com.kwabenaberko.openweathermaplib.implementation.OpenWeatherMapHelper
import com.kwabenaberko.openweathermaplib.implementation.OpenWeatherMapHelper.CurrentWeatherCallback
import com.kwabenaberko.openweathermaplib.models.currentweather.CurrentWeather
import com.mcxiaoke.koi.ext.toast
import pl.com.booker.R
import pl.com.booker.injection.qualifier.ActivityContext
import pl.com.booker.injection.scopes.PerActivity
import pl.com.booker.ui.base.viewmodel.RxBaseViewModel
import javax.inject.Inject

@PerActivity
class HomeViewModel
@Inject
constructor(@ActivityContext private val context: Context) : RxBaseViewModel<HomeMvvm.View>(),
                                                             HomeMvvm.ViewModel {

    override val temperature = ObservableField<String>("0 6")

    override fun attachView(view: HomeMvvm.View, savedInstanceState: Bundle?) {
        super.attachView(view, savedInstanceState)

        val helper = OpenWeatherMapHelper()
        helper.setApiKey((context.getString(R.string.OPEN_WEATHER_MAP_API_KEY)))
        helper.setUnits(Units.METRIC)
        helper.getCurrentWeatherByGeoCoordinates(
                52.2239, 20.9940, object : CurrentWeatherCallback {
            override fun onSuccess(weather: CurrentWeather) {
                val temp = weather.main.temp.toString()
                temperature.set(temp)
            }

            override fun onFailure(throwable: Throwable) {
                context.toast("Check your Internet connection")
            }

        }
        )

    }

}