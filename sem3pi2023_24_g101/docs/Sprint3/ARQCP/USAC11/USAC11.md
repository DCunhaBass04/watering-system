# USAC11 -Algoritmo de Processador de Dados

**No seguinte documento apresentam-se:**
  * Configuração inicial
  * Leitura de sensores
  * Cálculo da mediana
  * Serialização das informações
  * Criação do arquivo de saída
  * Observações

## Algoritmo principal

O componente ProcessadorDeDados opera ciclicamente e executa as seguintes etapas:

**Configuração Inicial:**
  - Inicializa dinamicamente os sensores com base no arquivo de configuração.
  - Lida com falhas na configuração, saindo do programa se necessário.

**Leitura de Sensores:**
  - Realiza a leitura dos dados dos sensores do arquivo especificado.
  - Extrai parâmetros da linha lida para cada sensor.
  - Incrementa o contador de leitura.

**Cálculo da Mediana:**
  - Para cada sensor, calcula a mediana dos valores lidos.
  - Incrementa o contador de escrita.
**Serialização das Informações:**
  - Para cada sensor, serializa as informações, preparando-as para escrita.

**Criação do Arquivo de Saída:**
  - Cria um arquivo com informações de todos os sensores.
  - Utiliza um formato de nomeação baseado na data e hora: 'AAAAMMDDHHMMSS_sensors.txt'.

O algoritmo opera em um loop infinito, aguardando um intervalo de 2 segundos entre cada iteração. Certifique-se de implementar mecanismos adequados para encerrar o programa quando necessário.

O código faz uso de diversas funções, como `configurarComponente`, `lerLinhaSensor`, `extractParameters`, `calcularMediana`, `serializarSensor`, entre outras. Certifique-se de que essas funções estão implementadas corretamente e que os arquivos de cabeçalho estão incluídos conforme necessário.

**Observações:**
Não foram realizadas quaisqueres testes unitários para esta user Storie.