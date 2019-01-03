package hoangit.dev.g1.com.eduonline.app.categories

import hoangit.dev.g1.com.eduonline.entites.Category
import hoangit.dev.g1.com.eduonline.utils.Const

class CategoriesPresenter(val categoriesActivity: CategoriesActivity, val categoriesView: CategoriesView) :
    CategoriesView.OnFeatchDateCategoryDetailListener {

    var categoriesInteractor: CategoriesInteractor
    var categoryID: Long
    var categoryName: String

    init {
        //get data
        val intent = categoriesActivity.intent
        categoryID = intent.getBundleExtra(Const.KEY_BUNDLE_CATEGORY).getLong(Const.KEY_CATEGORY_ID, -1)
        categoryName = intent.getBundleExtra(Const.KEY_BUNDLE_CATEGORY).getString(Const.KEY_CATEGORY_NAME, Const.BLANK)

        //init Object
        categoriesInteractor = CategoriesInteractor()

    }

    fun actionFeatchData() {
        categoriesInteractor.featchDataCategoryDetail(categoryID, this@CategoriesPresenter)
    }


    override fun onFeatchCategoryDetailSuccess(data: Category) {
        categoriesView.featchDataDetailSuccess(data)
    }

    override fun onFeatchCategoryDetailFailure(error: String) {
        categoriesView.featchDataDetailFailure(error)
    }

}