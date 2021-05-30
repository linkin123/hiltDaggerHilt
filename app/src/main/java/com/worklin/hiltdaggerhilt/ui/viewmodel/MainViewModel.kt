package com.worklin.hiltdaggerhilt.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.worklin.hiltdaggerhilt.data.model.Drink
import com.worklin.hiltdaggerhilt.data.model.DrinkEntity
import com.worklin.hiltdaggerhilt.domain.Repo
import com.worklin.hiltdaggerhilt.vo.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

//@HiltViewModel
class MainViewModel @ViewModelInject constructor(private val repo : Repo) : ViewModel() {

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
                //emit(Resource.Failure(e))
            }
        }
    }

    fun guardarTrago(trago : DrinkEntity){
        viewModelScope.launch {
            repo.insertTrago(trago)
        }
    }

    fun getTRagosFavoritos() = liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try {
            emit(repo.getTragosFavoritos())
        } catch (e: Exception) {
            //emit(Resource.Failure(e))
        }
    }

    fun deleteDrink(drink : Drink){
        viewModelScope.launch {
            repo.deleteDrink(drink)

        }
    }

}