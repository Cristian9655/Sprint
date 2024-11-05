package com.example.sprint.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.tasks.await

data class Client(
    val id: String = "",
    val name: String = "",
    val cpf: String = "",
    val phone: String = "",
    val riskScore: String = "",
)

class ClientRepository {

    private val firestore = FirebaseFirestore.getInstance()
    private val clientsCollection = firestore.collection("clients")

    //Obter todos os clientes
    suspend fun getClients(): List<Client> {
        return try {
            clientsCollection.get().await().documents.mapNotNull { it.toObject<Client>()?.copy(id = it.id) }
        } catch (e: Exception) {
            emptyList()
        }
    }

    //Adicionar novo cliente
    suspend fun addClient(client: Client) {
        clientsCollection.add(client).await()
    }

    //Atualizar dados do cliente
    suspend fun updateClient(client: Client) {
        client.id.takeIf { it.isNotEmpty() }?.let {
            clientsCollection.document(it).set(client).await()
        }
    }

    //Remover cliente
    suspend fun deleteClient(clientId: String) {
        clientsCollection.document(clientId).delete().await()
    }
}
