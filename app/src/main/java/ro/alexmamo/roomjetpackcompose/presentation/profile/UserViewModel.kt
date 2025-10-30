package ro.alexmamo.roomjetpackcompose.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

import ro.alexmamo.roomjetpackcompose.infraestructure.user.User
import ro.alexmamo.roomjetpackcompose.infraestructure.user.Users
import ro.alexmamo.roomjetpackcompose.infraestructure.user.UsersImpl

class UserViewModel(
    private val users: Users = UsersImpl()
) : ViewModel() {

    sealed class UiState {
        object Idle : UiState()
        object Loading : UiState()
        data class Success(val user: User) : UiState()
        data class Error(val message: String) : UiState()
    }

    private val _uiState = MutableStateFlow<UserViewModel.UiState>(UserViewModel.UiState.Idle)
    val uiState = _uiState.asStateFlow()

    fun fetchUser(id: Int) {
        viewModelScope.launch {
            _uiState.value = UserViewModel.UiState.Loading
            val user = users.getById(id)
            if (user != null) {
                _uiState.value = UserViewModel.UiState.Success(user)
            } else {
                _uiState.value = UserViewModel.UiState.Error("Error al traer usuario")
            }
        }
    }
}

private fun Any.launch(function: () -> Unit) {}
