package hoangit.dev.g1.com.eduonline.api

class APIUtils {
    companion object {

        fun getAPIService(headers: HashMap<String, String> = hashMapOf()): APIService {
            return RetrofitClient.getRetrofitClient(headers).create(APIService::class.java)
        }
    }
}