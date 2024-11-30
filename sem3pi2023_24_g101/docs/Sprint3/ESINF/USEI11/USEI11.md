# USEI11 - Carregar ficheiro com horários dos hubs

**No seguinte documento apresentam-se:**
* Explicação da Resolução
* Dependências

## Explicação da Resolução

Esta funcionalidade visa atribuir um horário às várias localidades que foram colocadas no grafo. 

É pedido um ficheiro do utilizador como input, que será utilizado pelo programa para este objetivo.

O ficheiro *input* tem de ter o formato deste ficheiro: [USEI11.txt](files/USEI11.txt)

Caso o ficheiro fornecido pelo utilizador não seja válido, a *UI* irá avisar, e as mudanças não serão aplicadas. No caso de sucesso, os horários são aplicados às localidades do grafo, e estas mudanças serão utilizadas em outras USs.

## Dependências

Esta *User Story* tem uma dependência na USEI01, visto que essa é a *User Story* que fornece um grafo preenchido ao resto do programa.