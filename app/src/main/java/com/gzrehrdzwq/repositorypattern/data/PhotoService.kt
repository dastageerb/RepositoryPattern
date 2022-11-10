package com.gzrehrdzwq.repositorypattern.data

import com.gzrehrdzwq.repositorypattern.data.entities.PhotoResponse
import retrofit2.Response
import retrofit2.http.GET

interface PhotoService {

    @GET("photos")
    suspend fun getAlbums(): Response<PhotoResponse>
}