# 🌿 EcoNomic – Sistema de Monitoramento Energético e Gestão ESG

[![Java](https://img.shields.io/badge/Java-21%2B-orange?style=for-the-badge&logo=java)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?style=for-the-badge&logo=springboot)](https://spring.io/projects/spring-boot)
[![MongoDB](https://img.shields.io/badge/MongoDB-NoSQL-green?style=for-the-badge&logo=mongodb)](https://www.mongodb.com/)
[![Insomnia](https://img.shields.io/badge/Insomnia-REST%20Client-purple?style=for-the-badge&logo=insomnia)](https://insomnia.rest/)

> **Projeto Acadêmico – FIAP**  
> Solução backend robusta desenvolvida para monitoramento de consumo de energia, gestão de dispositivos IoT e rastreamento de metas sustentáveis alinhadas aos pilares ESG (*Environmental, Social, and Governance*).

---

## 📌 Sobre o Projeto

O **EcoNomic** é uma API RESTful projetada para centralizar o controle de consumo energético corporativo. A aplicação permite cadastrar dispositivos IoT de medição, registrar consumos por setor, emitir alertas operacionais para picos de uso e acompanhar metas de redução da pegada de carbono.

### 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java 21+
- **Framework:** Spring Boot 3+ (Spring Web, Spring Data MongoDB)
- **Banco de Dados:** MongoDB (NoSQL Document Store)
- **Utilitários:** Lombok, Maven
- **Testes de API:** Insomnia

---

## 🏗️ Arquitetura da Aplicação

A API foi desenvolvida seguindo o padrão de arquitetura em camadas para garantir alta coesão e baixo acoplamento:

```text
src/main/java/com/economic/
├── controller/     # Exposição dos Endpoints REST
├── model/          # Documentos/Entidades do MongoDB
├── repository/     # Interfaces de persistência (MongoRepository)
└── service/        # Regras de negócio e validações do sistema
