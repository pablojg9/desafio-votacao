# Votação

Essa aplicação foi desenvolvida em relação ao desafio solicitado. <br>

Projeto desenvolvido com a arquitetura hexagonal, por intuito de realizar todo core da aplicação referente a dominio sem
frameworks externos, somente Java nativo.

## Requisitos

- JDK 17
- Maven 3.8.6 ou superior

### Recomendações

**Executar**: `mvn clean install`

### Diretórios Principais

- `src/main/java`: Contém o código-fonte da aplicação.
- `src/test/java`: Contém testes de unidade e de integração.

### Entidades

- `Vote`: Representa a entidade de votação.
- `Agenda`: Representa a entidade de agenda, para abrir uma pauta.

### Request/Response

O projeto utiliza DTOs para requisições e respostas, facilitando a transferência de dados entre o cliente e o servidor.

#### Request

- `AgendaRequest`: Request para cadastrar uma pauta nova.
- `VoteRequest`: Cadastrar um voto de acordo com a pauta cadastrada.

#### Response

- `AgendaResponse`: Retorna o UUID e o nome da pauta que foi cadastrada.

### Endpoints

1. **Cadastro de uma nova pauta**

- **POST api/v1/agendas**
    - Cadastra uma nova pauta.
    - Exemplo de endpoint
        ````
        http://localhost:8080/api/v1/agendas
        ````
    - Exemplo de corpo da requisição:
      ```json
       {
          "name": "Pauta 1"
       }
       
      ```

    - Exemplo de resposta:
       ```json
       {
          "uuid": "df3ff974-f6cc-48c0-adc9-f9c38c2dcf03",
          "nameAgenda": "Pauta 1"
       } 
       ```

2. **Iniciar uma nova votação de acordo com o tempo solicitado**

- **POST /api/v1/agendas/{uuid}**
    - Exemplo do Endpoint:
       ````
         http://localhost:8080/api/v1/agendas/df3ff974-f6cc-48c0-adc9-f9c38c2dcf03
       ````

    - Exemplo com RequestParam:
      ```
      - RequestParam TIME (opcional)  
      - Default = time=1
      - exemplo: http://localhost:8080/api/v1/agendas/df3ff974-f6cc-48c0-adc9-f9c38c2dcf03?time=10

3. **Realizar a votação na pauta aberta**

- **POST /api/v1/votes/vote/{uuid}**
    - Exemplo do Endpoint:
       ````
         http://localhost:8080/api/v1/votes/vote/df3ff974-f6cc-48c0-adc9-f9c38c2dcf03
       ````
    - Exemplo de corpo da requisição:
       ```json
         {
           "cpf": "44607962015",
           "vote": "NAO"
         }
       ```