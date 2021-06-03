package kr.co.itid.muansmartteam

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kr.co.itid.muansmartteam.retrofit.APIService
import kr.co.itid.muansmartteam.retrofit.LoginData
import kr.co.itid.muansmartteam.retrofit.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LaunchActivity : AppCompatActivity() {

    lateinit var apiService : APIService
    private var loginCheck: List<LoginData> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)



        Handler().postDelayed({
            startActivity(Intent(this, WebActivity::class.java))
            finish()
        }, 2000)

    }

    fun deviceCheck(){
        apiService = Repository.getDeiviceCheck().create(APIService::class.java)
        apiService.getDeiviceCheck(SingleTone.getAndroidID(applicationContext)).enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
//                TODO("Not yet implemented")
                Log.e("call", response.toString())
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
//                TODO("Not yet implemented")
                Log.e("onFailure", t.message.toString())
            }


        })
    }



}