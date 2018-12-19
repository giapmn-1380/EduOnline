package hoangit.dev.g1.com.eduonline.app.register

import hoangit.dev.g1.com.eduonline.api.APIUtils
import hoangit.dev.g1.com.eduonline.model.ResponseBody
import hoangit.dev.g1.com.eduonline.utils.Const
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterInteractor {

    fun requestSignUpAccount(
        fullname: String,
        email: String,
        password: String,
        onSignUpListener: RegisterView.OnRegisterListener
    ) {

        val requestSignUp = APIUtils.getAPIService().requestSignUpAccount(fullname, email, password, password)
        requestSignUp.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    val status = response.body()!!.status
                    status.let {
                        if (it == Const.RESPONSE_SUCCESS) {
                            val error = response.body()!!.error
                            if (error!!) {
                                onSignUpListener.onRegisterFailure(response.body()!!.message!!)
                            } else {
                                onSignUpListener.onRegisterSuccess(response.body()!!.data!!)
                            }
                        } else {
                            onSignUpListener.onRegisterFailure(response.toString())
                        }
                    }
                } else {
                    onSignUpListener.onRegisterFailure(response.toString())
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                onSignUpListener.onRegisterFailure(t.message.toString())
            }
        })
    }

}