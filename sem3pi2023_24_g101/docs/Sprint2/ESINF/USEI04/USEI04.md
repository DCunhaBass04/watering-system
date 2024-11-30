# USEI04 - Determinar a rede de todas as localidades com menor distância. 

**No seguinte documento apresentam-se:**
* Explicação da Resolução
  * Localidades
  * Distâncias
  * Algoritmo de Kruskal
* Dependências
* Testes Unitários

## Explicação da Resolução

A User Story **USEI04** visa determinar a rede de distribuição que conecta todas as localidades com a menor distância total possível _(Minimum Spanning Tree)._ 
Para tal, a interface do programa solicita ao utilizador que escolha dois arquivos: um contendo as informações sobre as localidades:
(Por exemplo: [locais_small.csv](../Data/locais_small.csv) ou [locais_big.csv](../Data/locais_big.csv)) 
e outro contendo as distâncias entre essas localidades:
(Por exmeplo: [distancias_small.csv](../Data/distancias_small.csv) ou [distancias_big.csv](../Data/distancias_big.csv)).

A rede com menor custo é calculada a partir do **_algoritmo de Kruskal_**, em que, as localidades são intepretadas para o âmbito da resolução do exercício como vértices, e as distâncias como arestas.

O progama comunica o resultado a interface e esta mostra ao utlizador,a árvore geradora de menor custo, os seus vertices, arestas e custo (distância) total.
## Dependências:

Esta *User Story* (USEI04) depende da **USEI01**, dado que, usa a informação lida nos ficheiros a cima como grafo inicial para a sua implementação.
## Testes Unitários

Por fim, foi colocado por baixo um documento de texto com as informações relacionadas aos testes unitários criados para esta funcionalidade.

[Testes Unitários](USEI04Tests.md)


