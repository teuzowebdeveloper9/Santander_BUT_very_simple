### 📁 Backend - README.md

```markdown
# Santander Digital Bank - Backend

Este repositório contém o backend da aplicação full stack "Santander Digital Bank", criado em homenagem à minha seleção para o Bootcamp Santander 2025.

Este backend é composto por **três APIs** construídas com Spring Boot, seguindo princípios de arquitetura limpa, MVC e REST/RESTful.

## 🛠️ Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Docker (em desenvolvimento)
- Lombok
- MapStruct (opcional)
- Flyway (opcional)
- RabbitMQ (em estudo)

## 🔁 APIs

### 📌 API de Autenticação

- `POST /auth/login`: Faz o login de usuários
- Repositórios refatorados com DRY, utilizando único `findBy` com lógica condicional

### 📌 API de Usuários

- `POST /users`: Cria um novo usuário
- `GET /users`: Lista todos os usuários cadastrados

### 📌 API de Transações

- `POST /transactions`: Cria uma nova transação entre usuários
- `GET /transactions`: Lista todas as transações
- `PUT /transactions/{id}`: Edita uma transação (simulação de erro corrigido)

## 📦 Estrutura de Pastas

- `controller`: Endpoints da API
- `dto`: Objetos de transferência de dados
- `repository`: Interfaces JPA com queries otimizadas
- `service`: Contém a lógica de negócio
- `model/entity`: Modelos persistentes
- `enum`: Definições de status e controle

## 🧠 Boas práticas aplicadas

- Princípio DRY (Don't Repeat Yourself)
- Arquitetura em camadas (MVC)
- Padrão REST e RESTful
- Separação clara de responsabilidades
- Commit semântico (feat:, fix:, chore:, etc.)
- DTOs para isolamento do modelo de domínio
- Enum para controle de estados e mensagens

## 📦 Banco de Dados

- PostgreSQL
- Tabelas separadas para `users`, `transactions`
- Mapeamento com JPA e validação

## 🧪 Como rodar localmente

```bash

git clone https://github.com/teuzowebdeveloper9/frontend-santander-BUT-is-very-simple

cd santander-digital-bank-backend


./mvnw spring-boot:run

```

Certifique-se de configurar o PostgreSQL corretamente com o schema e as credenciais no application.properties.

# 🙏 Agradecimentos
Este projeto representa uma grande evolução na minha jornada como desenvolvedor full stack. Sou grato ao Santander e à plataforma DIO pela oportunidade. Todos os commits foram feitos seguindo convenções semânticas, reforçando meu compromisso com boas práticas de versionamento.