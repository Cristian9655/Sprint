package com.example.sprint.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import coil.compose.rememberImagePainter

@Composable
fun ClientsPage(modifier: Modifier = Modifier) {

    val clients = listOf(
        Client("João da Silva", "Cliente VIP", "https://avatars.githubusercontent.com/u/72618276?v=4"),
        Client("Maria Oliveira", "Cliente Regular", "https://cm1.aminoapps.com/8811/4f5ff1a226e4696e12f2d15fa227619eef6072bc_375.jpg"),
        Client("Carlos Souza", "Cliente Premium", "https://cdn.openart.ai/uploads/image_IddZC4Ig_1697515226348_raw.jpg"),
        Client("Ana Pereira", "Cliente Novo", "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/8db6457f-da57-464f-b7ba-5247aeedc20b/dcb13iq-0dae8c28-6f04-46bd-9625-bfb1e229f674.png/v1/fill/w_1024,h_1024,q_80,strp/grimm__hollow_knight__by_trixxedheart_dcb13iq-fullview.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7ImhlaWdodCI6Ijw9MTAyNCIsInBhdGgiOiJcL2ZcLzhkYjY0NTdmLWRhNTctNDY0Zi1iN2JhLTUyNDdhZWVkYzIwYlwvZGNiMTNpcS0wZGFlOGMyOC02ZjA0LTQ2YmQtOTYyNS1iZmIxZTIyOWY2NzQucG5nIiwid2lkdGgiOiI8PTEwMjQifV1dLCJhdWQiOlsidXJuOnNlcnZpY2U6aW1hZ2Uub3BlcmF0aW9ucyJdfQ.ovxa3pwqCfp6wfV0gNsweP-Nte9C5IvV-7GCcxG4Hwo"),
        Client("Pedro Santos", "Cliente Antigo", "https://via.placeholder.com/100")
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {

        Text(
            text = "Clientes",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF19326A),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(clients) { client ->
                ClientItem(client)
            }
        }
    }
}

data class Client(val name: String, val description: String, val imageUrl: String)

@Composable
fun ClientItem(client: Client) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .clip(RoundedCornerShape(8.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberImagePainter(client.imageUrl),
            contentDescription = "Imagem do cliente",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(8.dp))
        )

        Spacer(modifier = Modifier.width(16.dp))


        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = client.name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF19326A)
            )

            Text(
                text = client.description,
                fontSize = 16.sp,
                color = Color(0xFF53B4E9)
            )
        }


        Button(
            onClick = { },
            modifier = Modifier
                .height(40.dp)
        ) {
            Text(text = "Ver Detalhes", color = Color.White)
        }
    }
}
