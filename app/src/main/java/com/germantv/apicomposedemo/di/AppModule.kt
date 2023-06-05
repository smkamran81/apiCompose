package com.germantv.apicomposedemo.di

import com.germantv.apicomposedemo.network.QuestionAPI
import com.germantv.apicomposedemo.repository.QuestionRepository
import com.germantv.apicomposedemo.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesQuestionRepository(api:QuestionAPI) = QuestionRepository(api)

    //Entire application has the access now
    @Singleton
    @Provides
    fun provideQuestionAPI():QuestionAPI {

        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
              .addConverterFactory(GsonConverterFactory.create())
              .build().create(QuestionAPI::class.java)

    }
}