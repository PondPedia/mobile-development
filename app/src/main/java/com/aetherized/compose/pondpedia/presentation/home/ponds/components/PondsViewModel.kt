package com.aetherized.compose.pondpedia.presentation.home.ponds.components

//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.setValue
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.aetherized.compose.pondpedia.core.Resource
//import com.aetherized.compose.pondpedia.domain.repository.PondRepository
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.launch
//import javax.inject.Inject

//@HiltViewModel
//class PondsViewModel @Inject constructor(
//    private val repository: PondRepository
//): ViewModel() {
//    var state by mutableStateOf(PondsState())
//
//    fun onEvent(event: PondsEvent) {
//        when (event) {
//            is PondsEvent.Refresh -> {
//                getPonds(fetchFromRemote = true)
//            }
//        }
//    }
//    fun getPonds(
//        fetchFromRemote:Boolean = false
//    ) {
//        viewModelScope.launch {
//            repository
//                .getPonds(fetchFromRemote)
//                .collect{ result ->
//                    when (result) {
//                        is Resource.Success -> {
//                            result.data?.let { ponds ->
//                                state = state.copy(
//                                    ponds = ponds
//                                )
//                            }
//                        }
//                        is Resource.Error -> Unit
//                        is Resource.Loading -> {
//                            state = state.copy(isLoading = result.isLoading)
//                        }
//                    }
//                }
//        }
//    }
//}