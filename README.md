# 📦 CRUD de Produtos com Spring Boot e Segurança com JWT

[![NPM](https://img.shields.io/npm/l/react)](https://github.com/AndreOliveiraALO/dslist/blob/main/LICENSE)

Este projeto é uma **API RESTful** desenvolvida em Java com **Spring Boot**, com o objetivo de realizar o cadastro e controle de produtos, incluindo autenticação e autorização de usuários com **JWT (JSON Web Token)**.

A estrutura segue a **Arquitetura MVC**, com divisão clara em:

* `Controller` (controle das rotas),
* `Service` (lógica de negócio),
* `Repository` (acesso ao banco de dados),
* `Domain` (modelos/entidades).

Utiliza também **ORM com JPA / Hibernate** para o mapeamento objeto-relacional.

Projeto desenvolvido durante o curso ministrado por **Matheus Leandro Ferreira**, com foco em práticas modernas de desenvolvimento backend.

---

## 🧰 Modelo Conceitual

![Modelo Conceitual](https://github.com/AndreOliveiraALO/Projetos/blob/main/Imagens/projeto-crud-springboot/ModeloConceitual.png)

---

## 🔐 Endpoints da API

| Recurso | Método | URL                  | Autenticação | Descrição                |
| ------- | ------ | -------------------- | ------------ | ------------------------ |
| Usuário | POST   | `/auth/register`     | ❌            | Criação de usuário       |
| Usuário | POST   | `/auth/login`        | ❌            | Login e geração de token |
| Produto | POST   | `/api/produtos`      | ✅ Bearer     | Cadastrar novo produto   |
| Produto | GET    | `/api/produtos`      | ✅ Bearer     | Listar todos os produtos |
| Produto | GET    | `/api/produtos/{id}` | ✅ Bearer     | Buscar produto por ID    |
| Produto | DELETE | `/api/produtos/{id}` | ✅ Bearer     | Excluir produto por ID   |

> ⚠️ Para acessar os endpoints protegidos, informe o token JWT no cabeçalho:
> `Authorization: Bearer {seu_token}`

---

## 📄 Exemplos de Requisições (JSON)

### 🔸 Criar Usuário

**POST** `/auth/register`

```json
{
  "login": "Andre",
  "senha": "senha"
}
```

---

### 🔸 Login e geração de token

**POST** `/auth/login`

```json
{
  "login": "Andre",
  "senha": "senha"
}
```

🔁 Resposta:

```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

---

### 🔸 Criar Produto

**POST** `/api/produtos`
**Header:** `Authorization: Bearer {token}`

```json
{
  "nome": "PenDrive 16GB",
  "preco": 60.50
}
```

---

### 🔸 Listar Todos os Produtos

**GET** `/api/produtos`
**Header:** `Authorization: Bearer {token}`

🔁 Resposta:

```json
[
  {
    "id": 1,
    "nome": "PenDrive 16GB",
    "preco": 60.50
  },
  {
    "id": 2,
    "nome": "Mouse Gamer",
    "preco": 89.90
  }
]
```

---

### 🔸 Buscar Produto por ID

**GET** `/api/produtos/1`
**Header:** `Authorization: Bearer {token}`

🔁 Resposta:

```json
{
  "id": 1,
  "nome": "PenDrive 16GB",
  "preco": 60.50
}
```

---

### 🔸 Excluir Produto

**DELETE** `/api/produtos/1`
**Header:** `Authorization: Bearer {token}`

🔁 Resposta:

```
204 No Content
```

---

## 🚀 Tecnologias Utilizadas

* Java 17
* Spring Boot
* Spring Data JPA
* Spring Security
* JWT (JSON Web Token)
* Maven
* Banco de dados Oracle (ambiente local)

---

## ▶️ Como Executar o Projeto

### Pré-requisitos

* Java 17 instalado
* Maven
* Banco de dados Oracle configurado

### Comandos

```bash
# Clonar repositório
git clone https://github.com/AndreOliveiraALO/crud-produtos-jwt

# Acessar a pasta
cd crud-produtos-jwt

# Executar
./mvnw spring-boot:run
```

---

## 👨‍💼 Autor

[![LinkedIn](https://img.shields.io/badge/-André%20Luiz%20de%20Oliveira-blue?style=flat-square\&logo=linkedin\&logoColor=white\&link=https://www.linkedin.com/in/andre-oliveira-a9a4281b0/)](https://www.linkedin.com/in/andre-oliveira-a9a4281b0/)

---

