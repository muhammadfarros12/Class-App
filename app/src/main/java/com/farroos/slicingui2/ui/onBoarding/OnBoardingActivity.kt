package com.farroos.slicingui2.ui.onBoarding

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.farroos.slicingui2.PageAdapter
import com.farroos.slicingui2.R
import com.farroos.slicingui2.databinding.ActivityOnBoardingBinding
import com.farroos.slicingui2.model.OnBoardingData

class OnBoardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnBoardingBinding
    private var itemList = ArrayList<OnBoardingData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpViewPager()

        binding.txtSkip.setOnClickListener {
            val currentItemPosition = binding.viewPager.currentItem
            binding.viewPager.setCurrentItem(currentItemPosition + 2, true)
        }

    }

    private fun setUpViewPager() {
        itemList = getItems()
        binding.viewPager.adapter = PageAdapter(itemList)
        binding.wormDot.setViewPager2(binding.viewPager)
        binding.viewPager.registerOnPageChangeCallback(pageClickCallback)
    }

    private var pageClickCallback: ViewPager2.OnPageChangeCallback = object : ViewPager2.OnPageChangeCallback(){
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)

            if (position == itemList.size -1){
                binding.wormDot.visibility = View.GONE
                binding.btnNext.visibility = View.VISIBLE
                binding.txtSkip.visibility = View.INVISIBLE
            } else {
                binding.wormDot.visibility = View.VISIBLE
                binding.btnNext.visibility = View.GONE
                binding.txtSkip.visibility = View.VISIBLE
            }

        }
    }

    private fun getItems(): ArrayList<OnBoardingData> {
        val items = ArrayList<OnBoardingData>()
        items.add(
            OnBoardingData(
                "Hello Welcome!",
                "Your financial journal starts here. weare is here to help you track and menstruate every 24 day transaction.",
                R.drawable.image_1
            )
        )

        items.add(
            OnBoardingData(
                "Hello Welcome!",
                "Your financial journal starts here. weare is here to help you track and menstruate every 24 day transaction.",
                R.drawable.image_2
            )
        )

        items.add(
            OnBoardingData(
                "Hello Welcome!",
                "Your financial journal starts here. weare is here to help you track and menstruate every 24 day transaction.",
                R.drawable.image_3
            )
        )
        return items
    }


}