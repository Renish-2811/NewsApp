package com.example.playaround.domain.usecase

import androidx.compose.runtime.State
import com.example.playaround.Constant.Resource
import com.example.playaround.data.remote.dto.News
import com.example.playaround.domain.repository.MyRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(private val repository:MyRepo) {

    operator fun invoke(path: String, query:String, key:String): Flow<Resource<News>> = flow{
        try {
            emit(Resource.Loading<News>())
            val news = repository.doNetworkCall(path,query,key)
            emit(Resource.Success<News>(news))
        }
        catch (e: HttpException){
            emit(Resource.Error<News>(e.localizedMessage ?: "An Unexpected Error is there"))
        }
        catch (e: IOException){
            emit(Resource.Error<News>("Bad Internet"))
        }

    }
}