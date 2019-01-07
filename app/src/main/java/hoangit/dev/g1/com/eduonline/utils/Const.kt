package hoangit.dev.g1.com.eduonline.utils

class Const {
    companion object {
        val BLANK = ""
        val URL_BASE = "https://edulearning-traning.herokuapp.com"
//        val URL_BASE = " http://192.168.15.77:3000/api/"

        const val URL_LOGIN = "/api/login.json"
        const val URL_SIGN_UP = "/api/signup.json"
        const val URL_LIST_CATEROGY = "/api/categories.json"
        const val URL_DETAIL_CATEROGY = "/api/categories/{id}.json"

        val RESPONSE_SUCCESS = 200

        const val KEY_BUNDLE_CATEGORY = "key_bundle_category"
        const val KEY_CATEGORY_NAME = "key_category_name"
        const val KEY_CATEGORY_ID = "key_category_id"
        const val ACTION_NETWORK_CHANGE = "android.net.conn.CONNECTIVITY_CHANGE"

    }
}