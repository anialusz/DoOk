package com.example.dook.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dook.AstronomicPictures
import com.example.dook.databinding.ItemAstronomicPictureBinding

class AstronomicAdapter(
    private val dataSet: List<AstronomicPictures>,
    private val onClick: (AstronomicPictures) -> Unit
) :
    RecyclerView.Adapter<AstronomicAdapter.ViewHolder>() {

    class ViewHolder(
        private val binding: ItemAstronomicPictureBinding,
        val onClick: (AstronomicPictures) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: AstronomicPictures) {
            binding.tvTitle.text = item.title

            Glide.with(binding.root)
                .load(item.url)
                .centerCrop()
                .into(binding.ivBackground)

            binding.cvAstronomicItem.setOnClickListener {
                onClick(item)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val inflater =
            ItemAstronomicPictureBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(inflater, onClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(dataSet[position])
    }

    override fun getItemCount(): Int = dataSet.size

}