package pl.com.booker.data.remote

import com.google.gson.annotations.SerializedName

data class Kaloryfer001(

	@field:SerializedName("temp")
	val temp: String? = null,

	@field:SerializedName("cisnienie")
	val cisnienie: String? = null,

	@field:SerializedName("wilg")
	val wilg: String? = null
)