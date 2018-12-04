package hoangit.dev.g1.com.eduonline.app.tutorial

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.View
import hoangit.dev.g1.com.eduonline.R
import hoangit.dev.g1.com.eduonline.adapter.TutorialAdapter
import hoangit.dev.g1.com.eduonline.base.BaseFragment

class TutorialFragment() : BaseFragment() {

    companion object {

        const val KEY_RESOURCE_TUTORIAL = "key_resource_tutorial"

        fun newInstance(data: ArrayList<Int>): TutorialFragment {
            var bundle = Bundle()
            bundle.putIntegerArrayList(KEY_RESOURCE_TUTORIAL, data)

            var instance = TutorialFragment()
            instance.arguments = bundle
            return instance

        }
    }

    lateinit var viewPager: ViewPager


    override fun getLayoutID(): Int {
        return R.layout.fragment_tutorial

    }

    override fun onViewReady(view: View) {
        var data = arguments!!.getIntegerArrayList(KEY_RESOURCE_TUTORIAL)
        viewPager = view.findViewById(R.id.view_pager_tutorial)
        var tutorialAdapter = TutorialAdapter(fragmentManager!!, data)
        viewPager.adapter = tutorialAdapter
    }
}