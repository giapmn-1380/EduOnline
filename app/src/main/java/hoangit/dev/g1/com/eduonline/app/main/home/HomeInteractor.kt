package hoangit.dev.g1.com.eduonline.app.main.home

import hoangit.dev.g1.com.eduonline.api.APIService
import hoangit.dev.g1.com.eduonline.api.APIUtils
import hoangit.dev.g1.com.eduonline.entites.ResponseCaterogy
import hoangit.dev.g1.com.eduonline.utils.Const
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeInteractor {

    fun featchDateCategory(onFeatchDateCategoryListener: HomeView.OnFeatchDateCategoryListener) {
        APIUtils.getAPIService().featchDateCategory().enqueue(object : Callback<ResponseCaterogy> {
            override fun onResponse(call: Call<ResponseCaterogy>, response: Response<ResponseCaterogy>) {
                if (response.isSuccessful) {
                    val statusCode = response.body()!!.status
                    if (statusCode == Const.RESPONSE_SUCCESS) {
                        val error = response.body()!!.error
                        if (!error) {
                            onFeatchDateCategoryListener.onFeatchCategorySuccess(response.body()!!.data)
                        } else {
                            onFeatchDateCategoryListener.onFeatchCategoryFailure(response.body()!!.message)
                        }
                    } else {
                        onFeatchDateCategoryListener.onFeatchCategoryFailure(response.toString())
                    }
                } else {
                    onFeatchDateCategoryListener.onFeatchCategoryFailure(response.toString())
                }
            }

            override fun onFailure(call: Call<ResponseCaterogy>, t: Throwable) {
                onFeatchDateCategoryListener.onFeatchCategoryFailure(t.message.toString())
            }
        })
    }
}