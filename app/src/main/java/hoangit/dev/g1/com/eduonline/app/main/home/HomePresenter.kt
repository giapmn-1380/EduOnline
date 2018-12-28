package hoangit.dev.g1.com.eduonline.app.main.home

import hoangit.dev.g1.com.eduonline.entites.Category

class HomePresenter(val homeFragment: HomeFragment, val homeView: HomeView) : HomeView.OnFeatchDateCategoryListener {


    var homeInteractor: HomeInteractor? = null

    init {
        homeInteractor = HomeInteractor()
    }

    fun actionFeatchData() {
        homeInteractor!!.featchDateCategory(this)
    }

    override fun onFeatchCategorySuccess(data: ArrayList<Category>) {
        homeView.featchDataSuccess(data)
    }

    override fun onFeatchCategoryFailure(error: String) {
        homeView.featchDataFailure(error)
    }

}