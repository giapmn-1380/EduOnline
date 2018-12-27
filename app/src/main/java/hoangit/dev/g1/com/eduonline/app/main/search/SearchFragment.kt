package hoangit.dev.g1.com.eduonline.app.main.search

import android.view.View
import hoangit.dev.g1.com.eduonline.R
import hoangit.dev.g1.com.eduonline.base.BaseFragment

class SearchFragment : BaseFragment() {

    companion object {
        var instance: SearchFragment? = null

        fun getInstances(): SearchFragment {
            if (instance == null) {
                instance = SearchFragment()
            }
            return instance!!
        }
    }

    override fun getLayoutID(): Int {
        return R.layout.fragment_search
    }

    override fun onViewReady(view: View) {

    }
}