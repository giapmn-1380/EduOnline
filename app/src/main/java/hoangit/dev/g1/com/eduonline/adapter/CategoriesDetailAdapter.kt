package hoangit.dev.g1.com.eduonline.adapter

import android.content.Context
import android.graphics.Paint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import hoangit.dev.g1.com.eduonline.R
import hoangit.dev.g1.com.eduonline.entites.Course
import hoangit.dev.g1.com.eduonline.utils.Utils

class CategoriesDetailAdapter(val context: Context, val onItemCategoryDetailClickListener: OnItemCategoryDetailClickListener) : RecyclerView.Adapter<CategoriesDetailAdapter.ViewHolder>() {


    var arrCourse: ArrayList<Course> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_categories_detail, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arrCourse.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = arrCourse.get(position)
        holder.tvCategoryItemCourseAuthor.text = item.author
        holder.tvCategoryItemCourseName.text = item.name
        holder.tvCourseCost.text = Utils.convertMoney(item.price) + context.getString(R.string.unit_money)
        holder.tvCourseCostSaleOff.text = Utils.convertMoney(item.percentSale) + context.getString(R.string.unit_money)
        Glide.with(context)
            .setDefaultRequestOptions(
                RequestOptions()
                    .placeholder(R.color.red)
            )
            .load(arrCourse.get(position).thumbnail.url)
            .into(holder.imvCategoriesDetail)
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var imvCategoriesDetail: ImageView
        var tvCategoryItemCourseAuthor: TextView
        var tvCategoryItemCourseName: TextView
        var tvCourseCostSaleOff: TextView
        var tvCourseCost: TextView
        var llClickItem:LinearLayout

        init {
            imvCategoriesDetail = itemView.findViewById(R.id.imv_categories_detail)
            tvCategoryItemCourseAuthor = itemView.findViewById(R.id.tv_category_item_course_author)
            tvCategoryItemCourseName = itemView.findViewById(R.id.tv_category_item_course_name)
            tvCourseCostSaleOff = itemView.findViewById(R.id.tv_course_cost_sale_off)
            tvCourseCost = itemView.findViewById(R.id.tv_course_cost)
            tvCourseCost.setPaintFlags(tvCourseCost.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)
            llClickItem = itemView.findViewById(R.id.ll_on_click_item_category_detail)
            llClickItem.setOnClickListener {
                onItemCategoryDetailClickListener.onClickItemCategoryDetail(adapterPosition)
            }
        }
    }

    interface OnItemCategoryDetailClickListener {
        fun onClickItemCategoryDetail(position: Int)
    }
}