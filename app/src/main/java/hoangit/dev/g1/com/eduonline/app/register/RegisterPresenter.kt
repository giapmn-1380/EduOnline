package hoangit.dev.g1.com.eduonline.app.register

import com.google.gson.Gson
import hoangit.dev.g1.com.eduonline.entites.DataUser
import hoangit.dev.g1.com.eduonline.utils.AppConfig

class RegisterPresenter(val registerView: RegisterView, val registerActivity: RegisterActivity) :
    RegisterView.OnRegisterListener {

    private val registerInteractor: RegisterInteractor

    init {
        registerInteractor = RegisterInteractor()
    }

    fun actionRegister(fullname: String, email: String, password: String) {
        registerInteractor.requestSignUpAccount(fullname, email, password, this)
    }

    override fun onRegisterSuccess(userData: DataUser) {
        registerView.onRegisterSuccess()
        AppConfig.getInstances().setUserData(Gson().toJson(userData))
    }

    override fun onRegisterFailure(error: String) {
        registerView.onRegisterFailure(error)
    }

}