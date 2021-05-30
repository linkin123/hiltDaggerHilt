package com.worklin.hiltdaggerhilt

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.worklin.hiltdaggerhilt.data.model.DrinkEntity
import com.worklin.hiltdaggerhilt.domain.TragosDao

@Database(entities = arrayOf(DrinkEntity::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun tragoDao(): TragosDao

/*
    companion object{
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase{
            INSTANCE = INSTANCE ?:
            Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "tabla_tragos" )
                .build()
            return INSTANCE!!
        }

        fun destroyInstance(){
            INSTANCE = null
        }
    }
*/

}