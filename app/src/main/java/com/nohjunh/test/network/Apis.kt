package com.nohjunh.test.network

import com.google.gson.JsonObject
import com.nohjunh.test.model.GptResponse
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface Apis {
    @Headers(
        "Content-Type:application/json",
        "Authorization:Bearer sk-2r9mINIaay7KW7HF76B29b36079b48BcA2DbCaD58530A5Bd")
    @POST("v1/completions")
    suspend fun postRequest(
        @Body json : JsonObject
    ) : GptResponse

}
