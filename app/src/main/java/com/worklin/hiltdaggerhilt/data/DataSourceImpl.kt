package com.worklin.hiltdaggerhilt.data

import com.worklin.hiltdaggerhilt.AppDatabase
import com.worklin.hiltdaggerhilt.data.model.Drink
import com.worklin.hiltdaggerhilt.data.model.DrinkEntity
import com.worklin.hiltdaggerhilt.domain.DataSource
import com.worklin.hiltdaggerhilt.domain.TragosDao
import com.worklin.hiltdaggerhilt.vo.Resource
import com.worklin.hiltdaggerhilt.vo.RetrofitClient
import javax.inject.Inject

//class DataSourceImpl @Inject constructor(private val appDatabase: AppDatabase) : DataSource {
class DataSourceImpl @Inject constructor(private val tragosDao: TragosDao) : DataSource {

    override suspend fun getTragoByName(tragoName: String): Resource<List<Drink>> {
        return Resource.Success(RetrofitClient.webService.getTragoByName(tragoName).drinkList)
    }

    override suspend fun insertTragoIntoRoom(trago: DrinkEntity) {
        tragosDao.insertFavorite(trago)
    }

    override suspend fun getTragosFavoritos(): Resource<List<DrinkEntity>> {
        return Resource.Success(tragosDao.getFavoriteDrinks())
    }

    override suspend fun deleteDrink(drink: Drink) {
        tragosDao.deleteDrink(drink.asfavoriteEntity())
    }


/*
    override suspend fun getTragoByName(tragoName: String): Resource<List<Drink>> {
        return Resource.Success(RetrofitClient.webService.getTragoByName(tragoName).drinkList)
    }

    override suspend fun insertTragoIntoRoom(trago: DrinkEntity) {
        appDatabase.tragoDao().insertFavorite(trago)
    }

    override suspend fun getTragosFavoritos(): Resource<List<DrinkEntity>> {
        return Resource.Success(appDatabase.tragoDao().getFavoriteDrinks())
    }

    override suspend fun deleteDrink(drink: Drink) {
        appDatabase.tragoDao().deleteDrink(drink.asfavoriteEntity())
    }
*/

/*
    val generateTragosList = Resource.Success(
        listOf(
            Drink("https://img-global.cpcdn.com/recipes/6567ca7104eeee40/1502x1064cq70/tragos-campari-con-naranja-foto-principal.webp", "margarita", "con azucar , vodka y nuez"),
            Drink("https://img-global.cpcdn.com/recipes/6567ca7104eeee40/1502x1064cq70/tragos-campari-con-naranja-foto-principal.webp", "Fernet", "fernet con coca y 2 hielos"),
            Drink("https://img-global.cpcdn.com/recipes/6567ca7104eeee40/1502x1064cq70/tragos-campari-con-naranja-foto-principal.webp", "Toro", "Toro con pritty"),
            Drink("https://img-global.cpcdn.com/recipes/6567ca7104eeee40/1502x1064cq70/tragos-campari-con-naranja-foto-principal.webp", "Gancia", "Gancia con sprite")
        )
    )
*/


}

private fun Drink.asfavoriteEntity(): DrinkEntity {
    return DrinkEntity(
        this.tragoId,
        this.imagen,
        this.nombre,
        this.descripcion
    )
}
