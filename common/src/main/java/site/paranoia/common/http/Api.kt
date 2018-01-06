package site.paranoia.common.http
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Paranoia on 12/24/17.
 */
class Api {
    private var apiService: ApiService

    init {
        val client = OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .addInterceptor(HttpLoggingInterceptor())
                .build()
        val builder = Retrofit.Builder()
                .baseUrl("http://ysjj-demo.c1.centling.cn")
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        apiService= builder.create(ApiService::class.java)
    }

    companion object {
        val apiService : ApiService by lazy { Holder.instance.apiService }
    }

    private object Holder {
        val instance = Api()
    }
}