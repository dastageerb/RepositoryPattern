package com.gzrehrdzwq.repositorypattern.data

import com.gzrehrdzwq.repositorypattern.BuildConfig.API_KEY
import com.gzrehrdzwq.repositorypattern.data.entities.PhotoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotoService {

    @GET("photos")
    suspend fun getAlbums(@Query("client_id")clientId:String = API_KEY): Response<PhotoResponse>

}