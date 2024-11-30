# USAC01 - Extrair Informação do Token

**No seguinte documento apresentam-se:**
* Explicação da Resolução
    * Ficheiro exemplo de Output
* Testes Unitários

## Explicação da Resolução

No menu de *fazerExtract*, o utilizador tem a possibilidade de escolher o Token. Desta forma, o *token* atualmente carregado no sistema será enviado para a compontente ***ProcessadorDeDados*** para este extrair a informação do token.

A partir daqui, o ***ProcessadorDeDados*** irá ordenar a *string* e devolver a informação após o *token*.

**Nota:** A informação vai dos ":" até ao próximo "#" ou "/0".

Depois disto, o resultado será enviado para a componente ***SaidaDeDados***, que irá colocar o *output* num ficheiro de texto chamado "extractedToken.txt".

O ficheiro *output* terá o formato do ficheiro seguinte: [extractedToken.txt](files/extractedToken.txt)

## Testes Unitários

De seguida, foi colocado por baixo um documento de texto com as informações relacionadas aos testes unitários criados para esta funcionalidade.

[Testes Unitários](USAC01Tests.md)


