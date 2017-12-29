package pl.com.booker.ui.home

import android.content.Context
import android.databinding.ObservableField
import android.os.Bundle
import com.kwabenaberko.openweathermaplib.Units
import com.kwabenaberko.openweathermaplib.implementation.OpenWeatherMapHelper
import com.kwabenaberko.openweathermaplib.implementation.OpenWeatherMapHelper.CurrentWeatherCallback
import com.kwabenaberko.openweathermaplib.models.currentweather.CurrentWeather
import com.mcxiaoke.koi.ext.toast
import io.reactivex.android.schedulers.AndroidSchedulers
import pl.com.booker.R.string
import pl.com.booker.data.remote.MyApi
import pl.com.booker.data.remote.WeatherS9esponse
import pl.com.booker.injection.qualifier.ActivityContext
import pl.com.booker.injection.scopes.PerActivity
import pl.com.booker.ui.base.viewmodel.RxBaseViewModel
import pl.com.booker.ui.home.HomeMvvm.View
import javax.inject.Inject

@PerActivity
class HomeViewModel
@Inject
constructor(
        @ActivityContext private val context: Context,
        private val myApi: MyApi
) : RxBaseViewModel<HomeMvvm.View>(),
    HomeMvvm.ViewModel {

    private val defaultError = "Loading..."
    override val temperatura = ObservableField<String>(defaultError)
    override val wilogtnosc = ObservableField<String>(defaultError)
    override val cisnienie = ObservableField<String>(defaultError)

    override val temperatureOutside = ObservableField<String>(defaultError)

    override fun attachView(view: HomeMvvm.View, savedInstanceState: Bundle?) {
        super.attachView(view, savedInstanceState)

        initWeather(view)
        initS9()
    }

    private fun initS9() {
        val disposable = myApi.getWeatherData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { s9Weather -> processS9Weather(s9Weather) },
                        { context.toast(it.message.toString()) }
                )

        this.disposable.add(disposable)
    }

    private fun processS9Weather(s9Weather: WeatherS9esponse?) {
        temperatura.set(s9Weather?.kaloryfer001?.temp ?: defaultError)
        wilogtnosc.set(s9Weather?.kaloryfer001?.wilg ?: defaultError)
        cisnienie.set(s9Weather?.kaloryfer001?.cisnienie ?: defaultError)
    }

    private fun initWeather(view: View) {
        val helper = OpenWeatherMapHelper()
        helper.setApiKey((context.getString(string.OPEN_WEATHER_MAP_API_KEY)))
        helper.setUnits(Units.METRIC)
        helper.getCurrentWeatherByGeoCoordinates(
                52.2239, 20.9940, object : CurrentWeatherCallback {
            override fun onSuccess(weather: CurrentWeather) {
                processOutsideWeather(weather, view)
                return
            }

            override fun onFailure(throwable: Throwable) {
                context.toast("Check your Internet connection")
            }
        }
        )
    }

    private fun processOutsideWeather(weather: CurrentWeather, view: View) {
        val temp = weather.main.temp.toString()
        temperatureOutside.set(temp)
        view.weatherFetched(weather)
    }

}