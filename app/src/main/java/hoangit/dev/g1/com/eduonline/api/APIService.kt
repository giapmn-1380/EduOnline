package hoangit.dev.g1.com.eduonline.api

import hoangit.dev.g1.com.eduonline.model.ResponseBody
import hoangit.dev.g1.com.eduonline.utils.ConfigApp
import hoangit.dev.g1.com.eduonline.utils.Const
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

open interface APIService {

    @FormUrlEncoded
    @POST(Const.URL_LOGIN)
    fun requestLogin(
        @Field("user[email]") email: String,
        @Field("user[password]") password: String,
        @Field("locale") locale: String = ConfigApp.getInstances().getLocaleLanguage()
    ): Call<ResponseBody>

    @FormUrlEncoded
    @POST(Const.URL_SIGN_UP)
    fun requestSignUpAccount(
        @Field("user[name]") fullname: String,
        @Field("user[email]") email: String,
        @Field("user[password]") password: String,
        @Field("user[password_confirmation]") passwordConfirm: String,
        @Field("locale") locale: String = ConfigApp.getInstances().getLocaleLanguage()
    ): Call<ResponseBody>


}