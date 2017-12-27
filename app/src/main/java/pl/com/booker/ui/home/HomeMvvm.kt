package pl.com.booker.ui.home

import android.databinding.ObservableField
import com.kwabenaberko.openweathermaplib.models.currentweather.CurrentWeather
import pl.com.booker.ui.base.view.MvvmView
import pl.com.booker.ui.base.viewmodel.MvvmViewModel

class HomeMvvm {

    interface View : MvvmView {
        fun weatherFetched(weather: CurrentWeather)
    }

    interface ViewModel : MvvmViewModel<View> {
        val temperatura: ObservableField<String>
        val wilogtnosc: ObservableField<String>
        val cisnienie: ObservableField<String>
    }

}