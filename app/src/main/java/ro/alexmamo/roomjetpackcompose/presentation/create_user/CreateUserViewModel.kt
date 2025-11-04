package ro.alexmamo.roomjetpackcompose.presentation.create_user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ro.alexmamo.roomjetpackcompose.infraestructure.auth.Auth
import ro.alexmamo.roomjetpackcompose.infraestructure.auth.CreateUserRequest
import ro.alexmamo.roomjetpackcompose.infraestructure.user.User
import javax.inject.Inject

@HiltViewModel
class CreateUserViewModel @Inject constructor(private val auth: Auth) : ViewModel() {

    sealed class UiState {
        object Idle : UiState()
        object Loading : UiState()
        data class Success(val user: User) : UiState()
        data class Error(val message: String) : UiState()
    }

    private val _uiState = MutableStateFlow<UiState>(UiState.Idle)
    val uiState = _uiState.asStateFlow()

    fun createUser(email: String, password: String, username: String) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            val user = auth.createUser(CreateUserRequest(email, password, username))
            if (user != null) {
                _uiState.value = UiState.Success(user)
            } else {
                _uiState.value = UiState.Error("Error al crear usuario")
            }
        }
    }
}