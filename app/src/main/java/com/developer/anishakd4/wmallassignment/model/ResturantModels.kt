package com.developer.anishakd4.wmallassignment.model


data class MainModel(val restaurants: List<MainResturantModel>)

data class MainResturantModel(val restaurant: ResturantModel)

data class ResturantModel(val name: String, val thumb: String, val featured_image: String)