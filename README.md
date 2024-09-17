## **Integrantes do Grupo**

| Nome          | RM         |
|------------------------|------------|
| Diego Seiti Ogita Iacabo    | 551289    |
| Cristian Alvaro Condori Paucara    | 550509    |
| Alejandro Rabelo    | 93606   |
| João Lucas Marques Costa    | 98376   |
| Luiz Felipe Azevedo de Oliveira    | 550348   |

---


# **Modelo de Previsão de Comportamento do Cliente**

Este projeto tem como objetivo desenvolver um aplicativo mobile para a **previsão do comportamento do cliente** utilizando técnicas de **Machine Learning (ML)**. A aplicação permite que empresas antecipem as necessidades dos clientes, identifiquem padrões de comportamento e melhorem suas estratégias de retenção e engajamento.

## **Índice**

- [Descrição do Projeto](#descrição-do-projeto)
- [Funcionalidades](#funcionalidades)
- [Arquitetura](#arquitetura)
- [Instalação](#instalação)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)

---

## **Descrição do Projeto**

O **Modelo de Previsão de Comportamento do Cliente** é uma aplicação desenvolvida em **Android Kotlin** que utiliza dados históricos de interação dos clientes para prever seu comportamento futuro. O projeto foi criado com o objetivo de auxiliar empresas a **personalizar estratégias de engajamento** e **melhorar a retenção de clientes**, prevenindo o risco de churn (cancelamento de serviço).

O sistema analisa dados de clientes e fornece previsões sobre sua fidelidade ou tendência a cancelar serviços, permitindo que a empresa tome decisões baseadas em dados e implemente ações preventivas.

---

## **Funcionalidades**

- **Autenticação de Usuários**: Cadastro e login de usuários com autenticação via Firebase.
- **Previsão de Comportamento**: Visualização da lista de clientes com informações sobre seu status de risco (alto, médio ou baixo risco de cancelamento).
- **Perfis de Clientes**: Exibição de detalhes do perfil do cliente com dados preditivos.
- **Intervenção Proativa**: Sugestões para retenção de clientes com alto risco de churn.
- **Integração com APIs de Machine Learning**: Conexão com modelos de ML para previsão.

---

## **Arquitetura**

O projeto segue a arquitetura **MVVM (Model-View-ViewModel)** para desacoplar a lógica de negócios da interface de usuário e permitir a fácil manutenção e escalabilidade.

### **Estrutura de Pastas**

```bash
app/
├── src/
│   ├── main/
│   │   ├── java/com/example/sprint/
│   │   │   ├── authViewModel.kt     # ViewModel para autenticação
│   │   │   ├── MainActivity.kt      # Activity principal que controla a navegação
│   │   │   ├── MyAppNavigation.kt   # Controle de navegação entre as telas
│   │   │   ├── pages/               # Telas principais da aplicação
│   │   │   │   ├── ClientsPage.kt   # Tela de listagem de clientes e risco de churn
│   │   │   │   ├── ProfilePage.kt   # Tela de perfil do cliente
│   │   │   │   ├── HomePage.kt      # Tela inicial com visão geral
│   │   │   │   ├── LoginPage.kt     # Tela de login
│   │   │   │   ├── SignupPage.kt    # Tela de cadastro
│   ├── res/                         # Recursos (layouts, imagens, strings)
├── build.gradle                     # Configurações de build
```

---

## **Instalação**

### **Pré-requisitos**

- **Android Studio** 4.2 ou superior
- **Kotlin** 1.5 ou superior
- **Firebase** (para autenticação e backend)
- **API de Machine Learning** (opcional para previsão)

### **Passo a Passo**

1. Clone o repositório:

```bash
git clone https://github.com/Cristian9655/Sprint.git
```

2. Abra o projeto no **Android Studio**.

3. Configure o **Firebase** no projeto:
   - Acesse o [Firebase Console](https://console.firebase.google.com/).
   - Crie um novo projeto e adicione um app Android.
   - Baixe o arquivo `google-services.json` e adicione-o na pasta `app`.

4. Execute o projeto no Android Studio.

---

## **Tecnologias Utilizadas**

- **Kotlin** - Linguagem de programação para desenvolvimento Android.
- **Jetpack Compose** - Ferramenta de UI declarativa para Android.
- **Firebase Authentication** - Autenticação de usuários.
- **Coil** - Biblioteca para carregamento de imagens.
- **API de Machine Learning** - Para previsão do comportamento do cliente.
- **Retrofit** - Integração com APIs RESTful.

