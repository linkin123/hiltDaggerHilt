package com.worklin.hiltdaggerhilt.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Drink(
    @SerializedName("idDrink")
    val tragoId: String = "",
    @SerializedName("strDrinkThumb")
    val imagen: String = "",
    @SerializedName("strDrink")
    val nombre: String = "",
    @SerializedName("strInstructions")
    val descripcion: String = "",
) : Parcelable

data class DrinkList(
    @SerializedName("drinks")
    val drinkList: List<Drink>
)

@Entity(tableName= "tragosEntity")
data class DrinkEntity(
    @PrimaryKey
    val tragoId : String,

    @ColumnInfo(name = "trago_imagen")
    val imagen: String = "",

    @ColumnInfo(name ="trago_nombre")
    val nombre: String = "",

    @ColumnInfo(name ="trago_descripcion")
    val descripcion: String = "",
)
