# USLP02 - Ler Um Plano de Rega

**No seguinte documento apresentam-se:**
* Explicação da Resolução
  * Ficheiro exemplo de Input
  * Ficheiro exemplo de Output
* Testes Unitários

## Explicação da Resolução

Aqui, vemos que o processo começa com a interação do utilizador com a UI (User Interface) desenvolvida para a funcionalidade.
Esta pede para o utilizador inserir um ficheiro **.txt** com os detalhes do plano de rega a inserir.

O ficheiro *input* tem de ter o formato deste ficheiro: [USLP02.txt](files/USLP02.txt)

De seguida, o plano de rega criado será enviado para um ficheiro **.csv** com todas as regas pelos 30 dias a partir do atual, cada uma com o dia em que ocorre, duração, setor afetado, hora inicial e hora final.
O nome gerado para este ficheiro será baseado no dia em que esta funcionalidade foi chamada.

O ficheiro *output* terá o formato do ficheiro seguinte: [planorega10112023.csv](files/planorega10112023.csv)

**Nota:** Este ficheiro foi criado no dia 10/11/2023, usando como *input file* o ficheiro mostrado anteriormente.

Para finalizar, a UI pede um dia e hora do utilizador com intenção de ver se há alguma rega ativa nesse instante. 
Para este objetivo, chama o seu Controller. Este atravessa todas as regas até encontrar uma que contenha a data inserida, devolvendo o setor associado e a duração até essa rega terminar.
Caso não seja encontrada nenhuma rega, este devolve *null*. Esta informação é mostrada na saida do programa ("printada") para o utilizador ver.


## Testes Unitários

De seguida, foi colocado por baixo um documento de texto com as informações relacionadas aos testes unitários criados para esta funcionalidade.

[Testes Unitários](USLP02Tests.md)


