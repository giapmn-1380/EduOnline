package hoangit.dev.g1.com.eduonline.app.main.home

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import hoangit.dev.g1.com.eduonline.R
import hoangit.dev.g1.com.eduonline.adapter.CategoriesAdapter
import hoangit.dev.g1.com.eduonline.base.BaseFragment
import hoangit.dev.g1.com.eduonline.entites.Category

class HomeFragment : BaseFragment(), HomeView, CategoriesAdapter.OnButtonReadMoreCategoryListener {


    var homePresenter: HomePresenter? = null
    lateinit var categoriesAdapter: CategoriesAdapter
    lateinit var rcHome:RecyclerView

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
        categoriesAdapter = CategoriesAdapter(this@HomeFragment.context!!)
        categoriesAdapter.setOnButtonReadMoreCategoryListener(this)
    }


    override fun getLayoutID(): Int {
        return R.layout.fragment_home
    }

    override fun onViewReady(view: View) {
        rcHome = view.findViewById(R.id.rc_home)
        val layoutManager:LinearLayoutManager = LinearLayoutManager(this@HomeFragment.context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        rcHome.layoutManager = layoutManager
        rcHome.adapter = categoriesAdapter
    }

    override fun featchDataSuccess(data: ArrayList<Category>) {
        categoriesAdapter.arrData = data
        categoriesAdapter.notifyDataSetChanged()
    }

    override fun featchDataFailure(error: String) {
        Log.d("GiapMN", error)
    }

    override fun onClickReadMoreCategory(position: Int) {
        showSnackBar(categoriesAdapter.arrData!!.get(position).name)
    }

}