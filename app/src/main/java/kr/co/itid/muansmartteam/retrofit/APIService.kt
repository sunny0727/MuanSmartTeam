package kr.co.itid.muansmartteam.retrofit

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface APIService {

    @GET("/device_check")
    fun getDeiviceCheck(@Query("device_id") device_id : String): Call<String>

//    @POST("/경로")
//    fun postDataCheck(@Body postData: PostData) : Call<PostData>
}