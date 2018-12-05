package hoangit.dev.g1.com.eduonline.base

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.facebook.AccessToken
import hoangit.dev.g1.com.eduonline.R

abstract class BaseActivity : AppCompatActivity() {

    private var mProgressDialog: ProgressDialog? = null


    abstract fun getLayoutID(): Int
    abstract fun onCreateActivity()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutID())
        onCreateActivity()
    }

    fun startTransition() {
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left)
    }

    fun closeTransition() {
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right)
    }

    fun checkFacebookLogin(): Boolean {
        val accessToken = AccessToken.getCurrentAccessToken()
        val isLoggedIn = accessToken != null && !accessToken.isExpired
        return isLoggedIn
    }


    override fun onPause() {
        super.onPause()
        mProgressDialog = null
    }


    fun showProgressLoadding() {
        if (mProgressDialog != null && mProgressDialog!!.isShowing) {
            mProgressDialog!!.dismiss()
            mProgressDialog = null
        }
        mProgressDialog = ProgressDialog(this)
        mProgressDialog!!.setIndeterminate(true)
        mProgressDialog!!.setMessage(resources.getString(R.string.loadding))
        mProgressDialog!!.setProgressStyle(ProgressDialog.STYLE_SPINNER)
        mProgressDialog!!.show()
    }

    fun updateMessageProgressDialog(message: String) {
        if (mProgressDialog != null && mProgressDialog!!.isShowing()) {
            mProgressDialog!!.setMessage(message)
        }
    }

    fun dismisProgressLoading() {
        if (mProgressDialog != null && mProgressDialog!!.isShowing()) {
            mProgressDialog!!.dismiss()
        }
    }

}