package com.example.sprint.pages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sprint.ClientViewModel
import com.example.sprint.repository.Client
import kotlinx.coroutines.launch
import androidx.navigation.NavController


@Composable
fun ClientsPage(
    navController: NavController,
    clientViewModel: ClientViewModel,
    onClientDetail: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val clients = clientViewModel.clients.collectAsState() // Observa a lista de clientes

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text("Lista de Clientes", fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp))

        Button(
            onClick = { navController.navigate("add_client") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Adicionar Novo Cliente")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Lista de clientes
        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(clients.value) { client ->
                ClientItem(
                    client = client,
                    onDelete = { clientViewModel.deleteClient(client.id) },
                    onUpdate = { updatedClient -> clientViewModel.updateClient(updatedClient) },
                    onDetail = { onClientDetail(client.id) }
                )
            }
        }
    }
}

@Composable
fun ClientItem(
    client: Client,
    onDelete: (String) -> Unit,
    onUpdate: (Client) -> Unit,
    onDetail: () -> Unit
) {
    var isEditing by remember { mutableStateOf(false) }
    var editedName by remember { mutableStateOf(client.name) }
    var editedStatus by remember { mutableStateOf(client.riskScore) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        if (isEditing) {
            TextField(
                value = editedName,
                onValueChange = { editedName = it },
                label = { Text("Nome") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = editedStatus,
                onValueChange = { editedStatus = it },
                label = { Text("Pontuação de Risco") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(onClick = {
                    onUpdate(client.copy(name = editedName, riskScore = editedStatus))
                    isEditing = false
                }) {
                    Text("Salvar")
                }
                Button(onClick = { isEditing = false }) {
                    Text("Cancelar")
                }
            }
        } else {
            Text("Nome: ${client.name}", fontSize = 20.sp)
            Text("Pontuação de Risco: ${client.riskScore}", fontSize = 16.sp)

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(onClick = onDetail) {
                    Text("Ver Detalhes")
                }
                Button(onClick = { isEditing = true }) {
                    Text("Editar")
                }
                Button(onClick = { onDelete(client.id) }) {
                    Text("Excluir")
                }
            }
        }
    }
}