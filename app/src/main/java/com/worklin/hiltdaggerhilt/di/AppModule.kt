package com.worklin.hiltdaggerhilt.di

import android.content.Context
import androidx.room.Room
import com.worklin.hiltdaggerhilt.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
//import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRoomInstance(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, AppDatabase::class.java, "tabla_tragos")
            .build()


    @Singleton
    @Provides
    fun provideTragosDao(db: AppDatabase) = db.tragoDao()

}