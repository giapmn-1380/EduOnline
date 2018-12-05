package hoangit.dev.g1.com.eduonline.app.laucher

import android.content.Intent
import android.os.Handler
import hoangit.dev.g1.com.eduonline.R
import hoangit.dev.g1.com.eduonline.app.home.HomeActivity
import hoangit.dev.g1.com.eduonline.app.tutorial.TutorialFragment
import hoangit.dev.g1.com.eduonline.base.BaseActivity
import hoangit.dev.g1.com.eduonline.extension.addFragment
import hoangit.dev.g1.com.eduonline.utils.ConfigApp

class LaucherActivity : BaseActivity() {
    override fun getLayoutID(): Int {
        return R.layout.activity_laucher
    }

    override fun onCreateActivity() {
        Handler().postDelayed({
            val isFirstOpenApp = ConfigApp.getInstances().isFirstOpenApp()
            if (isFirstOpenApp) {
                var data = arrayListOf(
                    R.drawable.tutotial,
                    R.drawable.tutotial,
                    R.drawable.tutotial
                )
                addFragment(R.id.tutorial_container, TutorialFragment.newInstance(data), false)
            } else {
                var intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }
        }, 2000)
    }
}