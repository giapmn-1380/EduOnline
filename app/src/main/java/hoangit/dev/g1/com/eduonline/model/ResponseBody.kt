package hoangit.dev.g1.com.eduonline.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import hoangit.dev.g1.com.eduonline.entites.DataUser

class ResponseBody {

    @SerializedName("status")
    @Expose
    val status: Int = -1

    @SerializedName("error")
    @Expose
    val error: Boolean? = null

    @SerializedName("message")
    @Expose
    val message: String? = null

    @SerializedName("data")
    @Expose
    val data: DataUser? = null


}