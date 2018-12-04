package hoangit.dev.g1.com.eduonline

import android.app.Application
import hoangit.dev.g1.com.eduonline.utils.ConfigApp

class EduOnlineApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        ConfigApp.init(this)
    }
}