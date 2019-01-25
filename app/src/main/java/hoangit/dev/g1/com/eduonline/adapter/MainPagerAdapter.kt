package hoangit.dev.g1.com.eduonline.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import hoangit.dev.g1.com.eduonline.app.main.home.HomeFragment
import hoangit.dev.g1.com.eduonline.app.main.mycourse.MyCourseFragment
import hoangit.dev.g1.com.eduonline.app.main.notification.NotificationFragment
import hoangit.dev.g1.com.eduonline.app.main.settings.SettingFragment

class MainPagerAdapter(supportFragmentManager: FragmentManager) :
    FragmentPagerAdapter(supportFragmentManager) {

    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> return HomeFragment.getInstances()
            1 -> return NotificationFragment.getInstances()
            2 -> return MyCourseFragment.getInstances()
            3 -> return SettingFragment.getInstances()
        }
        return null
    }

    override fun getCount(): Int {
        return 4
    }

}