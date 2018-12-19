package hoangit.dev.g1.com.eduonline

import android.app.Application
import hoangit.dev.g1.com.eduonline.utils.AppConfig

class EduOnlineApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AppConfig.init(this)
    }
}