package hoangit.dev.g1.com.eduonline.app.main.home

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import hoangit.dev.g1.com.eduonline.R
import hoangit.dev.g1.com.eduonline.adapter.CategoriesAdapter
import hoangit.dev.g1.com.eduonline.adapter.CourseAdapter
import hoangit.dev.g1.com.eduonline.app.categories.CategoriesActivity
import hoangit.dev.g1.com.eduonline.base.BaseFragment
import hoangit.dev.g1.com.eduonline.entites.Category
import hoangit.dev.g1.com.eduonline.utils.Const
import io.supercharge.shimmerlayout.ShimmerLayout

class HomeFragment : BaseFragment(), HomeView,
    CategoriesAdapter.OnButtonReadMoreCategoryListener,
    CourseAdapter.OnItemCourseClickListener {

    var homePresenter: HomePresenter? = null
    lateinit var categoriesAdapter: CategoriesAdapter
    lateinit var rcHome: RecyclerView
    lateinit var viewPlaceHolder: LinearLayout
    lateinit var rootView: View

    val arrShimer = arrayOf(
        R.id.shimmer_text_1, R.id.shimmer_text_2, R.id.shimmer_text_3, R.id.shimmer_text_4, R.id.shimmer_text_5,
        R.id.shimmer_text_6, R.id.shimmer_text_7, R.id.shimmer_text_8, R.id.shimmer_text_9, R.id.shimmer_text_10,
        R.id.shimmer_text_11, R.id.shimmer_text_12
    )

    companion object {
        var instance: HomeFragment? = null

        fun getInstances(): HomeFragment {
            if (instance == null) {
                instance = HomeFragment()
            }
            return instance!!
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initObject()
        featchData()
    }

    private fun featchData() {
        homePresenter.let {
            it!!.actionFeatchData()
        }
    }

    private fun initObject() {
        homePresenter = HomePresenter(this, this)
        categoriesAdapter = CategoriesAdapter(this@HomeFragment)
        categoriesAdapter.setOnButtonReadMoreCategoryListener(this)
    }


    override fun getLayoutID(): Int {
        return R.layout.fragment_home
    }

    override fun onViewReady(view: View) {
        rootView = view
        viewPlaceHolder = view.findViewById(R.id.view_place_holder)
        if (categoriesAdapter.arrData!!.size == 0) {
            viewPlaceHolder.visibility = View.VISIBLE
        } else {
            viewPlaceHolder.visibility = View.GONE
        }
        handleLoadingHolder(view, true)

        rcHome = view.findViewById(R.id.rc_home)
        val layoutManager: LinearLayoutManager = LinearLayoutManager(this@HomeFragment.context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        rcHome.layoutManager = layoutManager
        rcHome.adapter = categoriesAdapter

    }

    fun handleLoadingHolder(view: View, isPlay: Boolean) {
        for (i in 0..arrShimer.size - 1) {
            if (isPlay) {
                view.findViewById<View>(arrShimer.get(i)).findViewById<ShimmerLayout>(R.id.shimmer_text)
                    .startShimmerAnimation()
            } else {
                view.findViewById<View>(arrShimer.get(i)).findViewById<ShimmerLayout>(R.id.shimmer_text)
                    .stopShimmerAnimation()
            }
        }
    }

    override fun featchDataSuccess(data: ArrayList<Category>) {
        //Close view place holder item
        viewPlaceHolder.visibility = View.GONE
        handleLoadingHolder(rootView, false)

        categoriesAdapter.arrData = data
        categoriesAdapter.notifyDataSetChanged()
    }

    override fun featchDataFailure(error: String) {
        showSnackBar(error)
    }

    override fun onClickReadMoreCategory(position: Int) {
        val categoryID = categoriesAdapter.arrData!!.get(position).id
        val categoryName = categoriesAdapter.arrData!!.get(position).name
        val intent = Intent(this@HomeFragment.context, CategoriesActivity::class.java)

        val bundle: Bundle = Bundle()
        bundle.putLong(Const.KEY_CATEGORY_ID, categoryID)
        bundle.putString(Const.KEY_CATEGORY_NAME, categoryName)
        intent.putExtra(Const.KEY_BUNDLE_CATEGORY, bundle)
        startActivity(intent)
    }

    override fun onClickItemCourse(courseAdapter: CourseAdapter, position: Int) {
        showSnackBar(courseAdapter.arrDataCourse!!.get(position).name)
    }

}