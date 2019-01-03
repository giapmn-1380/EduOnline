package hoangit.dev.g1.com.eduonline.api

import hoangit.dev.g1.com.eduonline.entites.ResponseCaterogy
import hoangit.dev.g1.com.eduonline.entites.ResponseCaterogyDetail
import hoangit.dev.g1.com.eduonline.model.ResponseBody
import hoangit.dev.g1.com.eduonline.utils.AppConfig
import hoangit.dev.g1.com.eduonline.utils.Const
import retrofit2.Call
import retrofit2.http.*

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

    @GET(Const.URL_LIST_CATEROGY)
    fun featchDateCategory(
        @Query("locale") locale: String = AppConfig.getInstances().getLocaleLanguage()
    ): Call<ResponseCaterogy>

    @GET(Const.URL_DETAIL_CATEROGY)
    fun featchDateCategoryDetail(
        @Path("id") idCategory: Long,
        @Query("locale") locale: String = AppConfig.getInstances().getLocaleLanguage()
    ): Call<ResponseCaterogyDetail>

}