# USEI02 - Obter Hubs

**No seguinte documento apresentam-se:**
* Explicação da Resolução
* Dependências
* Testes Unitários

## Explicação da Resolução

Esta funcionalidade visa obter os vértices ideais para a localização de N hubs, de modo a otimizar a rede de distribuição segundo diferentes os seguintes critérios:
* Influência: vértices com maior grau
* Proximidade: vértices mais próximos dos restantes vértices
* Centralidade: vértices com maior número de caminhos mínimos que passam por eles.

Pretende-se devolver todas as localidades e os seus respetivos critérios, ordenados por ordem decrescente de centralidade e influência.

Para este objetivo, calculamos a influência, proximidade e centralidade de todos os vértices (Locais) do grafo. Isto é feito através dos métodos *getInfluencia*, *getProximidade* e *getCentralidade* da classe *CriteriaAlgorithm*.

Cada entrada de localidade com os seus critérios é colocada numa *TreeMap*, sendo automaticamente ordenada na inserção devido à natureza dessa classe.

Após isto ser feito para todos os locais, todos os itens dessa *TreeMap* exceto os n primeiros são removidos. Esta *TreeMap* é retornada para o utilizador.

Por fim, a *UI* mostra, para cada item, o local e os seus critérios.

## Dependências

Esta *User Story* tem uma dependência na USEI01, visto que essa é a *User Story* que fornece um grafo preenchido ao resto do programa.

## Testes Unitários

De seguida, foi colocado por baixo um documento de texto com as informações relacionadas aos testes unitários criados para esta funcionalidade.

[Testes Unitários](USEI02Tests.md)


