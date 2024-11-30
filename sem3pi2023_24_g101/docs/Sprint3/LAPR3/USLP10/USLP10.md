# USLP10 - Ler Um Plano de Rega e de Fertirrega

**No seguinte documento apresentam-se:**
* Explicação da Resolução
  * Ficheiro exemplo de Input
  * Ficheiros exemplo de Output
* Testes Unitários

## Explicação da Resolução

Aqui, vemos que o processo começa com a interação do utilizador com a UI (User Interface) desenvolvida para a funcionalidade.
Esta pede para o utilizador inserir um ficheiro **.txt** com os detalhes do plano de rega/fertirrega a inserir.

O ficheiro *input* tem de ter o formato deste ficheiro: [USLP10.txt](files/USLP10.txt)

De seguida, o plano de rega e o de fertirrega criados serão enviados para um ficheiro **.csv**, com todas as regas pelos 30 dias a partir do atual, cada uma com o dia em que ocorre, duração, setor afetado, hora inicial e hora final, assim como a receita da fertirrega, se esta ocorre (caso não haja fertirrega, esta coluna irá aparecer com o texto "NULL").
  * Exemplo do ficheiro *output*: [planorega15122023](files/planorega15122023.csv)

Os nomes gerados para estes ficheiros serão baseados no dia em que esta funcionalidade foi chamada.

**Nota:** Estes ficheiros foram criados no dia 15/12/2023, usando como *input file* o ficheiro mostrado anteriormente.

Para finalizar, a UI pede um dia e hora do utilizador com intenção de ver se há alguma rega ativa nesse instante. 
Para este objetivo, chama o seu *Controller*. Este atravessa todas as regas até encontrar uma que contenha a data inserida, devolvendo o setor associado e a duração até essa rega terminar.
Caso não seja encontrada nenhuma rega, este devolve *null*. Esta informação é mostrada na saida do programa ("printada") para o utilizador ver.


## Testes Unitários

De seguida, foi colocado por baixo um documento de texto com as informações relacionadas aos testes unitários criados para esta funcionalidade.

[Testes Unitários](USLP10Tests.md)


