## **Integrantes do Grupo**

| Nome                           | RM      |
|--------------------------------|---------|
| Diego Seiti Ogita Iacabo       | 551289  |
| Cristian Alvaro Condori Paucara| 550509  |
| Alejandro Rabelo               | 93606   |
| João Lucas Marques Costa       | 98376   |
| Luiz Felipe Azevedo de Oliveira| 550348  |

---

# **Modelo de Previsão de Comportamento do Cliente**

Este projeto tem como objetivo desenvolver um aplicativo mobile para a **previsão do comportamento do cliente** utilizando técnicas de **Machine Learning (ML)**. A aplicação permite que empresas antecipem as necessidades dos clientes, identifiquem padrões de comportamento e melhorem suas estratégias de retenção e engajamento.

## **Índice**

- [Descrição do Projeto](#descrição-do-projeto)
- [Funcionalidades](#funcionalidades)
- [Arquitetura](#arquitetura)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)

---

## **Descrição do Projeto**

O **Modelo de Previsão de Comportamento do Cliente** é uma aplicação desenvolvida em **Android Kotlin** que utiliza dados históricos de interação dos clientes para prever seu comportamento futuro. O projeto foi criado com o objetivo de auxiliar empresas a **personalizar estratégias de engajamento** e **melhorar a retenção de clientes**, prevenindo o risco de churn (cancelamento de serviço).

A aplicação cumpre os seguintes requisitos de funcionalidade:

1. **CRUD Completo** - As telas de clientes permitem **criação, leitura, atualização e exclusão de dados** (CRUD), com integração direta com o servidor para persistência dos dados via **API do Firebase Firestore**.

2. **Integração com API** - Os dados dos clientes são enviados, lidos, e atualizados no Firebase, garantindo que todas as operações de CRUD são executadas de forma remota e sincronizada entre o app e o servidor.

---

## **Funcionalidades**

- **Autenticação de Usuários**: Cadastro e login de usuários com autenticação via Firebase.
- **CRUD de Clientes**: Criação, leitura, atualização e exclusão de clientes com sincronização via Firebase.
- **Previsão de Comportamento**: Visualização da lista de clientes com informações sobre seu status de risco (Conservador, Moderado ou Arrojado).
- **Perfis de Clientes**: Exibição de detalhes do perfil do cliente com dados preditivos.
- **Integração com APIs de Machine Learning**: Conexão com modelos de ML para previsão (opcional).

---

## **Arquitetura**

O projeto segue a arquitetura **MVVM (Model-View-ViewModel)** para desacoplar a lógica de negócios da interface de usuário, facilitando a manutenção e escalabilidade do código.

### **Estrutura de Pastas**

```bash
app/
├── src/
│   ├── main/
│   │   ├── java/com/example/sprint/
│   │   │   ├── pages/                   # Telas principais da aplicação
│   │   │   │   ├── AddClientPage.kt     # Tela para adicionar clientes
│   │   │   │   ├── ClientDetailPage.kt  # Tela de detalhes do cliente
│   │   │   │   ├── ClientsPage.kt       # Tela de listagem e edição de clientes
│   │   │   │   ├── HomePage.kt          # Tela inicial com visão geral
│   │   │   │   ├── LoginPage.kt         # Tela de login
│   │   │   │   ├── ProfilePage.kt       # Tela de perfil do cliente
│   │   │   │   └── SignupPage.kt        # Tela de cadastro
│   │   │   ├── repository/              # Repositório de dados do cliente
│   │   │   │   └── ClientRepository.kt  # Repositório com operações CRUD no Firebase
│   │   │   ├── ui.theme/                # Configurações de tema e estilos do app
│   │   │   ├── authViewModel.kt         # ViewModel para autenticação
│   │   │   ├── ClientViewModel.kt       # ViewModel para operações de cliente
│   │   │   ├── MainActivity.kt          # Activity principal que controla a navegação
│   │   │   └── MyAppNavigation.kt       # Controle de navegação entre as telas
│   ├── res/                             # Recursos (layouts, imagens, strings)
│   └── build.gradle                     # Configurações de build
```

---

## **Tecnologias Utilizadas**

- **Kotlin** - Linguagem de programação para desenvolvimento Android.
- **Jetpack Compose** - Ferramenta de UI declarativa para Android.
- **Firebase Authentication** - Autenticação de usuários.
- **Firebase Firestore** - Banco de dados para persistência dos dados dos clientes.
- **Coil** - Biblioteca para carregamento de imagens.
- **Retrofit** - Integração com APIs RESTful.

---