package hoangit.dev.g1.com.eduonline.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import hoangit.dev.g1.com.eduonline.app.main.home.HomeFragment
import hoangit.dev.g1.com.eduonline.app.main.mycourse.MyCourseFragment
import hoangit.dev.g1.com.eduonline.app.main.search.SearchFragment
import hoangit.dev.g1.com.eduonline.app.main.settings.SettingFragment

class MainPagerAdapter(supportFragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(supportFragmentManager) {

    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> return HomeFragment.getInstances()
            1 -> return SearchFragment.getInstances()
            2 -> return MyCourseFragment.getInstances()
            3 -> return SettingFragment.getInstances()
        }
        return null
    }

    override fun getCount(): Int {
        return 4
    }

}