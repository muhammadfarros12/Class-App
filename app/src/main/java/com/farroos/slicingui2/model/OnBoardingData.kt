package com.farroos.slicingui2.model

import androidx.annotation.DrawableRes

data class OnBoardingData(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)
