package com.example.b2b.screens.explorerFragment.phones

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.example.domain.usecases.FetchUseCase
import com.example.data.repository.ToDispatch
import com.example.b2b.model.DataApp
import com.example.domain.models.Result
import com.example.b2b.model.MapDomainToApp
import com.example.domain.models.ErrorType
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PhonesFragmentViewModel @Inject constructor(
    fetchItemsUseCase: FetchUseCase,
    private val mapper: MapDomainToApp,
    private val dispatchers: ToDispatch,
) : ViewModel() {

    private var mAllItems = MutableLiveData<List<DataApp>>()
    private var mError = MutableLiveData<ErrorType>()
    val allItems: LiveData<List<DataApp>>
        get() = mAllItems
    val error: LiveData<ErrorType>
        get() = mError

    init {
        when (val result = fetchItemsUseCase.execute()) {
            is Result.Success -> {
                mAllItems = result.itemsDomain.map { list ->
                    list.map { mapper.mapDomainToAppData(it) }
                } as MutableLiveData<List<DataApp>>
            }
            is Result.Fail -> mError.value = result.errorType
        }
    }
}









