package hoangit.dev.g1.com.eduonline.app.login

import com.facebook.FacebookException
import com.facebook.login.LoginResult
import hoangit.dev.g1.com.eduonline.entites.DataUser

interface LoginView {

    fun onLoginFbSuccess(result: LoginResult)
    fun onLoginFbError(error: FacebookException)
    fun onLoginFbStatus(status: Boolean)

    fun onLoginGoogle()

    fun onLoginSuccess()
    fun onLoginFailure(error: String)

    interface OnLoginListener {
        fun onLoginSuccess(userData: DataUser)
        fun onLoginFailure(error: String)
    }
}