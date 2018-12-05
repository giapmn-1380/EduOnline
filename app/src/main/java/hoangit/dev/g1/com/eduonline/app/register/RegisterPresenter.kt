package hoangit.dev.g1.com.eduonline.app.register

class RegisterPresenter(val registerView: RegisterView, val registerActivity: RegisterActivity) :
    RegisterView.OnRegisterListener {

    private val registerInteractor: RegisterInteractor

    init {
        registerInteractor = RegisterInteractor()
    }

    fun actionRegister(fullname: String, email: String, password: String) {
        registerInteractor.requestSignUpAccount(fullname, email, password, this)
    }

    override fun onRegisterSuccess() {
        registerView.onRegisterSuccess()
    }

    override fun onRegisterFailure(error: String) {
        registerView.onRegisterFailure(error)
    }

}