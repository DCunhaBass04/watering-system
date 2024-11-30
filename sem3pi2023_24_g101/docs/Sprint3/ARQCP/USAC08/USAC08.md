# USAC08 - Receber dados do ColetorDeDados

**No seguinte documento apresentam-se:**
* Explicação da Resolução
    * Ficheiro exemplo de Input

## Explicação da Resolução

No meio do algoritmo principal da componente ProcessadorDeDados (verificar [USAC11 algoritmo](../USAC11/USAC11.md)), temos uma funcionalidade para ler a informação vinda da componente anterior, o ColetorDeDados, tornando essa informação útil para o resto do algoritmo principal.

O método desenvolvido recebe o nome do ficheiro de Input como parâmetro, assim como o número da linha a ler nesta chamada do mesmo (se for 2, então este método irá ler a segunda entrada no ficheiro de Input), o *array* de *char* onde a frase será guardada, e um inteiro que representa o tamanho do *array* de *char* (preferencialmente, um número grande).

**Nota:** O ficheiro de Input deverá ter o formato do ficheiro seguinte: [Ficheiro Input](example.txt).

Dentro do método, o ficheiro será aberto e analisado, lendo de lá a linha pedida (ignorando as linhas antes desta), e inserindo-a no *array* de *char* previamente mencionado.

Este método irá retornar **-1** se ocorrer algum erro a abrir o ficheiro de Input, e **0** caso não haja nenhum erro.