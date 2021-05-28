package com.worklin.hiltdaggerhilt.domain

import com.worklin.hiltdaggerhilt.data.model.Drink
import com.worklin.hiltdaggerhilt.data.model.DrinkEntity
import com.worklin.hiltdaggerhilt.vo.Resource
import com.worklin.hiltdaggerhilt.vo.RetrofitClient

interface DataSource {

    suspend fun getTragoByName(tragoName: String): Resource<List<Drink>>
    suspend fun insertTragoIntoRoom(trago: DrinkEntity)
    suspend fun getTragosFavoritos(): Resource<List<DrinkEntity>>
    suspend fun deleteDrink(drink: Drink)

}