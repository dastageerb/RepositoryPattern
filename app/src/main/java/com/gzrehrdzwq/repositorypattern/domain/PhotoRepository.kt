package com.gzrehrdzwq.repositorypattern.domain

import com.gzrehrdzwq.repositorypattern.data.entities.PhotoResponse
import com.gzrehrdzwq.repositorypattern.utils.NetworkResponse
import retrofit2.Response

interface PhotoRepository {

    suspend fun getAlbums(): NetworkResponse<PhotoResponse>
}