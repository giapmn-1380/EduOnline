package hoangit.dev.g1.com.eduonline.app.login

import android.content.Intent
import android.util.Log
import android.view.View
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import hoangit.dev.g1.com.eduonline.R
import hoangit.dev.g1.com.eduonline.app.main.MainActivity
import hoangit.dev.g1.com.eduonline.app.register.RegisterActivity
import hoangit.dev.g1.com.eduonline.base.BaseActivity
import hoangit.dev.g1.com.eduonline.extension.closeKeyboard
import hoangit.dev.g1.com.eduonline.extension.showSnackBar
import hoangit.dev.g1.com.eduonline.extension.startActivityWithTransition
import hoangit.dev.g1.com.eduonline.utils.Const
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : BaseActivity(), View.OnClickListener, LoginView {

    private var loginPresenter: LoginPresenter? = null

    companion object {
        val TAG = LoginActivity::class.java.simpleName
    }

    override
    fun getLayoutID(): Int {
        return R.layout.activity_login
    }

    override fun onCreateActivity() {
        initObject()
        initViews()
    }

    private fun initViews() {
        btn_login.setOnClickListener(this)
        btn_fb.setOnClickListener(this)
        btn_gg.setOnClickListener(this)

        tv_register.setOnClickListener(this)
        tv_register.setOnClickListener(this)
    }

    private fun initObject() {
        loginPresenter = LoginPresenter(this, this)

    }

    fun goToHome() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn_login -> {
                if (validate()) {
                    loginPresenter.let {
                        showProgressLoadding()
                        closeKeyboard(v)
                        it!!.actionLogin(edt_login_email.text.toString(), edt_login_password.text.toString())
                    }
                }
            }
            R.id.btn_fb -> {
                loginPresenter.let {
                    it!!.onLoginFacebook()
                }
            }
            R.id.btn_gg -> {

            }
            R.id.tv_register -> {
                var intent = Intent(this, RegisterActivity::class.java)
                startActivityWithTransition(intent)
            }
            R.id.tv_login_after -> {
                goToHome()
                finish()
            }
        }
    }

    override fun onLoginFbSuccess(result: LoginResult) {
        Log.d(TAG, "" + result.accessToken.token)
    }

    override fun onLoginFbError(error: FacebookException) {
        Log.d(TAG, "" + error.message)
    }

    override fun onLoginFbStatus(status: Boolean) {
        if (status) {
            Log.d(TAG, "Facebook Logined")
        } else {
            Log.d(TAG, "Facebook not Login")
        }
    }

    override fun onLoginGoogle() {

    }


    override fun onLoginSuccess() {
        Log.d(TAG, "onLoginSuccess")
        dismisProgressLoading()
        goToHome()
        finish()
    }

    override fun onLoginFailure(error: String) {
        Log.d(TAG, "onLoginFailure $error")

        dismisProgressLoading()
        showSnackBar("$error")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        loginPresenter.let {
            it!!.onActivityResult(requestCode, resultCode, data)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    fun validate(): Boolean {
        if (edt_login_email.text.toString().trim().equals(Const.BLANK)) {
            edt_login_email.error = getString(R.string.error_input_email)
            return false
        }

        if (edt_login_password.text.toString().trim().equals(Const.BLANK)) {
            edt_login_password.setSelection(0)
            edt_login_password.error = getString(R.string.error_input_pass)
            return false
        }
        return true
    }
}