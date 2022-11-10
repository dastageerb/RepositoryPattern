package com.gzrehrdzwq.repositorypattern.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.gzrehrdzwq.repositorypattern.R
import com.gzrehrdzwq.repositorypattern.databinding.ActivityMainBinding
import com.gzrehrdzwq.repositorypattern.utils.NetworkResponse
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding:ActivityMainBinding?=null
    private val binding get() = _binding!!

    lateinit var photosRecyclerViewAdapter: PhotosRecyclerViewAdapter

    @Inject
    lateinit var viewModel:MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
        subscribeToPhotosResponse()
        viewModel.getPhotos()
    }

    private fun initRecyclerView() {
        photosRecyclerViewAdapter = PhotosRecyclerViewAdapter()
        binding.activityMainRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.activityMainRecyclerView.adapter = photosRecyclerViewAdapter
    }

    private fun subscribeToPhotosResponse() {
        viewModel.getPhotoResponse.observe(this) {
            when (it) {
                is NetworkResponse.Success -> {
                    binding.activityMainProgressBar.visibility = View.GONE
                    photosRecyclerViewAdapter.submitList(it.data)
                }
                is NetworkResponse.Error -> {
                    binding.activityMainProgressBar.visibility = View.GONE
                }
                is NetworkResponse.Loading -> {
                    binding.activityMainProgressBar.visibility = View.VISIBLE
                }
            }
        }
    }
}