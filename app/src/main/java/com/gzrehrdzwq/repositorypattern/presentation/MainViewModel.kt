package com.gzrehrdzwq.repositorypattern.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gzrehrdzwq.repositorypattern.domain.PhotoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val photoRepository: PhotoRepository):ViewModel() {

    val _getPhotoResponse:MutableLiveData<PhotoRepository> = MutableLiveData()

    val getPhotoResponse:LiveData<PhotoRepository>  = _getPhotoResponse

    fun getPhotos() = viewModelScope.launch(Dispatchers.Main) {

    }


}