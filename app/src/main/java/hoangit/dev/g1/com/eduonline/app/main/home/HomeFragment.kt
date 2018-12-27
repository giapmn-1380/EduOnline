package hoangit.dev.g1.com.eduonline.app.main.home

import android.view.View
import hoangit.dev.g1.com.eduonline.R
import hoangit.dev.g1.com.eduonline.base.BaseFragment

class HomeFragment : BaseFragment() {


    companion object {
        var instance: HomeFragment? = null

        fun getInstances(): HomeFragment {
            if (instance == null) {
                instance = HomeFragment()
            }
            return instance!!
        }
    }


    override fun getLayoutID(): Int {
        return R.layout.fragment_home
    }

    override fun onViewReady(view: View) {

    }
}