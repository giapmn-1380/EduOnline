package hoangit.dev.g1.com.eduonline.app.register

import com.facebook.FacebookException
import com.facebook.login.LoginResult


interface RegisterView {
    fun onLoginFbSuccess(result: LoginResult)
    fun onLoginFbError(error: FacebookException)
    fun onLoginFbStatus(status: Boolean)

    fun onLoginGoogle()

    fun onRegisterSuccess()
    fun onRegisterFailure(error: String)

    interface OnRegisterListener {
        fun onRegisterSuccess()
        fun onRegisterFailure(error: String)
    }
}