package hoangit.dev.g1.com.eduonline.app.laucher

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import hoangit.dev.g1.com.eduonline.R
import hoangit.dev.g1.com.eduonline.app.home.HomeActivity
import hoangit.dev.g1.com.eduonline.app.tutorial.TutorialFragment
import hoangit.dev.g1.com.eduonline.extension.addFragment
import hoangit.dev.g1.com.eduonline.utils.ConfigApp

class LaucherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_laucher)
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