# USAC13 -Ler e criar ficheiro com os últimos dados de cada sensor 
**No seguinte documento apresentam-se:**
* Descrição do Método
    * Parâmetros
    * Explicaçâo
* Observações  


## Descrição Do Método:
A função é responsável por periodicamente ler os últimos arquivos de dados dos sensores, converter os valores em números reais com duas casas decimais e criar um arquivo de texto contendo os últimos dados de cada sensor, armazenando-o no diretório apropriado.

## Parâmetros:
Nenhum parâmetro é fornecido explicitamente à função. Os detalhes da leitura de arquivos e atualização de dados são definidos internamente na função.
Comportamento:

**Leitura de Últimos Arquivos**:
A função acessa os últimos arquivos de dados dos sensores.

## Explicações:

Leitura de Últimos Arquivos:
A função acessa os últimos arquivos de dados dos sensores.
*Conversão de Valores*:


Para cada sensor, os valores são convertidos em números reais com duas casas decimais.
Criação de Arquivo de Texto:
Um arquivo de texto é criado no diretório adequado.
O arquivo contém os últimos dados de todos os sensores, com apenas um registo para cada.

**Observações**:
A implementação interna da função lida com a leitura de arquivos e a manipulação de dados.


