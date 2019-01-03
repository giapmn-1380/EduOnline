package hoangit.dev.g1.com.eduonline.adapter

import android.content.Context
import android.graphics.Paint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import hoangit.dev.g1.com.eduonline.R
import hoangit.dev.g1.com.eduonline.entites.Course
import hoangit.dev.g1.com.eduonline.utils.Utils



class CourseAdapter(
    private val context: Context,
    val arrDataCourse: ArrayList<Course>,
    val onItemClick: OnItemCourseClickListener
) :
    RecyclerView.Adapter<CourseAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_course, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arrDataCourse.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = arrDataCourse.get(position)
        holder.tvCourseTitle.text = item.name
        holder.tvCourseAuthor.text = item.author
        holder.tvCourseCost.text = Utils.convertMoney(item.price) + context.getString(R.string.unit_money)
        holder.tvCourseCostSaleOff.text = Utils.convertMoney(item.percentSale) + context.getString(R.string.unit_money)
        holder.ratingItemCourse.rating = item.rateAverage.toFloat()
        Glide.with(context)
            .setDefaultRequestOptions(
                RequestOptions()
                    .placeholder(R.color.red)
            )
            .load(arrDataCourse.get(position).thumbnail.url)
            .into(holder.imvCourse)
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var imvCourse: ImageView
        var tvCourseTitle: TextView
        var tvCourseAuthor: TextView
        var tvCourseCostSaleOff: TextView
        var tvCourseCost: TextView
        var ratingItemCourse: RatingBar


        init {
            imvCourse = itemView.findViewById(R.id.imv_course)
            tvCourseTitle = itemView.findViewById(R.id.tv_course_title)
            tvCourseAuthor = itemView.findViewById(R.id.tv_course_author)
            tvCourseCost = itemView.findViewById(R.id.tv_course_cost)
            tvCourseCost.setPaintFlags(tvCourseCost.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)
            tvCourseCostSaleOff = itemView.findViewById(R.id.tv_course_cost_sale_off)
            ratingItemCourse = itemView.findViewById(R.id.rating_item_course)
            itemView.findViewById<LinearLayout>(R.id.item_course_click).setOnClickListener {
                onItemClick.onClickItemCourse(this@CourseAdapter, adapterPosition)
            }
        }
    }

    interface OnItemCourseClickListener {
        fun onClickItemCourse(courseAdapter:CourseAdapter, position: Int)
    }
}