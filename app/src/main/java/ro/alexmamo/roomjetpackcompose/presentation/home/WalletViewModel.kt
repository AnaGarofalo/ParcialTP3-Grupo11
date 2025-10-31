package ro.alexmamo.roomjetpackcompose.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ro.alexmamo.roomjetpackcompose.infraestructure.wallet.Wallet
import ro.alexmamo.roomjetpackcompose.infraestructure.wallet.WalletImpl
import ro.alexmamo.roomjetpackcompose.infraestructure.wallet.WalletInterface

class WalletViewModel(private val walletInterface:  WalletInterface = WalletImpl()) : ViewModel() {

    sealed class UiState {
        object Idle : UiState()
        object Loading : UiState()
        data class Success(val wallet: Wallet) : UiState()
        data class Error(val message: String) : UiState()
    }

    private val _uiState = MutableStateFlow<UiState>(UiState.Idle)
    val uiState = _uiState.asStateFlow()

    fun get() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            val wallet = walletInterface.get()
            if (wallet != null) {
                _uiState.value = UiState.Success(wallet)
            } else {
                _uiState.value = UiState.Error("Error al traer transacciones")
            }
        }
    }
}