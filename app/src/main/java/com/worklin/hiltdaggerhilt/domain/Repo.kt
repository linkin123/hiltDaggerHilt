package com.worklin.hiltdaggerhilt.domain

import com.worklin.hiltdaggerhilt.data.model.Drink
import com.worklin.hiltdaggerhilt.vo.Resource

interface Repo {
    suspend fun getTragosList(tragoName : String) : Resource<List<Drink>>

}