package com.worklin.hiltdaggerhilt.domain

import com.worklin.hiltdaggerhilt.data.DataSource
import com.worklin.hiltdaggerhilt.data.model.Drink
import com.worklin.hiltdaggerhilt.vo.Resource

class RepoImpl(private val dataSource : DataSource): Repo {
    override suspend fun  getTragosList(tragoName : String ): Resource<List<Drink>> {
        return dataSource.getTragoByName(tragoName)
    }
}