package com.fdj.test

import android.util.Log
import com.fdj.test.teams.model.Team
import com.fdj.test.teams.model.Teams
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataHandler{

    var retrofit: Retrofit
    var mCall: APICall
    var apiUrl = "https://www.thesportsdb.com/api/v1/json/1/"

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        retrofit = Retrofit.Builder()
            .baseUrl(apiUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        mCall = retrofit.create(APICall::class.java)
    }

    fun getTeams(query: CharSequence, callback: (List<Team>?) -> Unit) {

        val call = mCall.getData(query)

        call.enqueue(
            object : Callback<Teams> {
                override fun onResponse(call: Call<Teams>, response: Response<Teams>) {
                    callback(response.body()?.teams)
                }

                override fun onFailure(call: Call<Teams>, t: Throwable) {
                    Log.e("TAG", "error " + t.message)
                    call.cancel()
                }
            })
    }

}