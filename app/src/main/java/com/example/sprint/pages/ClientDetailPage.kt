package com.example.sprint.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sprint.ClientViewModel

@Composable
fun ClientDetailPage(clientId: String, clientViewModel: ClientViewModel = viewModel()) {
    val clients = clientViewModel.clients.collectAsState()
    val client = clients.value.find { it.id == clientId }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE5F4FB))
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        if (client != null) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Detalhes do Cliente",
                        fontSize = 24.sp,
                        color = Color(0xFF19326A),
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "Nome: ${client.name}",
                        fontSize = 20.sp,
                        color = Color(0xFF53B4E9)
                    )
                    Text(
                        text = "CPF: ${client.cpf}",
                        fontSize = 20.sp,
                        color = Color(0xFF53B4E9)
                    )
                    Text(
                        text = "Celular: ${client.phone}",
                        fontSize = 20.sp,
                        color = Color(0xFF53B4E9)
                    )
                    Text(
                        text = "Pontuação de Risco: ${client.riskScore}",
                        fontSize = 20.sp,
                        color = Color(0xFF53B4E9)
                    )
                }
            }
        } else {
            Text(
                text = "Carregando cliente...",
                fontSize = 20.sp,
                color = Color.Gray
            )
        }
    }
}
