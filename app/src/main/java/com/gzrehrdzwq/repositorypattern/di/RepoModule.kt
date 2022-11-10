package com.gzrehrdzwq.repositorypattern.di

import com.gzrehrdzwq.repositorypattern.data.PhotoRepoImpl
import com.gzrehrdzwq.repositorypattern.data.PhotoService
import com.gzrehrdzwq.repositorypattern.domain.PhotoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepoModule {

    @Provides
    fun getPhotoRepo(photoService: PhotoService):PhotoRepository = PhotoRepoImpl(photoService)

}