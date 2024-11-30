# USAC05 - Encontrar a Mediana

**No seguinte documento apresentam-se:**
* Explicação da Resolução
    * Ficheiro exemplo de Output
* Testes Unitários

## Explicação da Resolução

No menu de *arrays*, o utilizador tem a possibilidade de escolher esta funcionalidade. Desta forma, o *array* atualmente carregado no sistema será enviado para a compontente ***ProcessadorDeDados*** para este calcular a sua mediana.

A partir daqui, o ***ProcessadorDeDados*** irá ordenar o *array* e devolver a sua posição central.

**Nota:** Caso o *array* tenha um número par de elementos, é considerada como "mediana" o elemento na posição n/2 (n sendo o tamanho do *array*).

Depois disto, o resultado será enviado para a componente ***SaidaDeDados***, que irá colocar o *array* e a sua mediana num ficheiro de texto chamado "mediana.txt".

O ficheiro *output* terá o formato do ficheiro seguinte: [mediana.txt](files/mediana.txt)

## Testes Unitários

De seguida, foi colocado por baixo um documento de texto com as informações relacionadas aos testes unitários criados para esta funcionalidade.

[Testes Unitários](USAC05Tests.md)


