package com.mi.mvi.domain.usecase.blogs

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.mi.mvi.cache.entity.AuthTokenEntity
import com.mi.mvi.domain.repository.CreateBlogRepository
import com.mi.mvi.presentation.main.create_blog.state.CreateBlogViewState
import com.mi.mvi.utils.DataState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOn
import okhttp3.MultipartBody
import okhttp3.RequestBody

@ExperimentalCoroutinesApi
class CreateBlogUseCase(private val repository: CreateBlogRepository) {
    fun invoke(
        tokenEntity: AuthTokenEntity,
        title: RequestBody,
        body: RequestBody,
        image: MultipartBody.Part
    ): LiveData<DataState<CreateBlogViewState>> {
        return repository.createNewBlogPost(
            tokenEntity,
            title,
            body,
            image
        ).flowOn(Dispatchers.IO)
            .asLiveData()
    }
}
