package com.aetherized.compose.pondpedia.presentation.home.ponds.components

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aetherized.compose.pondpedia.core.util.Resource
import com.aetherized.compose.pondpedia.domain.model.pond.Pond
import com.aetherized.compose.pondpedia.domain.model.pond.getDummyPond
import com.aetherized.compose.pondpedia.domain.use_case.GetPondLogById
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PondViewModel @Inject constructor(
    private val getPondLog: GetPondLogById
) : ViewModel() {
    private val _pondId = mutableStateOf("")
    val pondId: State<String> = _pondId
    private val _state = mutableStateOf(PondState())
    val state: State<PondState> = _state

    private val _eventFlow = MutableSharedFlow<UIEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var loadPondLogJob: Job? = null


    var pondData: Pond = getDummyPond()

    fun onLoadPonds(pid: String) {
        _pondId.value = pid
        loadPondLogJob?.cancel()
        loadPondLogJob = viewModelScope.launch(Dispatchers.IO) {
            delay(100L)
            getPondLog("pond")
                .onEach { result ->
                    when(result) {
                        is Resource.Success -> {
                            _state.value = state.value.copy(
                                pondLogItems = result.data ?: emptyList(),
                                isLoading = false
                            )
                        }
                        is Resource.Error -> {
                            _state.value = state.value.copy(
                                pondLogItems = result.data ?: emptyList(),
                                isLoading = false
                            )
                            _eventFlow.emit(UIEvent.ShowSnackBar(
                                result.message ?: "Terjadi Masalah"
                            ))
                        }
                        is Resource.Loading -> {
                            _state.value = state.value.copy(
                                pondLogItems = result.data ?: emptyList(),
                                isLoading = true
                            )
                        }
                    }
                }.launchIn(this)
        }
    }
    sealed class UIEvent {
        data class ShowSnackBar(val message: String): UIEvent()
    }
}