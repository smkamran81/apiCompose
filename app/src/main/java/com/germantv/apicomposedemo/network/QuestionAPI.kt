package com.germantv.apicomposedemo.network

import com.germantv.apicomposedemo.model.QuestionItem
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface QuestionAPI {

    @GET("world.json")
    suspend fun getAllQuestions():ArrayList<QuestionItem>

    @GET("tip/2023053011")
    suspend fun myTest():String
}