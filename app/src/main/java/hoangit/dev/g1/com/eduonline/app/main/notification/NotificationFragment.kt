package hoangit.dev.g1.com.eduonline.app.main.notification

import android.view.View
import hoangit.dev.g1.com.eduonline.R
import hoangit.dev.g1.com.eduonline.base.BaseFragment

class NotificationFragment : BaseFragment() {

    companion object {
        var instance: NotificationFragment? = null

        fun getInstances(): NotificationFragment {
            if (instance == null) {
                instance = NotificationFragment()
            }
            return instance!!
        }
    }

    override fun getLayoutID(): Int {
        return R.layout.fragment_notification
    }

    override fun onViewReady(view: View) {

    }
}