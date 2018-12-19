package hoangit.dev.g1.com.eduonline.api

import hoangit.dev.g1.com.eduonline.model.ResponseBody
import hoangit.dev.g1.com.eduonline.utils.AppConfig
import hoangit.dev.g1.com.eduonline.utils.Const
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Query

open interface APIService {

    @POST(Const.URL_LOGIN)
    fun requestLogin(
        @Query("user[email]") email: String,
        @Query("user[password]") password: String,
        @Query("locale") locale: String = AppConfig.getInstances().getLocaleLanguage()
    ): Call<ResponseBody>

    @FormUrlEncoded
    @POST(Const.URL_SIGN_UP)
    fun requestSignUpAccount(
        @Field("user[name]") fullname: String,
        @Field("user[email]") email: String,
        @Field("user[password]") password: String,
        @Field("user[password_confirmation]") passwordConfirm: String,
        @Field("locale") locale: String = AppConfig.getInstances().getLocaleLanguage()
    ): Call<ResponseBody>


}