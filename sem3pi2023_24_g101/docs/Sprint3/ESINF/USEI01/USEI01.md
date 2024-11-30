# USEI01 - Construir Rede de Distribuição

**No seguinte documento apresentam-se:**
* Explicação da Resolução
    * Ficheiro exemplo de Input
        * Localidades
        * Distâncias
* Testes Unitários

## Explicação da Resolução

Esta funcionalidade visa ler informações de dois ficheiros diferentes e importar os seus dados para uma rede de distribuição de cabazes, no formato de um grafo.

Primeiro, é pedido do utilizador um ficheiro com os vários locais da rede. Cada local é identificado pelo seu ID e por coordenadas latitude e longitude.

Este tem de ter o formato do ficheiro seguinte: [locais_small.csv](../Data/locais_small.csv)

A seguir, o utilizador terá de inserir um ficheiro com as várias distâncias entre locais. Cada local é identificado pelo seu ID e por coordenadas latitude e longitude. Cada entrada deste ficheiro terá as duas localidades e a distância (em metros) entre elas.

Este tem de ter o formato do ficheiro seguinte: [distancias_small.csv](../Data/distancias_small.csv)

**Nota 1:** Os dois ficheiros inseridos têm obrigatoriamente de ser compatíveis um com o outro. Ou seja, não poderá inserir um ficheiro de distâncias com locais não presentes no ficheiro fornecido para os locais.

Aqui, o programa chama a classe **FileAnalyzer** para ler um ficheiro, fazendo os processos intermédios necessários para devolver um grafo preenchido.

**Nota 2:** Foi escolhido o tipo de grafo **MapGraph** como o grafo usado para a resolução de problemas. Esta decisão foi feita devido à sua eficiência superior em alguns aspetos importantes relativamente à sua alternativa, a **MatrixGraph** (mais informações sobre isto encontram-se no [Relatório](../2DJ_G101_ESINF_Sprint2.pdf)).

A partir deste ponto, o utilizador poderá utilizar este grafo para outras funcionalidades que pretenda utilizar (nomeadamente, as *User Stories* 2 a 5).

## Testes Unitários

De seguida, foi colocado por baixo um documento de texto com as informações relacionadas aos testes unitários criados para esta funcionalidade.

[Testes Unitários](USEI01Tests.md)


