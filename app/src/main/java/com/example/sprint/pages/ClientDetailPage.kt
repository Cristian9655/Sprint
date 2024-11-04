package com.example.sprint.pages

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sprint.ClientViewModel

@Composable
fun ClientDetailPage(clientId: String, clientViewModel: ClientViewModel = viewModel()) {
    // Observa a lista de clientes e encontra o cliente com o ID especificado
    val clients = clientViewModel.clients.collectAsState()
    val client = clients.value.find { it.id == clientId }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        if (client != null) {
            Text("Detalhes do Cliente", fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp))
            Text("Nome: ${client.name}", fontSize = 20.sp, modifier = Modifier.padding(bottom = 8.dp))
            Text("CPF: ${client.cpf}", fontSize = 20.sp, modifier = Modifier.padding(bottom = 8.dp))
            Text("Celular: ${client.phone}", fontSize = 20.sp, modifier = Modifier.padding(bottom = 8.dp))
            Text("Pontuação de Risco: ${client.riskScore}", fontSize = 20.sp, modifier = Modifier.padding(bottom = 8.dp))
            Text("Imagem URL: ${client.imageUrl}", fontSize = 20.sp)
        } else {
            Text("Carregando cliente...", fontSize = 20.sp)
        }
    }
}
