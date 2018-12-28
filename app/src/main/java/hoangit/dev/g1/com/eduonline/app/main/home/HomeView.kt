package hoangit.dev.g1.com.eduonline.app.main.home

import hoangit.dev.g1.com.eduonline.entites.Category

interface HomeView {

    fun featchDataSuccess(data: ArrayList<Category>)

    fun featchDataFailure(error: String)

    interface OnFeatchDateCategoryListener {

        fun onFeatchCategorySuccess(data: ArrayList<Category>)

        fun onFeatchCategoryFailure(error: String)
    }
}