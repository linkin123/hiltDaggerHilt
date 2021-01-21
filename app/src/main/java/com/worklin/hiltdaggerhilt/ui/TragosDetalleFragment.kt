package com.worklin.hiltdaggerhilt.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.worklin.hiltdaggerhilt.R
import com.worklin.hiltdaggerhilt.data.model.Drink
import com.worklin.hiltdaggerhilt.databinding.FragmentMainBinding
import com.worklin.hiltdaggerhilt.databinding.FragmentTragosDetalleBinding

class TragosDetalleFragment : Fragment() {

    private lateinit var binding : FragmentTragosDetalleBinding
    private lateinit var drink : Drink

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
        with(binding){
            Glide.with(requireContext()).load(drink.imagen).centerCrop().into(ivTrago)
            tvTrago.text = drink.nombre
            tvDescription.text = drink.descripcion
        }
    }

}