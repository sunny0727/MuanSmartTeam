package kr.co.itid.muansmartteam.retrofit

import android.net.Uri
import com.google.gson.GsonBuilder
import kr.co.itid.muansmartteam.R
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.HttpCookie.parse
import java.net.URL
import java.util.concurrent.TimeUnit
import java.util.logging.Level.parse


class Repository {

    companion object {
        private var retrofit: Retrofit? = null
//        val BASEURL = R.string.app_api.toString()
        val BASEURL = "https://www.muan.go.kr/smartapp/"

        fun getDeiviceCheck(): Retrofit {
            val gson = GsonBuilder()
                .setLenient()
                .create()

            // 우회 방식 사용
//            val okHttpClient = OkHttpClient.Builder()
//                .readTimeout(1000, TimeUnit.SECONDS)
//                .connectTimeout(1000, TimeUnit.SECONDS)
//                .build()


            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .client(getUnsafeOkHttpClient().build())
                        // SSL 인증서 우회
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .baseUrl(BASEURL)
                    .build()
            }

            return retrofit!!
        }

    }
}