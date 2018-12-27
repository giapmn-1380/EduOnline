package hoangit.dev.g1.com.eduonline.app.register

import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import hoangit.dev.g1.com.eduonline.R
import hoangit.dev.g1.com.eduonline.app.main.MainActivity
import hoangit.dev.g1.com.eduonline.base.BaseActivity
import hoangit.dev.g1.com.eduonline.extension.closeKeyboard
import hoangit.dev.g1.com.eduonline.extension.popBack
import hoangit.dev.g1.com.eduonline.extension.showSnackBar
import hoangit.dev.g1.com.eduonline.utils.Const

class RegisterActivity : BaseActivity(), View.OnClickListener, RegisterView {

    private lateinit var tvLogin: TextView
    private lateinit var edtFullName: EditText
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var edtReEnterPass: EditText
    private lateinit var btnFacebook: Button
    private lateinit var btnGoogle: Button
    private lateinit var btnRegister: Button

    private var registerPresenter: RegisterPresenter? = null

    override fun getLayoutID(): Int {
        return R.layout.activity_register
    }

    override fun onCreateActivity() {
        initObject()
        initViews()
    }

    private fun initObject() {
        registerPresenter = RegisterPresenter(this, this)
    }

    private fun initViews() {
        btnRegister = findViewById(R.id.btn_register)
        btnFacebook = findViewById(R.id.btn_fb)
        btnGoogle = findViewById(R.id.btn_gg)
        btnRegister.setOnClickListener(this)
        btnFacebook.setOnClickListener(this)
        btnGoogle.setOnClickListener(this)

        edtFullName = findViewById(R.id.edt_register_full_name)
        edtEmail = findViewById(R.id.edt_register_email)
        edtPassword = findViewById(R.id.edt_register_password)
        edtReEnterPass = findViewById(R.id.edt_register_re_enter_pass)

        tvLogin = findViewById(R.id.tv_login)
        tvLogin.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn_register -> {
                closeKeyboard(v)
                if (validate()) registerPresenter.let {
                    showProgressLoadding()
                    it!!.actionRegister(
                        edtFullName.text.toString(),
                        edtEmail.text.toString(),
                        edtPassword.text.toString().trim()
                    )
                }
            }
            R.id.btn_fb -> {

            }
            R.id.btn_gg -> {

            }
            R.id.tv_login -> {
                popBack()
                closeTransition()
            }
        }

    }

    private fun validate(): Boolean {
        if (edtFullName.text.toString().trim() == Const.BLANK) {
            edtFullName.error = getString(R.string.error_input_email)
            return false
        }

        if (edtEmail.text.toString().trim() == Const.BLANK) {
            edtEmail.error = getString(R.string.error_input_email)
            return false
        }

        if (edtPassword.text.toString().trim() == Const.BLANK) {
            edtPassword.setSelection(0)
            edtPassword.error = getString(R.string.error_input_pass)
            return false
        }
        if (edtReEnterPass.text.toString().trim() == Const.BLANK) {
            edtReEnterPass.error = getString(R.string.error_input_email)
            return false
        }

        if (edtPassword.text.toString().trim() != edtReEnterPass.text.toString().trim()) {
            showSnackBar(getString(R.string.password_invalid))
            return false
        }
        return true
    }

    fun goToHome() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onLoginFbSuccess(result: LoginResult) {
    }

    override fun onLoginFbError(error: FacebookException) {
    }

    override fun onLoginFbStatus(status: Boolean) {
    }

    override fun onLoginGoogle() {
    }

    override fun onRegisterSuccess() {
        dismisProgressLoading()
        goToHome()
        finish()
    }

    override fun onRegisterFailure(error: String) {
        dismisProgressLoading()
        showSnackBar(error)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        closeTransition()
    }
}