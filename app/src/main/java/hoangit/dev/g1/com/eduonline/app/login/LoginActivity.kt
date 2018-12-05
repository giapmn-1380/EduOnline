package hoangit.dev.g1.com.eduonline.app.login

import android.content.Intent
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.design.widget.Snackbar
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import hoangit.dev.g1.com.eduonline.R
import hoangit.dev.g1.com.eduonline.app.home.HomeActivity
import hoangit.dev.g1.com.eduonline.app.register.RegisterActivity
import hoangit.dev.g1.com.eduonline.base.BaseActivity
import hoangit.dev.g1.com.eduonline.extension.closeKeyboard
import hoangit.dev.g1.com.eduonline.extension.showSnackBar
import hoangit.dev.g1.com.eduonline.extension.startActivityWithTransition
import hoangit.dev.g1.com.eduonline.utils.Const


class LoginActivity : BaseActivity(), View.OnClickListener, LoginView {

    lateinit var btnFacebook: Button
    lateinit var btnGoogle: Button
    lateinit var btnLogin: Button

    lateinit var tvRegister: TextView
    lateinit var tvLoginAfer: TextView

    lateinit var edtEmail: EditText
    lateinit var edtPassword: EditText

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
        btnLogin = findViewById(R.id.btn_login)
        btnLogin.setOnClickListener(this)
        btnFacebook = findViewById(R.id.btn_fb)
        btnFacebook.setOnClickListener(this)
        btnGoogle = findViewById(R.id.btn_gg)
        btnGoogle.setOnClickListener(this)

        tvRegister = findViewById(R.id.tv_register)
        tvRegister.setOnClickListener(this)
        tvLoginAfer = findViewById(R.id.tv_login_after)
        tvLoginAfer.setOnClickListener(this)

        edtEmail = findViewById(R.id.edt_login_email)
        edtPassword = findViewById(R.id.edt_login_password)
    }

    private fun initObject() {
        loginPresenter = LoginPresenter(this, this)

    }

    fun goToHome() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }


    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn_login -> {
                if (validate()) {
                    loginPresenter.let {
                        showProgressLoadding()
                        closeKeyboard(v)
                        it!!.actionLogin(edtEmail.text.toString(), edtPassword.text.toString())
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
        if (edtEmail.text.toString().trim().equals(Const.BLANK)) {
            edtEmail.error = getString(R.string.error_input_email)
            return false
        }

        if (edtPassword.text.toString().trim().equals(Const.BLANK)) {
            edtPassword.setSelection(0)
            edtPassword.error = getString(R.string.error_input_pass)
            return false
        }
        return true
    }
}