package com.fshou.mouvie.data.network.response

import com.google.gson.annotations.SerializedName

data class ErrorResponse(

	@field:SerializedName("status_message")
	val statusMessage: String,

	@field:SerializedName("status_code")
	val statusCode: Int? = null,

	@field:SerializedName("success")
	val success: Boolean? = null
)
