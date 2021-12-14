package com.farroos.slicingui2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.farroos.slicingui2.databinding.ItemOnboardingScreenBinding
import com.farroos.slicingui2.model.OnBoardingData

class PageAdapter(private val items: ArrayList<OnBoardingData>) :
    RecyclerView.Adapter<PageAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            ItemOnboardingScreenBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            with(items[position]) {
                txtDescription.text = description
                txtTitle.text = title
                imgSlider.setImageResource(image)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(val binding: ItemOnboardingScreenBinding) :
        RecyclerView.ViewHolder(binding.root)
}