
# Nexus API

A Nexus API é uma aplicação backend desenvolvida com Java e Spring Boot, projetada para simular funcionalidades presentes em plataformas de redes sociais. O projeto tem como objetivo aplicar conceitos de desenvolvimento de APIs REST, modelagem de banco de dados, arquitetura em camadas e gerenciamento de relacionamentos entre entidades.

---

# Funcionalidades

## Usuários
- Cadastro de usuários
- Exclusão de usuários

## Publicações
- Criação de publicações
- Exclusão de publicações
- Associação de publicações aos usuários

---

# Funcionalidades em Desenvolvimento

As próximas versões do projeto incluirão:

- Sistema de seguidores
- Curtidas em publicações
- Comentários
- Feed de publicações
- Sistema de autenticação e autorização
- Documentação da API 

---

# Tecnologias Utilizadas

| Tecnologia | Descrição |
|---|---|
| Java | Linguagem principal da aplicação |
| Spring Boot | Framework para desenvolvimento backend |
| Spring Data JPA | Persistência e gerenciamento de dados |
| PostgreSQL | Banco de dados relacional |
| Maven | Gerenciador de dependências |

---

# Arquitetura do Projeto

O projeto segue uma arquitetura em camadas para melhor organização e manutenção do código:

```text
src/main/java
├── controller
├── repository
├── model
└── dto
````

### Camadas

* **Controller** → Responsável pelas rotas e requisições HTTP
* **Repository** → Comunicação com o banco de dados
* **Model** Entidades da aplicação
* **DTO** Transferência segura de dados

---

# Objetivo do Projeto

A Nexus API foi criada com fins de aprendizado e evolução prática em desenvolvimento backend, o projeto busca reforçar conhecimentos em:

* APIs REST
* Modelagem relacional
* Relacionamentos entre entidades
* Boas práticas com Spring Boot
* Organização de projetos backend
* Estruturas escaláveis

---

# Banco de Dados

O sistema utiliza PostgreSQL 
---

```
```
