package hoangit.dev.g1.com.eduonline.app.categories

import hoangit.dev.g1.com.eduonline.api.APIUtils
import hoangit.dev.g1.com.eduonline.entites.ResponseCaterogyDetail
import hoangit.dev.g1.com.eduonline.utils.Const
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoriesInteractor {
    fun featchDataCategoryDetail(categoryID: Long, listener: CategoriesView.OnFeatchDateCategoryDetailListener) {
        APIUtils.getAPIService().featchDateCategoryDetail(categoryID)
            .enqueue(object : Callback<ResponseCaterogyDetail> {

                override fun onResponse(
                    call: Call<ResponseCaterogyDetail>,
                    response: Response<ResponseCaterogyDetail>
                ) {
                    if (response.isSuccessful) {
                        val statusCode = response.body()!!.status
                        if (statusCode == Const.RESPONSE_SUCCESS) {
                            val error = response.body()!!.error
                            if (!error) {
                                listener.onFeatchCategoryDetailSuccess(response.body()!!.data)
                            } else {
                                listener.onFeatchCategoryDetailFailure(response.body()!!.message)
                            }
                        } else {
                            listener.onFeatchCategoryDetailFailure(response.toString())
                        }
                    } else {
                        listener.onFeatchCategoryDetailFailure(response.toString())
                    }

                }

                override fun onFailure(call: Call<ResponseCaterogyDetail>, t: Throwable) {
                    listener.onFeatchCategoryDetailFailure(t.message!!)
                }
            })
    }
}