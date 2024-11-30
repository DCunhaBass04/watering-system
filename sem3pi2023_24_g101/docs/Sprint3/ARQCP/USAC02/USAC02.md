# USAC02 - Inserir um valor em um buffer Circular

**No seguinte documento apresentam-se:**
* Explicação da Resolução
    * Ficheiro exemplo de Output
* Testes Unitários

## Explicação da Resolução
 
No menu de *arrays*, o utilizador tem a possibilidade de escolher esta funcionalidade. Desta forma, o *array* atualmente carregado no sistema será enviado para a compontente ***ProcessadorDeDados*** para que este possa inserir o valor em um array com características específicas.

O array é considero um **buffer circular** ,ao seja, uma estrutura em que o último elemento (fim em um array normal) se conecta ao primeiro (inicio em um array normal) tornando assim o array cíclico (circular) sem ínicio ou fim.
O array contém um tamanho fixo e dois apontadores: de leitura: _read_ e escrita _write_.
O apontador _write_ será a posição de inserção do array escolhido pelo utilizador.
O apontador _read_ irá, neste caso, indicar o número de elementos removidos do **Buffer**.

A partir de este ponto, o ***ProcessadorDeDados*** irá inserir o valor escolhido pelo utlizador no  **array** e devolver um buffer circular com o elemento inserido na posição escolhida.

Sempre que é inserido um valor o apontador write avança um valor, e, sempre que esse valor for igual ao valor atual do apontador read,o valor do apontador read avançara também.

Para melhor compreensão ver exemplo do ficheiro a baixo: *Write operation.txt*.

Por fim, o resultado será enviado para a componente ***SaidaDeDados***, que irá colocar o *Buffer Circular* com ambos os apontadores num ficheiro de texto chamado "Write operation.txt".

O ficheiro *output* terá o formato do ficheiro seguinte: [Write operation.txt](files/Write%20operation.txt)

## Testes Unitários

Por fim, foi colocado por baixo um documento de texto com as informações relacionadas aos testes unitários criados para esta funcionalidade.

[Testes Unitários](USAC02Tests.md)


