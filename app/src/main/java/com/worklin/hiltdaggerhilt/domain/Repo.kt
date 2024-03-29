package com.worklin.hiltdaggerhilt.domain

import com.worklin.hiltdaggerhilt.data.model.Drink
import com.worklin.hiltdaggerhilt.data.model.DrinkEntity
import com.worklin.hiltdaggerhilt.vo.Resource

interface Repo {
    suspend fun getTragosList(tragoName : String) : Resource<List<Drink>>
    suspend fun getTragosFavoritos(): Resource<List<DrinkEntity>>
    suspend fun insertTrago(trago : DrinkEntity)
    suspend fun deleteDrink(drink: Drink)

}