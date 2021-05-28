package com.worklin.hiltdaggerhilt.di

import com.worklin.hiltdaggerhilt.data.DataSourceImpl
import com.worklin.hiltdaggerhilt.domain.DataSource
import com.worklin.hiltdaggerhilt.domain.Repo
import com.worklin.hiltdaggerhilt.domain.RepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class ActivityModule {

    @Binds
    abstract  fun bindRepoImpl(repoImpl: RepoImpl) : Repo

    @Binds
    abstract  fun bindDataSourceImpl(dataSourceImpl : DataSourceImpl) : DataSource



}