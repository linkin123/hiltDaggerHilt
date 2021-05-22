package com.worklin.hiltdaggerhilt.domain

import androidx.room.*
import com.worklin.hiltdaggerhilt.data.model.Drink
import com.worklin.hiltdaggerhilt.data.model.DrinkEntity

@Dao
interface TragosDao {

    @Query("SELECT * FROM tragosEntity")
    suspend fun getFavoriteDrinks(): List<DrinkEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(trago : DrinkEntity)

    @Delete
    suspend fun deleteDrink(drink: DrinkEntity)


}