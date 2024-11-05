package com.example.sprint.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sprint.ClientViewModel
import com.example.sprint.repository.Client
import androidx.navigation.NavController
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.clickable
import androidx.compose.material3.*

@Composable
fun ClientsPage(
    navController: NavController,
    clientViewModel: ClientViewModel,
    onClientDetail: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val clients = clientViewModel.clients.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Lista de clientes",
            fontSize = 28.sp,
            color = Color(0xFF19326A),
            fontWeight = FontWeight.Bold,
            lineHeight =  35.sp,
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = { navController.navigate("add_client") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Adicionar Novo Cliente")

        }

        Spacer(modifier = Modifier.height(12.dp))

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
    var riskScoreExpanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(10.dp))
            .border(1.dp, Color(0xFFE0E0E0), shape = RoundedCornerShape(10.dp))
            .padding(16.dp)
    ) {
        Column {
            if (isEditing) {
                TextField(
                    value = editedName,
                    onValueChange = { editedName = it },
                    label = { Text("Nome") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                Text("Pontuação de Risco", fontSize = 14.sp, color = Color.Gray, modifier = Modifier.padding(bottom = 4.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { riskScoreExpanded = true }
                        .background(Color(0xFFF0F0F0), shape = RoundedCornerShape(5.dp))
                        .padding(vertical = 12.dp, horizontal = 16.dp)
                ) {
                    Text(editedStatus)
                    DropdownMenu(
                        expanded = riskScoreExpanded,
                        onDismissRequest = { riskScoreExpanded = false }
                    ) {
                        DropdownMenuItem(
                            text = { Text("Conservador") },
                            onClick = {
                                editedStatus = "Conservador"
                                riskScoreExpanded = false
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Moderado") },
                            onClick = {
                                editedStatus = "Moderado"
                                riskScoreExpanded = false
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Arrojado") },
                            onClick = {
                                editedStatus = "Arrojado"
                                riskScoreExpanded = false
                            }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Button(
                        onClick = {
                            onUpdate(client.copy(name = editedName, riskScore = editedStatus))
                            isEditing = false
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
                    ) {
                        Text("Salvar", color = Color.White)
                    }
                    Button(
                        onClick = { isEditing = false },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF44336))
                    ) {
                        Text("Cancelar", color = Color.White)
                    }
                }
            } else {
                Text("Nome: ${client.name}", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF424242))
                Spacer(modifier = Modifier.height(4.dp))
                Text("Pontuação de Risco: ${client.riskScore}", fontSize = 14.sp, color = Color.Gray)

                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.align(Alignment.End)
                ) {
                    OutlinedButton(
                        onClick = onDetail,
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Detalhes")
                    }
                    OutlinedButton(
                        onClick = { isEditing = true },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Editar")
                    }
                    OutlinedButton(
                        onClick = { onDelete(client.id) },
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFFF44336))
                    ) {
                        Text("Excluir")
                    }
                }
            }
        }
    }
}
