package com.example.domain.models

import androidx.lifecycle.LiveData

sealed class Result {
    data class Success(val itemsDomain: LiveData<List<DataDomain>>) : Result()
    data class Fail(val errorType: ErrorType) : Result()
}
