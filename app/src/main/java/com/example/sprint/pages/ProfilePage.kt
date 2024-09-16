package com.example.sprint.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.sprint.authViewModel

@Composable
fun ProfilePage(modifier: Modifier = Modifier, authViewModel: authViewModel) {

    val userName = authViewModel.getUserName() ?: "Usuário"
    val userEmail = authViewModel.getUserEmail() ?: "Email não disponível"


    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Perfil do Cliente",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF19326A),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = rememberImagePainter("https://avatars.githubusercontent.com/u/72618276?v=4"),
            contentDescription = "Foto de perfil",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(128.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Nome: $userName",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF53B4E9),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            textAlign = TextAlign.Center
        )

        Text(
            text = "Email: $userEmail",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF53B4E9),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF19326A))
        ) {
            Text(text = "Editar Perfil", color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF19326A))
        ) {
            Text(text = "Expandir Dados", color = Color.White)
        }
    }
}
