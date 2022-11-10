package com.gzrehrdzwq.repositorypattern.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gzrehrdzwq.repositorypattern.data.entities.PhotoResponse
import com.gzrehrdzwq.repositorypattern.domain.PhotoRepository
import com.gzrehrdzwq.repositorypattern.utils.NetworkResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val photoRepository: PhotoRepository):ViewModel() {

    private val _getPhotoResponse:MutableLiveData<NetworkResponse<PhotoResponse>> = MutableLiveData()

    val getPhotoResponse:LiveData<NetworkResponse<PhotoResponse>>  = _getPhotoResponse

    fun getPhotos() = viewModelScope.launch(Dispatchers.Main) {

        _getPhotoResponse.value = NetworkResponse.Loading()

        val list = photoRepository.getAlbums()
        if (list.isEmpty()) {
            _getPhotoResponse.value = NetworkResponse.Success(list)
        }else {
            _getPhotoResponse.value = NetworkResponse.Error("No Photos")
        }
    }

}