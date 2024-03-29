package com.worklin.hiltdaggerhilt.domain

import com.worklin.hiltdaggerhilt.data.DataSourceImpl
import com.worklin.hiltdaggerhilt.data.model.Drink
import com.worklin.hiltdaggerhilt.data.model.DrinkEntity
import com.worklin.hiltdaggerhilt.vo.Resource
import javax.inject.Inject

class RepoImpl @Inject constructor(private val dataSource : DataSourceImpl): Repo {
    override suspend fun  getTragosList(tragoName : String ): Resource<List<Drink>> {
        return dataSource.getTragoByName(tragoName)
    }

    override suspend fun getTragosFavoritos(): Resource<List<DrinkEntity>> {
        return dataSource.getTragosFavoritos()
    }

    override suspend fun insertTrago(trago: DrinkEntity) {
        dataSource.insertTragoIntoRoom(trago)
    }

    override suspend fun deleteDrink(drink: Drink) {
        dataSource.deleteDrink(drink)
    }


}