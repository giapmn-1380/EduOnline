package hoangit.dev.g1.com.eduonline.utils

import android.content.Context

class ConfigApp(var context: Context) {

    companion object {

        const val CONFIG_APP = "config_app"
        const val KEY_FIRST_OPEND_APP = "first_opend_app"
        const val KEY_LOCALE_LANGUGE = "locale_languge"

        var instance: ConfigApp? = null

        fun init(context: Context) {
            if (instance == null) {
                instance = ConfigApp(context)
            }
        }

        fun getInstances(): ConfigApp {
            return instance!!
        }
    }

    fun isFirstOpenApp(): Boolean {
        var sharedPreferences = context.getSharedPreferences(CONFIG_APP, Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean(KEY_FIRST_OPEND_APP, true)
    }

    fun setFirstOpenApp(value: Boolean) {
        var sharedPreferences = context.getSharedPreferences(CONFIG_APP, Context.MODE_PRIVATE)
        val edittor = sharedPreferences.edit().putBoolean(KEY_FIRST_OPEND_APP, value)
        edittor.commit()
    }

    fun getLocaleLanguage(): String {
        var sharedPreferences = context.getSharedPreferences(CONFIG_APP, Context.MODE_PRIVATE)
        return sharedPreferences.getString(KEY_LOCALE_LANGUGE, "vi")
    }

    fun setLocaleLanguage(value: String) {
        var sharedPreferences = context.getSharedPreferences(CONFIG_APP, Context.MODE_PRIVATE)
        val edittor = sharedPreferences.edit().putString(KEY_LOCALE_LANGUGE, value)
        edittor.commit()
    }
}