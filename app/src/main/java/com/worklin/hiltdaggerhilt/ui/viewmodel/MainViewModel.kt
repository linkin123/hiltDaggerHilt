package com.worklin.hiltdaggerhilt.ui.viewmodel

import androidx.lifecycle.*
import com.worklin.hiltdaggerhilt.domain.Repo
import com.worklin.hiltdaggerhilt.vo.Resource
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val repo : Repo) : ViewModel() {

    private val tragosData = MutableLiveData<String>()

    fun setTrago(tragoName : String){
        tragosData.value = tragoName
    }
    init {
        setTrago("margarita") 
    }


    val fetchTragosList = tragosData.distinctUntilChanged().switchMap { nombreTrago ->
        liveData(Dispatchers.IO) {
            emit(Resource.Loading())
            try {
                emit(repo.getTragosList(nombreTrago))
            } catch (e: Exception) {

            }
        }
    }


}