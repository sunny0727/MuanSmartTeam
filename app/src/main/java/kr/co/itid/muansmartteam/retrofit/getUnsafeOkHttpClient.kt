package kr.co.itid.muansmartteam.retrofit

import okhttp3.OkHttpClient
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

fun getUnsafeOkHttpClient(): OkHttpClient.Builder {
    val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
        override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?) {

        }

        override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?) {

        }

        override fun getAcceptedIssuers(): Array<X509Certificate> {
            return arrayOf()
        }
    })

    val sslContext = SSLContext.getInstance("SSL")
    sslContext.init(null, trustAllCerts, SecureRandom())

    val sslSocketFactory = sslContext.socketFactory

    val builder = OkHttpClient.Builder()
    builder.sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
    builder.hostnameVerifier { hostname, session -> true }

    return builder
}