package com.worklin.hiltdaggerhilt.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.worklin.hiltdaggerhilt.AppDatabase
import com.worklin.hiltdaggerhilt.R
import com.worklin.hiltdaggerhilt.data.DataSource
import com.worklin.hiltdaggerhilt.data.model.Drink
import com.worklin.hiltdaggerhilt.data.model.DrinkEntity
import com.worklin.hiltdaggerhilt.databinding.FragmentMainBinding
import com.worklin.hiltdaggerhilt.databinding.FragmentTragosDetalleBinding
import com.worklin.hiltdaggerhilt.domain.RepoImpl
import com.worklin.hiltdaggerhilt.ui.viewmodel.MainViewModel
import com.worklin.hiltdaggerhilt.ui.viewmodel.VMFactory

class TragosDetalleFragment : Fragment() {

    private lateinit var binding : FragmentTragosDetalleBinding
    private lateinit var drink : Drink
    private val viewModel by viewModels<MainViewModel>{
        VMFactory(
            RepoImpl(
                DataSource(
                    AppDatabase.getDatabase(requireActivity().applicationContext
                    )
                )
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireArguments().let {
            drink = it.getParcelable("drink")!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tragos_detalle, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onclicks()
        with(binding){
            Glide.with(requireContext()).load(drink.imagen).centerCrop().into(ivTrago)
            tvTrago.text = drink.nombre
            tvDescription.text = drink.descripcion
        }
    }

    private fun onclicks() {
        binding.fabAddFavorites.setOnClickListener {
            viewModel.guardarTrago(DrinkEntity(drink.tragoId, drink.imagen, drink.nombre, drink.descripcion))
            Toast.makeText(requireContext(), "se guardo el trago en favoritos", Toast.LENGTH_SHORT)
                .show()

        }
    }

}