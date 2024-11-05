package com.example.sprint.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sprint.ClientViewModel
import com.example.sprint.repository.Client
import kotlinx.coroutines.launch

import androidx.compose.foundation.border

@OptIn(ExperimentalMaterial3Api::class)
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
    var riskScore by remember { mutableStateOf("Conservador") }
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFE5F4FB))
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Adicionar Cliente",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        TextField(
            value = clientName,
            onValueChange = { clientName = it },
            label = { Text("Nome do Cliente") },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                unfocusedIndicatorColor = Color.Gray
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            shape = RoundedCornerShape(8.dp)
        )

        // CPF
        TextField(
            value = clientCPF,
            onValueChange = { clientCPF = it },
            label = { Text("CPF") },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                unfocusedIndicatorColor = Color.Gray
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            shape = RoundedCornerShape(8.dp)
        )

        // Celular
        TextField(
            value = clientPhone,
            onValueChange = { clientPhone = it },
            label = { Text("Celular") },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                unfocusedIndicatorColor = Color.Gray
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            shape = RoundedCornerShape(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Pontuação de Risco", fontSize = 16.sp, color = Color.Gray)
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                .fillMaxWidth()
                .clickable { expanded = true }
                .background(Color.White, shape = RoundedCornerShape(8.dp))
                .padding(16.dp)
        ) {
            Text(riskScore)
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

        Spacer(modifier = Modifier.height(24.dp))

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
                    clientName = ""
                    clientCPF = ""
                    clientPhone = ""
                    riskScore = "Conservador"
                    navController.navigate("clients")
                }
            },
            enabled = clientName.isNotBlank() && clientCPF.isNotBlank() && clientPhone.isNotBlank(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("Adicionar Cliente", color = Color.White, fontWeight = FontWeight.SemiBold)
        }
    }
}
