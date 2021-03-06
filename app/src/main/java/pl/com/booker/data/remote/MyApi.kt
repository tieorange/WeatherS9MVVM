package pl.com.booker.data.remote

import io.reactivex.Single
import retrofit2.http.GET

interface MyApi {

    @GET("json")
    fun getWeatherData() : Single<WeatherS9esponse>
}