package com.example.pokertrainer

import retrofit2.Call;
import retrofit2.http.GET
import retrofit2.http.Query

interface GameController {
    @GET("/add")
    fun add(@Query("name") name : String, @Query("score") score : Int) : Call<Boolean>

    @GET("/list")
    fun playerList() : Call<List<User>>
}