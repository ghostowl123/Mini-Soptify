package com.laioffer.spotify.repository

import com.laioffer.spotify.datamodel.Section
import com.laioffer.spotify.network.NetworkApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlinx.coroutines.delay

class HomeRepository @Inject constructor(private val networkApi: NetworkApi) {
    //withContext
    //suspend 只能被放在coroutine里面进行使用
    suspend fun getHomeSections(): List<Section> = withContext(Dispatchers.IO) {
        delay(3000);
        networkApi.getHomeFeed().execute().body() ?: listOf()
    }
}

