package hoangit.dev.g1.com.eduonline.app.login

import android.content.Intent
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import java.util.*

class LoginPresenter(val loginView: LoginView, val loginActivity: LoginActivity) : LoginView.OnLoginListener {

    val callbackManager: CallbackManager
    val loginInteractor: LoginInteractor


    init {
        callbackManager = CallbackManager.Factory.create()
        loginInteractor = LoginInteractor()

    }


    fun actionLogin(email: String, password: String) {
        loginInteractor.requestLogin(email, password, this)
    }


    fun onLoginFacebook() {
        var statusLogin = loginActivity.checkFacebookLogin()
        if (!statusLogin) {
            val permissionNeeds = Arrays.asList("email", "public_profile")
            LoginManager.getInstance().logInWithReadPermissions(loginActivity, permissionNeeds)
            LoginManager.getInstance().registerCallback(callbackManager, facebookCallback)
        } else {
            loginView.onLoginFbStatus(statusLogin)
        }
    }

    fun onLoginGoogle() {

    }


    val facebookCallback = object : FacebookCallback<LoginResult> {

        override fun onSuccess(result: LoginResult) {
            loginView.onLoginFbSuccess(result)
        }

        override fun onCancel() {

        }

        override fun onError(error: FacebookException) {
            loginView.onLoginFbError(error)
        }
    }

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager.onActivityResult(requestCode, resultCode, data)
    }

    override fun onLoginSuccess() {
        loginView.onLoginSuccess()
    }

    override fun onLoginFailure(error: String) {
        loginView.onLoginFailure(error)
    }

}