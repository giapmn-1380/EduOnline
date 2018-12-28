package hoangit.dev.g1.com.eduonline.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import hoangit.dev.g1.com.eduonline.R
import hoangit.dev.g1.com.eduonline.entites.Course

class CourseAdapter(private val context:Context, val arrDataCourse:ArrayList<Course>): RecyclerView.Adapter<CourseAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_course, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arrDataCourse.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvCourseTitle.text = arrDataCourse.get(position).name
        Glide.with(context).setDefaultRequestOptions(RequestOptions().placeholder(R.color.red)).load(arrDataCourse.get(position).thumbnail.url).into(holder.imvCourse)
    }


    class ViewHolder(view:View) : RecyclerView.ViewHolder(view) {

        var imvCourse:ImageView
        var tvCourseTitle:TextView
        init {
            imvCourse = itemView.findViewById(R.id.imv_course)
            tvCourseTitle = itemView.findViewById(R.id.tv_course_title)

        }
    }
}