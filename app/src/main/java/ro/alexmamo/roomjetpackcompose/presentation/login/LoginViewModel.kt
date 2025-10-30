package ro.alexmamo.roomjetpackcompose.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ro.alexmamo.roomjetpackcompose.infraestructure.auth.Auth
import ro.alexmamo.roomjetpackcompose.infraestructure.auth.AuthImpl
import ro.alexmamo.roomjetpackcompose.infraestructure.auth.LoginRequest
import ro.alexmamo.roomjetpackcompose.infraestructure.auth.Token

class LoginViewModel(private val auth: Auth = AuthImpl()) : ViewModel() {

    sealed class UiState {
        object Idle : UiState()
        object Loading : UiState()
        data class Success(val token: Token) : UiState()
        data class Error(val message: String) : UiState()
    }

    private val _uiState = MutableStateFlow<UiState>(UiState.Idle)
    val uiState = _uiState.asStateFlow()

    fun login(username: String, password: String) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            val token = auth.login(LoginRequest(username, password))
            if (token != null) {
                _uiState.value = UiState.Success(token)
            } else {
                _uiState.value = UiState.Error("Error al iniciar sesión")
            }
        }
    }
}