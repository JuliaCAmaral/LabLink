# Projeto LabLink
Aplicação referente ao projeto integrado da pós graduação em engenharia de software pela PUC Minas.

A aplicação tem como objetivo gerenciar os laudos gerados pelo laboratório de higiene ocupacinal. 

Este gerenciamento engloba:
- Gerenciamento de clientes do laboratório; 
- Gerenciamento de ordens de pedido;
- Gerenciamento dos amostradores;
- Vínculo de amostradores com a ordem de pedido;
- Cadastro de dados de coleta de cada amostrador;
- Cadastro de resultado da análise da amostra;
- Geração e impressão de laudos;

## Requisitos para executar o projeto:
- Docker e docker-compose
- Java 11
- Wildfly 26.1.0: https://www.wildfly.org/downloads/
- PostgreSQL JDBC Driver

## Executando o projeto
1. Clone o projeto na pasta de sua preferência
2. Abra o arquivo standalone.xml na pasta do seu Wildfly no caminho 
   ``pastaWildfly/standalone/configuration/standalone.xml``;
3. Para que seja configurado o banco de dados, adicione em **datasources** o seguinte trecho: 

``` 
<datasources>
    <datasource jndi-name="java:jboss/datasources/PostgresDS" pool-name="PostgresDS">
        <connection-url>jdbc:postgresql://localhost:5432/postgres</connection-url>
        <driver>postgresql</driver>
        <security>
            <user-name>postgres</user-name>
            <password>postgres</password>
        </security>
    </datasource>
    
    <drivers>
        <driver name="postgresql" module="org.postgresql">
            <driver-class>org.postgresql.Driver</driver-class>
        </driver>
    </drivers>
</datasources>
```

4. Execute o comando no terminal, na raiz do projeto: `` docker-compose up -d ``
5. Acesse o endereço ``http://localhost:8080/``

### Tecnologias utilizadas:

- **JSF e Primefaces -** Para criação de componentes do projeto;
- **JPA e Hibernate -** Responsável pela organização e as transações realizadas no banco de dados;
- **Apache Shiro -** Utilizado para gerenciamento de segurança;
- **PostgresSQL -** Banco de dados utilizado na aplicação;
- **Java -** Linguagem de programação utilizada na elaboração do projeto;
- **JBoss/Wildfly -** Servidor para rodar aplicação;
- **Docker -** Container para rodar banco de dados;

### Logins para teste de funcionalidades:
- email: vendedor@lab.com
- senha: teste

### Configurando o WildFly na IntelliJ IDEA
1. Editar configurações.
   ![config_passo_1](https://github.com/JuliaCAmaral/LabLink/assets/94651831/576a566b-450c-4a31-a950-a2c895a9ed2d)
2. Adicionar nova configuração Jboss local:
   ![config_passo_2](https://github.com/JuliaCAmaral/LabLink/assets/94651831/01f6255b-4525-4378-adc3-266f2545afc6)
3. Configurar com o servidor wildfly baixado anteriormente.
   ![config_passo_3](https://github.com/JuliaCAmaral/LabLink/assets/94651831/bc5660f1-f857-40a2-8622-dcafab4bfdce)
   ![config_passo_4](https://github.com/JuliaCAmaral/LabLink/assets/94651831/b879f17c-3833-44dc-a31f-1b7a801562c5)
4. Selecionar o artifact lablink:war exploded
   ![config_passo_5](https://github.com/JuliaCAmaral/LabLink/assets/94651831/75be5680-b990-49e5-8628-b7b4b213a9d1)
   ![config_passo_6](https://github.com/JuliaCAmaral/LabLink/assets/94651831/36cc4632-bf45-4826-a7ab-54287c428d24)
OBS: Caso ocorra algum erro nas dependencias, realizar o maven clean/install
   ![config_passo_7](https://github.com/JuliaCAmaral/LabLink/assets/94651831/a9059dfa-e192-41c9-824b-84f25895db57)