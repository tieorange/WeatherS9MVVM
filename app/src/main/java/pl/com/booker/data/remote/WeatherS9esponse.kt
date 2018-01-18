package pl.edu.pawelsienkiewicz.data.remote

import com.google.gson.annotations.SerializedName

data class WeatherS9esponse(

	@field:SerializedName("kaloryfer001")
	val kaloryfer001: Kaloryfer001? = null
)