package hoangit.dev.g1.com.eduonline.api

import com.google.gson.Gson
import hoangit.dev.g1.com.eduonline.utils.Const
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {


    companion object {
        fun getRetrofitClient(headers: HashMap<String, String>): Retrofit {

            val okHttpClient = OkHttpClient.Builder().addInterceptor(object : Interceptor {
                override fun intercept(chain: Interceptor.Chain): Response {
                    val builder = chain.request().newBuilder()
                    if (headers != null && headers.size > 0) {
                        val myVeryOwnIterator = headers.keys.iterator()
                        while (myVeryOwnIterator.hasNext()) {
                            val key = myVeryOwnIterator.next()
                            val value = headers.get(key)
                            builder.addHeader(key, value)
                        }
                    }
                    val request = builder.build()
                    return chain.proceed(request)
                }
            }).build()

            val retrofitClient = Retrofit.Builder()
                .baseUrl(Const.URL_BASE)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofitClient
        }
    }
}