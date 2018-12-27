package hoangit.dev.g1.com.eduonline.app.laucher

import android.content.Intent
import android.os.Handler
import android.text.TextUtils
import hoangit.dev.g1.com.eduonline.R
import hoangit.dev.g1.com.eduonline.app.main.MainActivity
import hoangit.dev.g1.com.eduonline.app.login.LoginActivity
import hoangit.dev.g1.com.eduonline.app.tutorial.TutorialFragment
import hoangit.dev.g1.com.eduonline.base.BaseActivity
import hoangit.dev.g1.com.eduonline.extension.addFragment
import hoangit.dev.g1.com.eduonline.utils.AppConfig

class LaucherActivity : BaseActivity() {
    override fun getLayoutID(): Int {
        return R.layout.activity_laucher
    }

    override fun onCreateActivity() {
        Handler().postDelayed({
            val isFirstOpenApp = AppConfig.getInstances().isFirstOpenApp()
            if (isFirstOpenApp) {
                var data = arrayListOf(
                    R.drawable.tutotial,
                    R.drawable.tutotial,
                    R.drawable.tutotial
                )
                addFragment(R.id.tutorial_container, TutorialFragment.newInstance(data), false)
            } else {
                val userData = AppConfig.getInstances().getUserData()
                if (TextUtils.isEmpty(userData)) {
                    var intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                } else {
                    var intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                finish()
            }
        }, 2000)
    }
}