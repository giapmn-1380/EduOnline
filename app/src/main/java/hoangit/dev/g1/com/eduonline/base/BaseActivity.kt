package hoangit.dev.g1.com.eduonline.base

import android.app.ProgressDialog
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.facebook.AccessToken
import hoangit.dev.g1.com.eduonline.R
import hoangit.dev.g1.com.eduonline.listener.OnNetworkConnectedListener
import hoangit.dev.g1.com.eduonline.utils.Const

abstract class BaseActivity : AppCompatActivity() {

    private var mProgressDialog: ProgressDialog? = null
    var isNetworkState: Boolean = false

    abstract fun getLayoutID(): Int
    abstract fun onCreateActivity()

    private var onNetworkConnectedListener: OnNetworkConnectedListener? = null

    fun setOnNetworkConnectedListener(onNetworkConnectedListener: OnNetworkConnectedListener) {
        this.onNetworkConnectedListener = onNetworkConnectedListener
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutID())
        onCreateActivity()
        registerBroadcastReciver()

    }

    override fun onPause() {
        super.onPause()
        mProgressDialog = null
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
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

    private fun registerBroadcastReciver() {
        val filter = IntentFilter()
        filter.addAction(Const.ACTION_NETWORK_CHANGE)
        registerReceiver(receiver, filter)
    }

    private val receiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val action = intent.action
            if (action != null) {
                when (action) {
                    Const.ACTION_NETWORK_CHANGE -> {
                        val connectivityManager =
                            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                        val activeNetInfor = connectivityManager.getActiveNetworkInfo()
                        isNetworkState = activeNetInfor != null && activeNetInfor.isConnected
                        if (isNetworkState) {
                            onNetworkConnectedListener?.let {
                                it.onNetworkConnected()
                            }
                        } else {
                            onNetworkConnectedListener?.let {
                                it.onNetworkDisconnect()
                            }
                        }
                    }
                }
            }
        }
    }
}