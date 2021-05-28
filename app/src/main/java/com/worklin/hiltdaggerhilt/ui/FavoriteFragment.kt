package com.worklin.hiltdaggerhilt.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.worklin.hiltdaggerhilt.AppDatabase
import com.worklin.hiltdaggerhilt.R
import com.worklin.hiltdaggerhilt.data.DataSourceImpl
import com.worklin.hiltdaggerhilt.data.model.Drink
import com.worklin.hiltdaggerhilt.databinding.FragmentFavoriteBinding
import com.worklin.hiltdaggerhilt.domain.RepoImpl
import com.worklin.hiltdaggerhilt.ui.viewmodel.MainViewModel
import com.worklin.hiltdaggerhilt.ui.viewmodel.VMFactory
import com.worklin.hiltdaggerhilt.vo.Resource

class FavoriteFragment : Fragment(), MainAdapter.OnTragoClickListener {

    private val viewModel by viewModels<MainViewModel>{
        VMFactory(
            RepoImpl(
                DataSourceImpl(
                    AppDatabase.getDatabase(requireActivity().applicationContext
                    )
                )
            )
        )
    }

    private lateinit var binding : FragmentFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_favorite, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerview()
        setUpObservers()
    }

    private fun setUpObservers(){
        viewModel.getTRagosFavoritos().observe(viewLifecycleOwner, Observer {result ->
            when(result){
                is Resource.Loading-> {}
                is Resource.Success->{
                    val list = result.data.map{
                        Drink(it.tragoId, it.imagen, it.nombre, it.descripcion)
                    }
                    binding.rvFavoriteTragos.adapter = MainAdapter(requireContext(), list, this)
                }
                is Resource.Failure->{}

            }

        })
    }

    private fun setUpRecyclerview(){
        with(binding.rvFavoriteTragos){
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))

        }
    }

    override fun onTragoClick(drink: Drink, position: Int) {
        viewModel.deleteDrink(drink)
        binding.rvFavoriteTragos.adapter?.notifyItemRemoved(position)
    }
}