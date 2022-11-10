package com.gzrehrdzwq.repositorypattern.data.entities


import com.google.gson.annotations.SerializedName

data class PhotoResponseItem(


    @SerializedName("id")
    val id: String,
    @SerializedName("urls")
    val urls: Urls,

)