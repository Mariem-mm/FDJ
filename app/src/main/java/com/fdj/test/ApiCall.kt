package com.fdj.test

import com.fdj.test.teams.model.Teams
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APICall {
    @GET("search_all_teams.php?s=Soccer")
    fun getData(@Query("c") query: CharSequence): Call<Teams>
}