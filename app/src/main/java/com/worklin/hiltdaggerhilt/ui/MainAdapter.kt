package com.worklin.hiltdaggerhilt.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.worklin.hiltdaggerhilt.R
import com.worklin.hiltdaggerhilt.data.base.BaseViewHolder
import com.worklin.hiltdaggerhilt.data.model.Drink
import com.worklin.hiltdaggerhilt.databinding.TragosRowBinding

class MainAdapter(
    private val context: Context,
    private val tragosList: List<Drink>,
    private val itemClick: OnTragoClickListener
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return MainViewHolder(
            LayoutInflater.from(context).inflate(R.layout.tragos_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is MainViewHolder -> holder.bind(tragosList[position], position)
        }
    }

    override fun getItemCount(): Int {
        return tragosList.size
    }

    inner class MainViewHolder(itemView: View) : BaseViewHolder<Drink>(itemView) {
        val binding = TragosRowBinding.bind(itemView)
        override fun bind(item: Drink, position: Int) {
            Glide.with(context).load(item.imagen).into(binding.imgTrago)
            binding.tvName.text = item.nombre
            binding.tvDescription.text = item.descripcion
            itemView.setOnClickListener {
                itemClick.onTragoClick(item, position)
            }
        }
    }

    interface OnTragoClickListener {
        fun onTragoClick(drink: Drink, position: Int)
    }

}