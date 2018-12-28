package hoangit.dev.g1.com.eduonline.app.register

import android.content.Intent
import android.view.View
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import hoangit.dev.g1.com.eduonline.R
import hoangit.dev.g1.com.eduonline.app.main.MainActivity
import hoangit.dev.g1.com.eduonline.base.BaseActivity
import hoangit.dev.g1.com.eduonline.extension.closeKeyboard
import hoangit.dev.g1.com.eduonline.extension.popBack
import hoangit.dev.g1.com.eduonline.extension.showSnackBar
import hoangit.dev.g1.com.eduonline.utils.Const
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity(), View.OnClickListener, RegisterView {

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
        btn_register.setOnClickListener(this)
        btn_fb.setOnClickListener(this)
        btn_gg.setOnClickListener(this)

        tv_login.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn_register -> {
                closeKeyboard(v)
                if (validate()) registerPresenter.let {
                    showProgressLoadding()
                    it!!.actionRegister(
                        edt_register_full_name.text.toString(),
                        edt_register_email.text.toString(),
                        edt_register_password.text.toString().trim()
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
        if (edt_register_full_name.text.toString().trim() == Const.BLANK) {
            edt_register_full_name.error = getString(R.string.error_input_email)
            return false
        }

        if (edt_register_email.text.toString().trim() == Const.BLANK) {
            edt_register_email.error = getString(R.string.error_input_email)
            return false
        }

        if (edt_register_password.text.toString().trim() == Const.BLANK) {
            edt_register_password.setSelection(0)
            edt_register_password.error = getString(R.string.error_input_pass)
            return false
        }
        if (edt_register_re_enter_pass.text.toString().trim() == Const.BLANK) {
            edt_register_re_enter_pass.error = getString(R.string.error_input_email)
            return false
        }

        if (edt_register_password.text.toString().trim() != edt_register_re_enter_pass.text.toString().trim()) {
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