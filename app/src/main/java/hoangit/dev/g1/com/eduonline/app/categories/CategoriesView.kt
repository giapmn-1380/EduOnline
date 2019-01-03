package hoangit.dev.g1.com.eduonline.app.categories

import hoangit.dev.g1.com.eduonline.entites.Category

interface CategoriesView {

    fun featchDataDetailSuccess(data: Category)

    fun featchDataDetailFailure(error: String)

    interface OnFeatchDateCategoryDetailListener {

        fun onFeatchCategoryDetailSuccess(data: Category)

        fun onFeatchCategoryDetailFailure(error: String)
    }
}