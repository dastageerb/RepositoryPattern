package com.gzrehrdzwq.repositorypattern.di

import androidx.viewbinding.BuildConfig
import com.gzrehrdzwq.repositorypattern.BuildConfig.BASE_URL
import com.gzrehrdzwq.repositorypattern.data.PhotoService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {



    @Provides
    fun provideRetrofit() = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun getPhotoService(retrofit: Retrofit) = retrofit.create(PhotoService::class.java)


}