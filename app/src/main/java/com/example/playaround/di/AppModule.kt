package com.example.playaround.di

import android.app.Application
import androidx.compose.runtime.remember
import com.example.playaround.Constant.Constant
import com.example.playaround.data.remote.MyApiCall
import com.example.playaround.data.repository.MyRepoImpl
import com.example.playaround.domain.repository.MyRepo
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
    @Provides
    @Singleton
    fun providesApi(): MyApiCall {
        println ("Response:")
        val response = Retrofit.Builder().baseUrl(Constant.base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(MyApiCall::class.java)
        println ("Response is:  $response")
        return response
    }

    @Provides
    @Singleton
    fun providesRepo(api: MyApiCall):MyRepo{
        return MyRepoImpl(api)
    }


}