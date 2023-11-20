# HELP LIFE
![LOGO](logo.png)
## Descrição
A fim de proporcionar um acompanhamento exclusivo para o paciente, criamos o HelpLife. Nosso produto irá monitorar cada beneficiário durante 24 horas para garantir sua proteção e prevenção de sua saúde. Além disso, poderão inicar um chat com um médico a sua escolha ou será disponibilizado um profissional qualificado.
## Recursos Utilizados

### Diagrama de Macrosolução
![DIAG](diagrama.png)

## Executando o Sistema e Criando o Pipeline na Azure

### Criação do Pipeline
1. Na criação do pipeline na Azure, adicione o repositório desejado. No nosso caso, utilizamos [este](https://github.com/help-life-gs/api-spring).
2. Se a criação estiver como modo clássico, selecione o template do Maven e mude a versão do JDK para a versão 17.
3. Caso não seja a versão clássica, adicione este arquivo [YML](#arquivo-yaml-da-pipeline).

### Criação do WebApp
1. Para a criação do pipeline, precisaremos de um WebApp Windows com o JDK 17.
2. Após isso, crie o release com o WebApp criado.

### Testando as Requisições
1. Quando o release estiver pronto, pegue o link e teste as requisições no Postman.
2. Siga os passos abaixo para enviar as requisições da seção Endpoints.

## Mapa de Requisições
### Usuário
1. **POST `/api/registrar`**
    #### Body
    ```json
    {
        "nome": "Matheus Gomes",
        "email": "matheus@email.com",
        "dataNasc": "1998-09-19",
        "telefone":"11998776655",
        "senha":"Senha@123"
    }
    ```
2. **POST `/api/login`**
    #### Body
    ```json
    {
        "email": "matheus@email.com",
        "senha":"Senha@123"
    }
    ```
3. **PUT `/api/atualizar`**
    #### Header
    ```json
    {
        "Authorization": "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJtYXRoZXVzQGVtYWlsLmNvbSIsImlzcyI6IkhlbHBURSIsImV4cCI6MTcwMDA4NzYyOH0.tNv3fMvEC0AKkWgQPyoBsW1A7HhEABrrD7Fx-GnEWZM"
    }
    ```
    #### Body
    ```json
    {
        "nome": "Matheus Gomes",
        "email": "matheus@email.com",
        "dataNasc": "1998-09-19",
        "telefone":"11998776655",
        "senha":"Senha@123"
    }
    ```
### Endereço
1. **GET `/api/endereco/`**
    #### Header
    ```json
    {
        "Authorization": "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJtYXRoZXVzQGVtYWlsLmNvbSIsImlzcyI6IkhlbHBURSIsImV4cCI6MTcwMDA4NzYyOH0.tNv3fMvEC0AKkWgQPyoBsW1A7HhEABrrD7Fx-GnEWZM"
    }
    ```
2. **GET `/api/endereco/:id`**
    #### Header
    ```json
    {
        "Authorization": "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJtYXRoZXVzQGVtYWlsLmNvbSIsImlzcyI6IkhlbHBURSIsImV4cCI6MTcwMDA4NzYyOH0.tNv3fMvEC0AKkWgQPyoBsW1A7HhEABrrD7Fx-GnEWZM"
    }
    ```
3. **POST `/api/endereco/`**
    #### Header
    ```json
    {
        "Authorization": "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJtYXRoZXVzQGVtYWlsLmNvbSIsImlzcyI6IkhlbHBURSIsImV4cCI6MTcwMDA4NzYyOH0.tNv3fMvEC0AKkWgQPyoBsW1A7HhEABrrD7Fx-GnEWZM"
    }
    ```
    #### Body
    ```json
    {
        "cep": "09851570",
        "estado": "SP",
        "cidade": "Ipiranga",
        "logradouro": "R. Paula Ferraz",
        "numero": "190",
    }
    ```
4. **PUT `/api/endereco/:id`**
    #### Header
    ```json
    {
        "Authorization": "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJtYXRoZXVzQGVtYWlsLmNvbSIsImlzcyI6IkhlbHBURSIsImV4cCI6MTcwMDA4NzYyOH0.tNv3fMvEC0AKkWgQPyoBsW1A7HhEABrrD7Fx-GnEWZM"
    }
    ```
    #### Body
    ```json
    {
        "cep": "09851570",
        "estado": "SP",
        "cidade": "Ipiranga",
        "logradouro": "R. Paula Ferraz",
        "numero": "190",
    }
    ```
5. **DELETE `/api/endereco/:id`**
    #### Header
    ```json
    {
        "Authorization": "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJtYXRoZXVzQGVtYWlsLmNvbSIsImlzcyI6IkhlbHBURSIsImV4cCI6MTcwMDA4NzYyOH0.tNv3fMvEC0AKkWgQPyoBsW1A7HhEABrrD7Fx-GnEWZM"
    }
    ```
### Histórico
1. **GET `/api/historico/`**
    #### Header
    ```json
    {
        "Authorization": "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJtYXRoZXVzQGVtYWlsLmNvbSIsImlzcyI6IkhlbHBURSIsImV4cCI6MTcwMDA4NzYyOH0.tNv3fMvEC0AKkWgQPyoBsW1A7HhEABrrD7Fx-GnEWZM"
    }
    ```
2. **GET `/api/historico/:id`**
    #### Header
    ```json
    {
        "Authorization": "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJtYXRoZXVzQGVtYWlsLmNvbSIsImlzcyI6IkhlbHBURSIsImV4cCI6MTcwMDA4NzYyOH0.tNv3fMvEC0AKkWgQPyoBsW1A7HhEABrrD7Fx-GnEWZM"
    }
    ```
3. **POST `/api/historico/`**
    #### Header
    ```json
    {
        "Authorization": "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJtYXRoZXVzQGVtYWlsLmNvbSIsImlzcyI6IkhlbHBURSIsImV4cCI6MTcwMDA4NzYyOH0.tNv3fMvEC0AKkWgQPyoBsW1A7HhEABrrD7Fx-GnEWZM"
    }
    ```
    #### Body
    ```json
    {
        "batimentos": 78,
        "temperatura": 36.5,
        "oxigenio": 97,
        "latitude": -23.628573,
        "longitude": -46.611763,
    }
    ```
1. **DELETE `/api/historico/:id`**
    #### Header
    ```json
    {
        "Authorization": "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJtYXRoZXVzQGVtYWlsLmNvbSIsImlzcyI6IkhlbHBURSIsImV4cCI6MTcwMDA4NzYyOH0.tNv3fMvEC0AKkWgQPyoBsW1A7HhEABrrD7Fx-GnEWZM"
    }
    ```
### OBS: OS DADOS MOSTRADOS ACIMA SÃO APENAS DE EXEMPLO. CASO FOR TESTAR A APLICAÇÃO CRIE SEU USUÁRIO, A RESPOSTA DA CRIAÇÃO DE USUÁRIO É UM TOKEN!

## Arquivo YAML da Pipeline
```yml
name: Build and deploy JAR app to Azure Web App - help-life

on:
  push:
    branches:
      - main
  workflow_dispatch:

jobs:
  build:
    runs-on: windows-latest

    steps:
      - uses: actions/checkout@v4

      - name: Set up Java version
        uses: actions/setup-java@v1
        with:
          java-version: '17'

      - name: Build with Maven
        run: mvn clean install

      - name: Upload artifact for deployment job
        uses: actions/upload-artifact@v3
        with:
          name: java-app
          path: '${{ github.workspace }}/target/*.jar'

  deploy:
    runs-on: windows-latest
    needs: build
    environment:
      name: 'Production'
      url: ${{ steps.deploy-to-webapp.outputs.webapp-url }}

    steps:
      - name: Download artifact from build job
        uses: actions/download-artifact@v3
        with:
          name: java-app

      - name: Deploy to Azure Web App
        id: deploy-to-webapp
        uses: azure/webapps-deploy@v2
        with:
          app-name: 'help-life'
          slot-name: 'Production'
          publish-profile: ${{ secrets.AZUREAPPSERVICE_PUBLISHPROFILE_E4A6B116A8BF4FD4B3CD0BFE3812DFA6 }}
          package: '*.jar'
```