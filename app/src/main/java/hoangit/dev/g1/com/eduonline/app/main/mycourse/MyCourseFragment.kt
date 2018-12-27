package hoangit.dev.g1.com.eduonline.app.main.mycourse

import android.view.View
import hoangit.dev.g1.com.eduonline.R
import hoangit.dev.g1.com.eduonline.base.BaseFragment

class MyCourseFragment : BaseFragment() {


    companion object {
        var instance: MyCourseFragment? = null

        fun getInstances(): MyCourseFragment {
            if (instance == null) {
                instance = MyCourseFragment()
            }
            return instance!!
        }
    }

    override fun getLayoutID(): Int {
        return R.layout.fragment_my_course
    }

    override fun onViewReady(view: View) {

    }
}