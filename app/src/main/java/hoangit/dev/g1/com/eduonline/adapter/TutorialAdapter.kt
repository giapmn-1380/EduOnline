package hoangit.dev.g1.com.eduonline.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import hoangit.dev.g1.com.eduonline.app.tutorial.TutorialPageFragment

class TutorialAdapter(fragmentManager: FragmentManager, var resource: ArrayList<Int>) :
    FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        if (position == (count - 1)) {

            return TutorialPageFragment.newInstance(resource.get(position), true)
        }
        return TutorialPageFragment.newInstance(resource.get(position), false)
    }

    override fun getCount(): Int {
        return resource.size
    }
}