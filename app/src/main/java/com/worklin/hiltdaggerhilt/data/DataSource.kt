package com.worklin.hiltdaggerhilt.data

import com.worklin.hiltdaggerhilt.data.model.Drink
import com.worklin.hiltdaggerhilt.vo.Resource
import com.worklin.hiltdaggerhilt.vo.RetrofitClient

class DataSource {

    suspend fun getTragoByName(tragoName : String ) : Resource<List<Drink>>{
        return Resource.Success(RetrofitClient.webService.getTragoByName(tragoName).drinkList)
    }

    val generateTragosList = Resource.Success(
        listOf(
            Drink("https://img-global.cpcdn.com/recipes/6567ca7104eeee40/1502x1064cq70/tragos-campari-con-naranja-foto-principal.webp", "margarita", "con azucar , vodka y nuez"),
            Drink("https://img-global.cpcdn.com/recipes/6567ca7104eeee40/1502x1064cq70/tragos-campari-con-naranja-foto-principal.webp", "Fernet", "fernet con coca y 2 hielos"),
            Drink("https://img-global.cpcdn.com/recipes/6567ca7104eeee40/1502x1064cq70/tragos-campari-con-naranja-foto-principal.webp", "Toro", "Toro con pritty"),
            Drink("https://img-global.cpcdn.com/recipes/6567ca7104eeee40/1502x1064cq70/tragos-campari-con-naranja-foto-principal.webp", "Gancia", "Gancia con sprite")
        )
    )


}