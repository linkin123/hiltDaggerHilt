package com.worklin.hiltdaggerhilt.domain

import com.worklin.hiltdaggerhilt.data.model.Drink
import com.worklin.hiltdaggerhilt.data.model.DrinkList
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    @GET("search.php?")
    suspend fun getTragoByName(@Query("s") tragoName: String): DrinkList
}