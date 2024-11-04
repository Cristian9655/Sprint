package com.example.sprint

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sprint.repository.Client
import com.example.sprint.repository.ClientRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ClientViewModel : ViewModel() {

    private val repository = ClientRepository() // Instancia o repositório de clientes

    // Estado observável para a lista de clientes
    private val _clients = MutableStateFlow<List<Client>>(emptyList())
    val clients: StateFlow<List<Client>> = _clients

    // Estado observável para o carregamento
    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    init {
        fetchClients() // Carrega os clientes ao iniciar o ViewModel
    }

    // Função para obter a lista de clientes
    fun fetchClients() {
        viewModelScope.launch {
            _loading.value = true
            _clients.value = repository.getClients()
            _loading.value = false
        }
    }

    // Função para adicionar um novo cliente
    fun addClient(client: Client) {
        viewModelScope.launch {
            repository.addClient(client)
            fetchClients() // Atualiza a lista após adicionar
        }
    }

    // Função para atualizar os dados de um cliente existente
    fun updateClient(client: Client) {
        viewModelScope.launch {
            repository.updateClient(client)
            fetchClients() // Atualiza a lista após a atualização
        }
    }

    // Função para excluir um cliente
    fun deleteClient(clientId: String) {
        viewModelScope.launch {
            repository.deleteClient(clientId)
            fetchClients() // Atualiza a lista após a exclusão
        }
    }
}
