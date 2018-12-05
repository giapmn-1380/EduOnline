package hoangit.dev.g1.com.eduonline.app.login

import hoangit.dev.g1.com.eduonline.api.APIUtils
import hoangit.dev.g1.com.eduonline.model.ResponseBody
import hoangit.dev.g1.com.eduonline.utils.Const
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginInteractor {


    fun requestLogin(email: String, password: String, listener: LoginView.OnLoginListener) {
        val request = APIUtils.getAPIService().requestLogin(email, password)
        request.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    val status = response.body()!!.status
                    if (status == Const.RESPONSE_SUCCESS) {
                        listener.onLoginSuccess()
                    } else {
                        listener.onLoginFailure(response.toString())
                    }
                } else {
                    listener.onLoginFailure(response.toString())
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                listener.onLoginFailure(t.message.toString())
            }
        })
    }

}