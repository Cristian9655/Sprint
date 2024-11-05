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

Este projeto visa desenvolver um aplicativo mobile para a **previsão do comportamento do cliente**, utilizando técnicas de **Machine Learning (ML)**. A aplicação permite que empresas antecipem as necessidades dos clientes, identifiquem padrões de comportamento e aprimorem suas estratégias de retenção e engajamento.

**[Veja o vídeo de funcionamento do aplicativo](https://youtu.be/SrA9kB2SJlw)**
- https://youtu.be/SrA9kB2SJlw
---

## **Índice**

- [Descrição do Projeto](#descrição-do-projeto)
- [Motivação do Projeto](#motivação-do-projeto)
- [Funcionalidades](#funcionalidades)
- [Arquitetura](#arquitetura)
- [Implementação Técnica do CRUD com Firebase](#implementação-técnica-do-crud-com-firebase)
- [Testes e Validação](#testes-e-validação)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)

---

## **Descrição do Projeto**

O **Modelo de Previsão de Comportamento do Cliente** é uma aplicação desenvolvida em **Android Kotlin** que utiliza dados históricos de interação dos clientes para prever seu comportamento futuro. O projeto foi criado para ajudar empresas a **personalizar estratégias de engajamento** e **melhorar a retenção de clientes**, prevenindo o risco de churn (cancelamento de serviço).

A aplicação cumpre os seguintes requisitos de funcionalidade:

1. **CRUD Completo** - As telas de clientes permitem **criação, leitura, atualização e exclusão de dados** (CRUD), com integração direta com o servidor para persistência dos dados via **API do Firebase Firestore**.

2. **Integração com API** - Os dados dos clientes são enviados, lidos e atualizados no Firebase, garantindo que todas as operações de CRUD são executadas de forma remota e sincronizada entre o app e o servidor.

---

## **Motivação do Projeto**

A retenção de clientes é um dos principais desafios para empresas de diversos setores. Com a crescente competitividade no mercado, entender o comportamento do cliente e prever o risco de cancelamento se tornou essencial. Utilizando técnicas de previsão e monitoramento de dados históricos, este projeto oferece uma ferramenta que ajuda empresas a tomar **decisões proativas** para engajamento de clientes, atuando de forma preventiva para evitar a perda de consumidores.

O aplicativo foi desenvolvido para atender essa necessidade, permitindo que empresas monitorem o status de seus clientes em tempo real e ajustem suas estratégias de retenção de acordo com os padrões observados.

---

## **Funcionalidades**

### 1. **Autenticação de Usuários**
- Cadastro e login de usuários com autenticação via Firebase, garantindo segurança e individualização dos dados.

### 2. **CRUD de Clientes**
- **Criação, leitura, atualização e exclusão de clientes** com sincronização automática via Firebase. Todos os dados são armazenados no Firestore, permitindo a gestão remota dos registros.

### 3. **Previsão de Comportamento**
- Visualização da lista de clientes com informações sobre seu status de risco (Conservador, Moderado ou Arrojado), com base nos dados cadastrados e nos padrões de comportamento de cada cliente.

### 4. **Perfis de Clientes**
- Exibição detalhada do perfil do cliente, incluindo nome, CPF, telefone, pontuação de risco e outras informações relevantes.

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

## **Implementação Técnica do CRUD com Firebase**

Para gerenciar os dados dos clientes, utilizamos o **Firebase Firestore**, que é um banco de dados NoSQL em tempo real. O repositório `ClientRepository.kt` é responsável por realizar as operações CRUD diretamente no Firestore. Abaixo estão os métodos principais:

- **Adicionar Cliente (`addClient`)**: Adiciona um novo documento na coleção `clients` no Firestore.
- **Obter Clientes (`getClients`)**: Obtém todos os documentos da coleção `clients` e os converte para objetos do tipo `Client`.
- **Atualizar Cliente (`updateClient`)**: Atualiza um documento específico na coleção `clients` com os novos dados.
- **Deletar Cliente (`deleteClient`)**: Remove um documento específico da coleção `clients`.

O `ClientViewModel.kt` gerencia o fluxo de dados entre o repositório e a interface de usuário, mantendo a lógica de negócios no ViewModel e atualizando a UI automaticamente ao alterar os dados.

---

## **Testes e Validação**

Para garantir a confiabilidade e a funcionalidade do aplicativo, foram realizados os seguintes testes:

1. **Testes de Integração com Firebase**:
    - Validamos as operações CRUD no Firebase Firestore para assegurar que os dados dos clientes são salvos e atualizados corretamente.
    - Testamos a integração com o Firebase Authentication para confirmar que apenas usuários autenticados podem acessar os dados dos clientes.

2. **Testes de UI**:
    - Testes visuais para verificar o layout das páginas e a responsividade dos componentes.
    - Testes das interações do usuário, como a navegação entre as telas, edição e exclusão de clientes.

3. **Validação dos Dados de Cliente**:
    - Verificamos se os dados inseridos (ex., CPF e telefone) atendem aos formatos esperados, garantindo a consistência dos dados salvos.

4. **Testes de Sincronização em Tempo Real**:
    - Validamos se as operações CRUD refletem mudanças em tempo real no Firebase Firestore, garantindo a sincronização dos dados entre o aplicativo e o servidor.

---

## **Tecnologias Utilizadas**

- **Kotlin** - Linguagem de programação para desenvolvimento Android.
- **Jetpack Compose** - Ferramenta de UI declarativa para Android.
- **Firebase Authentication** - Autenticação de usuários.
- **Firebase Firestore** - Banco de dados para persistência dos dados dos clientes.
- **Coil** - Biblioteca para carregamento de imagens.
- **Retrofit** - Integração com APIs RESTful.

---

## **Demonstração do Projeto**

**[Clique aqui para assistir ao vídeo de demonstração do aplicativo](https://youtu.be/SrA9kB2SJlw)**

---