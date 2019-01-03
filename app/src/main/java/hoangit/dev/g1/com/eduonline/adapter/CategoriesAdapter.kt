package hoangit.dev.g1.com.eduonline.adapter

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import hoangit.dev.g1.com.eduonline.R
import hoangit.dev.g1.com.eduonline.app.main.home.HomeFragment
import hoangit.dev.g1.com.eduonline.entites.Category

class CategoriesAdapter(val homeFragment: HomeFragment) : RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    var arrData: ArrayList<Category>? = arrayListOf()
    var listner: OnButtonReadMoreCategoryListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_categories, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arrData!!.size
    }

    override fun onBindViewHolder(hoder: ViewHolder, position: Int) {
        hoder.tvTitleCategory.text = arrData!!.get(position).name
        hoder.courseAdapter = CourseAdapter(homeFragment.context!!, arrData!!.get(position).courses, homeFragment)
        hoder.rcCategory.adapter = hoder.courseAdapter
    }


    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {


        var rcCategory: RecyclerView
        var tvTitleCategory: TextView
        var btnReadMore: Button
        var courseAdapter: CourseAdapter?=null

        init {
            btnReadMore = itemView.findViewById(R.id.btn_read_more_categories)
            btnReadMore.setOnClickListener(this)
            tvTitleCategory = itemView.findViewById(R.id.tv_item_home_tile)

            rcCategory = view.findViewById(R.id.rc_item_course)
            val layoutManager: LinearLayoutManager = LinearLayoutManager(homeFragment.context!!)
            layoutManager.orientation = LinearLayoutManager.HORIZONTAL
            rcCategory.layoutManager = layoutManager


        }

        override fun onClick(v: View?) {
            when (v!!.id) {
                R.id.btn_read_more_categories -> {
                    listner.let {
                        it!!.onClickReadMoreCategory(adapterPosition)
                    }
                }
            }
        }
    }

    interface OnButtonReadMoreCategoryListener {
        fun onClickReadMoreCategory(position: Int)
    }

    fun setOnButtonReadMoreCategoryListener(listener: OnButtonReadMoreCategoryListener) {
        this.listner = listener
    }

}