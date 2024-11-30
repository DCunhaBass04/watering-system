# USAC10 - Serialização da informação armazenada

**No seguinte documento apresenta-se:**
* Explicação da Resolução

## Explicação da Resolução

No meio do algoritmo principal da componente ProcessadorDeDados (verificar [USAC11 algoritmo](../USAC11/USAC11.md)), temos uma funcionalidade para tornar um objeto do tipo *Sensor* num *array* de *char*, de forma a ser serializada, no seguinte formato:

* Formato: sensor_id,write_counter,type,unit,mediana#
* Exemplos:
  * 1,1,soil_humidity,percentage,2160#
  * 3,1,atmospheric_humidity,percentage,error#
  * 4,1,atmospheric_humidity,percentage,2000#

O método desenvolvido recebe um apontador para o objeto *Sensor* como parâmetro, assim como o *array* de *char* onde a frase será guardada.

A partir daí, o método vê os elementos do *Sensor* enviado, colocando-o no formato pedido, vendo se este está numa situação de erro (a diferença entre o instante do último registo e o instante actual é superior ao valor do timeout.)