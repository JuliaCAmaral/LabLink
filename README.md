# LabLink
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

## Usuário de acesso da aplicação
- email: vendedor@lab.com
- senha: teste


## Como executar localmente
- Baixar o [docker](https://docs.docker.com/desktop/install/windows-install/) de acordo com seu sistema operacional.
- Baixar o servidor [WildFly 26.0.1.Final](https://drive.google.com/drive/folders/1YCL_Y7bI_oLNmMzvrwGZJyEMFgpdHkS2?usp=drive_link).

Após configurar o wildfly e executar o docker, subir a aplicação.

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


