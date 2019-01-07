package hoangit.dev.g1.com.eduonline.app.categories

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import hoangit.dev.g1.com.eduonline.R
import hoangit.dev.g1.com.eduonline.adapter.CategoriesDetailAdapter
import hoangit.dev.g1.com.eduonline.base.BaseActivity
import hoangit.dev.g1.com.eduonline.entites.Category
import hoangit.dev.g1.com.eduonline.extension.showSnackBar
import hoangit.dev.g1.com.eduonline.utils.Const
import hoangit.dev.g1.com.eduonline.view.RecycleViewCustom
import kotlinx.android.synthetic.main.activity_categories.*
import kotlinx.android.synthetic.main.tool_bar_non_logo.*

class CategoriesActivity : BaseActivity(), View.OnClickListener, CategoriesView,
    CategoriesDetailAdapter.OnItemCategoryDetailClickListener {

    lateinit var categoriesPresenter: CategoriesPresenter
    var categoriesDetailAdapter: CategoriesDetailAdapter? = null
    lateinit var rcCategoriesDetail: RecycleViewCustom


    override fun getLayoutID(): Int {
        return R.layout.activity_categories
    }

    override fun onCreateActivity() {
        initObject()
        initViews()
        featchData()
    }

    private fun initViews() {
        rcCategoriesDetail = findViewById(R.id.rc_categories_detail)
        val layoutManager: LinearLayoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        rcCategoriesDetail.layoutManager = layoutManager
        rcCategoriesDetail.adapter = categoriesDetailAdapter

        imv_back.setOnClickListener(this)
        tv_title_tool_bar.text = intent.getBundleExtra(Const.KEY_BUNDLE_CATEGORY).getString(Const.KEY_CATEGORY_NAME)

        shimmer_text.startShimmerAnimation()
        swipe_refresh.setOnRefreshListener(object : SwipeRefreshLayout.OnRefreshListener {
            override fun onRefresh() {
                featchData()
            }
        })
    }

    private fun initObject() {
        categoriesDetailAdapter = CategoriesDetailAdapter(this@CategoriesActivity, this@CategoriesActivity)
        categoriesPresenter = CategoriesPresenter(this@CategoriesActivity, this@CategoriesActivity)
    }

    fun featchData() {
        if (isNetworkState) {
            categoriesPresenter.actionFeatchData()
        } else {
            showSnackBar(getString(R.string.internet_not_avaiable))
            stopRefresh()
        }
    }

    override fun featchDataDetailSuccess(data: Category) {
        categoriesDetailAdapter!!.arrCourse = data.courses
        categoriesDetailAdapter!!.notifyDataSetChanged()
        stopShimerLoadingLayout()
        stopRefresh()
    }

    override fun featchDataDetailFailure(error: String) {
        stopRefresh()
        stopShimerLoadingLayout()
        showSnackBar(error)
    }

    override fun onClickItemCategoryDetail(position: Int) {
        showSnackBar(categoriesDetailAdapter!!.arrCourse.get(position).name)
    }


    override fun onClick(v: View?) {

        when (v!!.id) {
            R.id.imv_back -> {
                finish()
            }
        }
    }

    fun stopShimerLoadingLayout() {
        shimmer_text.stopShimmerAnimation()
        shimmer_text.visibility = View.GONE
    }

    fun stopRefresh() {
        swipe_refresh?.let {
            it.isRefreshing = false
        }
    }
}
