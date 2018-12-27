package hoangit.dev.g1.com.eduonline.app.main.settings

import android.view.View
import hoangit.dev.g1.com.eduonline.R
import hoangit.dev.g1.com.eduonline.app.main.home.HomeFragment
import hoangit.dev.g1.com.eduonline.base.BaseFragment

class SettingFragment : BaseFragment() {

    companion object {
        var instance: SettingFragment? = null

        fun getInstances(): SettingFragment {
            if (instance == null) {
                instance = SettingFragment()
            }
            return instance!!
        }
    }

    override fun getLayoutID(): Int {
        return R.layout.fragment_settings
    }

    override fun onViewReady(view: View) {

    }
}