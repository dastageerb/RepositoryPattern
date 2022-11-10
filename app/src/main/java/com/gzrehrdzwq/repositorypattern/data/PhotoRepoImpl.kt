package com.gzrehrdzwq.repositorypattern.data

import android.util.Log
import com.gzrehrdzwq.repositorypattern.data.entities.PhotoResponse
import com.gzrehrdzwq.repositorypattern.domain.PhotoRepository
import javax.inject.Inject

class PhotoRepoImpl @Inject constructor(val photoService: PhotoService):PhotoRepository {

    override suspend fun getAlbums(): PhotoResponse {
        try {
            val response = photoService.getAlbums()
            if (response.isSuccessful){
                return response.body()!!
            }
        }catch (e:Exception){
            Log.d("1234", "getAlbums: "+e.message)
        }
        return PhotoResponse()
    }
}