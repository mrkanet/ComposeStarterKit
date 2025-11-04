package com.mrkanet.thebartender.ui.home

import androidx.lifecycle.viewModelScope
import com.mrkanet.thebartender.bases.BaseViewModel
import com.mrkanet.thebartender.dependencies.FirebaseRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: FirebaseRepository
) : BaseViewModel() {
    private val _isUserLoggedIn = MutableStateFlow(false)
    val isUserLoggedIn = _isUserLoggedIn.asStateFlow()

    init {
        _isUserLoggedIn.value = repository.isUserSignedIn()
    }

    fun logUserIn() {
        viewModelScope.launch {
            repository.signInAnonymously()
            _isUserLoggedIn.value = repository.isUserSignedIn()
        }
    }
}
