# 🎬 Projeto Controle de Filmes - Spring Boot

## 📌 Descrição
Este projeto é um **exercício prático com Spring Boot e Spring Data JPA** que implementa um sistema simples de **controle de filmes e avaliações**.  
Ele foi criado com o objetivo de praticar **CRUD, padrão DTO, relacionamentos, validação, e repositórios customizados**.

---

## 🚀 Funcionalidades
- Cadastro de **Filmes** (título, ano de lançamento, gênero).  
- Cadastro de **Avaliações** (usuário, nota, comentário, filme associado).  
- Relacionamento **1:N** (um filme pode ter várias avaliações).    

---

## 🗃️ Modelagem

### 🎥 Filme
- `id` (Long, @Id, @GeneratedValue)  
- `titulo` (String,)  
- `anoLancamento` (Integer)  
- `genero` (String)  

### ⭐ Avaliacao
- `id` (Long, @Id, @GeneratedValue)  
- `usuario` (String)  
- `nota` (Integer)  
- `comentario` (String)  
- `filme` (ManyToOne → Filme)  

