package ro.alexmamo.roomjetpackcompose.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import ro.alexmamo.roomjetpackcompose.domain.model.DBUser
import ro.alexmamo.roomjetpackcompose.domain.model.Response
import ro.alexmamo.roomjetpackcompose.domain.repository.UserRepository
import javax.inject.Inject

typealias InsertUserResponse = Response<Unit>
typealias UpdateUserResponse = Response<Unit>
typealias DeleteUserResponse = Response<Unit>

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val repo: UserRepository
) : ViewModel() {
    val userListState = repo.getUserList().map { userList ->
        try {
            Response.Success(userList)
        } catch (e: Exception) {
            Response.Failure(e)
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = Response.Loading
    )

    private val _insertUserState = MutableStateFlow<InsertUserResponse>(Response.Idle)
    val insertUserState: StateFlow<InsertUserResponse> = _insertUserState.asStateFlow()

    private val _updateUserState = MutableStateFlow<UpdateUserResponse>(Response.Idle)
    val updateUserState: StateFlow<UpdateUserResponse> = _updateUserState.asStateFlow()

    private val _deleteUserState = MutableStateFlow<DeleteUserResponse>(Response.Idle)
    val deleteUserState: StateFlow<DeleteUserResponse> = _deleteUserState.asStateFlow()

    fun insertUser(user: DBUser) = viewModelScope.launch {
        try {
            _insertUserState.value = Response.Loading
            _insertUserState.value = Response.Success(repo.insertUser(user))
        } catch (e: Exception) {
            Response.Failure(e)
        }
    }

    fun resetInsertUserState() {
        _insertUserState.value = Response.Idle
    }

    fun updateUser(user: DBUser) = viewModelScope.launch {
        try {
            _updateUserState.value = Response.Loading
            _updateUserState.value = Response.Success(repo.updateUser(user))
        } catch (e: Exception) {
            Response.Failure(e)
        }
    }

    fun resetUpdateUserState() {
        _updateUserState.value = Response.Idle
    }

    fun deleteUser(user: DBUser) = viewModelScope.launch {
        try {
            _deleteUserState.value = Response.Loading
            _deleteUserState.value = Response.Success(repo.deleteUser(user))
        } catch (e: Exception) {
            Response.Failure(e)
        }
    }

    fun resetDeleteUserState() {
        _deleteUserState.value = Response.Idle
    }
}