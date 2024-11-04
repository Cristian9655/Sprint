package com.example.sprint.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sprint.ClientViewModel
import com.example.sprint.repository.Client
import kotlinx.coroutines.launch

@Composable
fun AddClientPage(
    navController: NavController,
    clientViewModel: ClientViewModel,
    modifier: Modifier = Modifier
) {
    val coroutineScope = rememberCoroutineScope()

    var clientName by remember { mutableStateOf("") }
    var clientCPF by remember { mutableStateOf("") }
    var clientPhone by remember { mutableStateOf("") }

    // Estado para o campo de Pontuação de Risco
    var riskScore by remember { mutableStateOf("Conservador") }
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text("Adicionar Cliente", fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp))

        TextField(
            value = clientName,
            onValueChange = { clientName = it },
            label = { Text("Nome do Cliente") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = clientCPF,
            onValueChange = { clientCPF = it },
            label = { Text("CPF") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = clientPhone,
            onValueChange = { clientPhone = it },
            label = { Text("Celular") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Campo de seleção para Pontuação de Risco com DropdownMenu
        Text("Pontuação de Risco", fontSize = 16.sp, modifier = Modifier.padding(bottom = 8.dp))
        Box(modifier = Modifier
            .fillMaxWidth()
            .clickable { expanded = true }
            .background(MaterialTheme.colorScheme.surface)
            .padding(16.dp)) {

            Text(riskScore, color = MaterialTheme.colorScheme.onSurface)

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    text = { Text("Conservador") },
                    onClick = {
                        riskScore = "Conservador"
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text("Moderado") },
                    onClick = {
                        riskScore = "Moderado"
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text("Arrojado") },
                    onClick = {
                        riskScore = "Arrojado"
                        expanded = false
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                coroutineScope.launch {
                    clientViewModel.addClient(
                        Client(
                            name = clientName,
                            cpf = clientCPF,
                            phone = clientPhone,
                            riskScore = riskScore
                        )
                    )
                    // Limpa os campos após a adição
                    clientName = ""
                    clientCPF = ""
                    clientPhone = ""
                    riskScore = "Conservador"

                    // Retorna para a tela de lista de clientes
                    navController.navigate("clients")
                }
            },
            enabled = clientName.isNotBlank() && clientCPF.isNotBlank() && clientPhone.isNotBlank() && riskScore.isNotBlank(),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Adicionar Cliente")
        }
    }
}
