# 🌿 EcoNomic – Sistema de Monitoramento Energético e Gestão ESG

**Projeto Acadêmico – FIAP**  
Solução backend robusta desenvolvida para monitoramento de consumo de energia, gestão de dispositivos IoT e rastreamento de metas sustentáveis alinhadas aos pilares ESG (*Environmental, Social, and Governance*).

---

## 📌 Sobre o Projeto
O EcoNomic é uma API RESTful projetada para centralizar o controle de consumo energético corporativo. A aplicação permite cadastrar dispositivos IoT de medição, registrar consumos por setor, emitir alertas operacionais para picos de uso e acompanhar metas de redução da pegada de carbono.

---

## 🛠️ Tecnologias Utilizadas
- **Linguagem:** Java 21+
- **Framework:** Spring Boot 3+ (Spring Web, Spring Data MongoDB)
- **Banco de Dados:** MongoDB 7.0 (NoSQL Document Store)
- **Utilitários:** Lombok, Maven
- **Testes de API:** Insomnia
- **Containerização:** Docker e Docker Compose
- **CI/CD:** GitHub Actions

---

## 🚀 Como executar localmente com Docker

Siga os passos abaixo para subir a aplicação completa na sua máquina:

1. **Pré-requisitos:**
   - Certifique-se de ter o Docker e o Docker Compose instalados e rodando.

2. **Subir os containers:**  
   Na pasta raiz do projeto (onde está o arquivo `docker-compose.yml`), execute o comando:
   ```bash
   docker-compose up -d --build
   ````
   Verificação:

3. Execute o comando abaixo e confirme que os containers economic_api e economic_mongodb estão com o status Up:
   ```bash
   docker-compose ps
   ````
4. Acessar e Testar a API:

A aplicação rodará na porta 8080. 
Você pode disparar requisições utilizando o Insomnia (http://localhost:8080/api/...).

## 🏗️ Arquitetura da Aplicação

A API foi desenvolvida seguindo o padrão de arquitetura em camadas para garantir alta coesão e baixo acoplamento:
   ```bash
   src/main/java/com/economic/
├── controller/     # Exposição dos Endpoints REST
├── model/          # Documentos/Entidades do MongoDB
├── repository/     # Interfaces de persistência (MongoRepository)
└── service/        # Regras de negócio e validações do sistema
   ````

  ##  🐳 Containerização
  
  O projeto utiliza um Dockerfile otimizado com multi-stage build (Maven e Eclipse Temurin Java 21) e um orquestrador docker-compose.yml que gerencia a comunicação na rede interna (economic-network) entre o banco NoSQL e a API.


 ##  ⚙️ Pipeline CI/CD
A esteira de integração e entrega contínua é gerenciada pelo GitHub Actions (.github/workflows/deploy.yml), automatizando as etapas de:

Build e compilação do projeto com Java 21.

Execução de testes automatizados.

Empacotamento e geração da imagem Docker.

  ##   📸 Prints do Funcionamento
Containers Ativos (Docker Compose): 
<img width="1271" height="752" alt="Captura de tela 2026-10-07 224753" src="https://github.com/user-attachments/assets/4d120bb4-8748-4a24-9fe6-4c38e6e997d3" />



Teste de API (Insomnia):
<img width="1911" height="1012" alt="image" src="https://github.com/user-attachments/assets/fcbbf926-122e-445b-a376-7de6a93b2111" />


Persistência de Dados (MongoDB Compass): 
<img width="1900" height="1007" alt="image" src="https://github.com/user-attachments/assets/dd8cf6be-0b3a-48f5-aa54-8cab17e6473e" />


Status do Pipeline (GitHub Actions): 
<img width="1896" height="842" alt="image" src="https://github.com/user-attachments/assets/f482cecc-e4e9-4ad8-a9b4-75b50e33293c" />




## 📋 Checklist de Entrega

| Item | Status |
| :--- | :---: |
| Projeto compactado em .ZIP com estrutura organizada | [x] |
| Dockerfile funcional | [x] |
| `docker-compose.yml` configurado | [x] |
| Pipeline com etapas de build, teste e deploy | [x] |
| `README.md` com instruções e prints | [x] |
| Documentação técnica com evidências | [x] |
| Deploy realizado nos ambientes staging e produção | [x] |
