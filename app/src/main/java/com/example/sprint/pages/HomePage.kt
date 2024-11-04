package com.example.sprint.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.layout.ContentScale
import androidx.navigation.NavController
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.draw.clipToBounds
import coil.compose.AsyncImage
import com.example.sprint.AuthState
import com.example.sprint.ClientViewModel
import com.example.sprint.authViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomePage(
    modifier: Modifier = Modifier,
    navController: NavController, // Certifique-se de que o NavController está sendo passado aqui
    authViewModel: authViewModel
) {
    // Instancia o ClientViewModel
    val clientViewModel: ClientViewModel = viewModel()
    val authState = authViewModel.authState.observeAsState()

    // Verifica o estado de autenticação e redireciona para a tela de login, se necessário
    LaunchedEffect(authState.value) {
        when (authState.value) {
            is AuthState.Unauthenticated -> navController.navigate("login")
            else -> Unit
        }
    }

    var selectedPage by remember { mutableStateOf("overview") }

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = Color(0xFFE5F4FB) // Cor do fundo
            ) {
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Home, contentDescription = "Visão Geral") },
                    label = { Text("Visão Geral") },
                    selected = selectedPage == "overview",
                    onClick = { selectedPage = "overview" }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.List, contentDescription = "Clientes") },
                    label = { Text("Clientes") },
                    selected = selectedPage == "clients",
                    onClick = { selectedPage = "clients" }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Person, contentDescription = "Perfil") },
                    label = { Text("Perfil") },
                    selected = selectedPage == "profile",
                    onClick = { selectedPage = "profile" }
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color(0xFFE5F4FB)),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(Color(0xFFE5F4FB)),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "CardKeeper",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF19326A)
                )

                TextButton(onClick = {
                    authViewModel.signout()
                }) {
                    Text(
                        text = "Sign out",
                        color = Color(0xFF53B4E9)
                    )
                }
            }

            Divider(
                color = Color(0xFF19326A).copy(alpha = 0.3f),
                thickness = 1.dp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                when (selectedPage) {
                    "overview" -> {
                        Text(
                            text = "Visão Geral do Risco de Rotatividade",
                            fontSize = 28.sp,
                            color = Color(0xFF19326A),
                            fontWeight = FontWeight.Bold,
                            lineHeight =  35.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp)
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Bem-vindo ao seu centro de controle, gerencie proativamente o risco de seus clientes!",
                            fontSize = 16.sp,
                            color = Color(0xFF53B4E9),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            textAlign = TextAlign.Justify
                        )

                        Spacer(modifier = Modifier.height(28.dp))

                        AsyncImage(
                            model = "https://st2.depositphotos.com/1788150/5618/v/450/depositphotos_56185461-stock-illustration-set-statistics-icon.jpg",
                            contentDescription = "Imagem de exemplo",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                                .padding(horizontal = 16.dp)
                                .clipToBounds(),
                            contentScale = ContentScale.Crop
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Button(
                            onClick = {},
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF19326A)
                            )
                        ) {
                            Text(text = "Ver Detalhes", color = Color.White)
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Button(
                            onClick = { },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF19326A)
                            )
                        ) {
                            Text(text = "Gerar Relatório", color = Color.White)
                        }
                    }

                    "clients" -> {
                        ClientsPage(
                            navController = navController, // Passa o navController aqui
                            clientViewModel = clientViewModel,
                            onClientDetail = { clientId ->
                                navController.navigate("client_detail/$clientId")
                            }
                        )
                    }

                    "profile" -> {
                        ProfilePage(authViewModel = authViewModel)
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
