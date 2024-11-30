# USAC07 - Configurar a Componente e Validar os Diretórios de Saída
**No seguinte documento apresentam-se:**
* Descrição do Método
    * Parâmetro
    * Retorno
    * Estruturas Utilizadas
    * Passos de Configuração
* Observações  

## Descrição do Método


O método configurarComponente tem como finalidade configurar e inicializar uma instância da estrutura Sensor. Esta instância é essencial para o correto funcionamento do sistema, permitindo a leitura de dados provenientes do Coletor de Dados.
## Parâmetro
**Diretorio**  (const char *): Caminho do diretório onde o sensor armazenará informações e realizará operações
## Retorno 
**Sensor** *: Ponteiro para a estrutura Sensor configurada. Em caso de falha, retorna NULL.

Dentro do método, o ficheiro será aberto e analisado, lendo de lá a linha pedida (ignorando as linhas antes desta), e inserindo-a no *array* de *char* previamente mencionado.

Este método irá retornar **-1** se ocorrer algum erro a abrir o ficheiro de Input, e **0** caso não haja nenhum erro.



## Estruturas Utilizadas
Para a configuração da componenete foram utilizadas as seguintes estruturas com os seguintes atributos:

**Buffer_Circular:** 
* int *read: Ponteiro para a posição de leitura do buffer circular. 
* int *write: Ponteiro para a posição de escrita do buffer circular.
* int buffer_size: Tamanho do buffer circular.

**Sensor**:
* Buffer_Circular *buffer: Estrutura do tipo Buffer_Circular associada ao sensor.
* char *type: Tipo do sensor.
* char *unit: unidade de medida do sensor.
* int *medianas: Ponteiro para o array de medianas.
* int sensor_id: Identificador único do sensor.
* int mediana_size: tamanho do array de medianas.
* int timeout: tempo limite para operações do sensor.
* int instante: Instante de leitura do sensor.
* int write_counter: contador de operações de escrita no sensor.

## Passos da Configuração

O metodo aloca primeiramente, de forma dinamica a estrutura Sensor, e as estruturas internas, como Buffer_Circular, strings type e unit, e o array de medianas.
A seguir é validado Diretório, pelo método auxiliar verificarDiretório que verifica a existência do diretório especificado.
Se o diretório não existir, tenta criá-lo com permissões *0777* (leitura, escrita e execução para todos).
Por fim é feita uma configuração adicional onde o metodo inicia o Id (*sensor_id*) do sensor para **1**.



**Observações:**

Em caso de falha durante a alocação de memória ou verificação/criação do diretório, a função libera os recursos alocados e retorna NULL mostrando uma mensagem de insucesso.


