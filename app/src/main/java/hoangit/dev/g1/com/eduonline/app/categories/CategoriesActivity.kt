package hoangit.dev.g1.com.eduonline.app.categories

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import hoangit.dev.g1.com.eduonline.R
import hoangit.dev.g1.com.eduonline.adapter.CategoriesDetailAdapter
import hoangit.dev.g1.com.eduonline.base.BaseActivity
import hoangit.dev.g1.com.eduonline.entites.Category
import hoangit.dev.g1.com.eduonline.extension.showSnackBar
import kotlinx.android.synthetic.main.tool_bar.*

class CategoriesActivity : BaseActivity(), View.OnClickListener, CategoriesView {


    lateinit var categoriesPresenter: CategoriesPresenter
    var categoriesDetailAdapter: CategoriesDetailAdapter? = null
    lateinit var rcCategoriesDetail: RecyclerView


    override fun getLayoutID(): Int {
        return R.layout.activity_categories
    }

    override fun onCreateActivity() {
        categoriesDetailAdapter = CategoriesDetailAdapter(this@CategoriesActivity)

        imv_back.setOnClickListener(this)

        rcCategoriesDetail = findViewById(R.id.rc_categories_detail)
        val layoutManager: LinearLayoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        rcCategoriesDetail.layoutManager = layoutManager
        rcCategoriesDetail.adapter = categoriesDetailAdapter

        categoriesPresenter = CategoriesPresenter(this@CategoriesActivity, this@CategoriesActivity)
        categoriesPresenter.actionFeatchData()
    }

    override fun featchDataDetailSuccess(data: Category) {
        categoriesDetailAdapter!!.arrCourse = data.courses
        categoriesDetailAdapter!!.notifyDataSetChanged()
    }

    override fun featchDataDetailFailure(error: String) {
        showSnackBar(error)
    }


    override fun onClick(v: View?) {

        when (v!!.id) {
            R.id.imv_back -> {
                finish()
            }
        }
    }
}
