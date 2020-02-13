package com.developer.anishakd4.wmallassignment.model

data class MainCategoryModel(val categories: List<CategoryModels>)

data class CategoryModels(val categories: CategoryModel)

data class CategoryModel(val id: Int, val name: String)