# USLP07 - Registar uma Aplicação de Fator de Produção

**No seguinte documento apresentam-se:**
* Explicação da Resolução
    * Verificações usadas
* Dependências

## Explicação da Resolução

Aqui, vemos que o processo começa com a interação do utilizador com a UI (User Interface) desenvolvida para a funcionalidade.
A UI pede para o utilizador algumas informações relacionadas com a aplicação de fator de produção que este quer inserir no sistema.

Primeiro, é pedido para o utilizador inserir o nome da parcela e o nome da cultura onde esta nova aplicação de fator de produção ocorreu. De seguida, o sistema verifica se os itens inseridos existem. Caso contrário, este processo é repetido. O utilizador pode sair da funcionalidade nesta secção, se este quiser.

De seguida, também é pedido para o utilizador inserir o nome do fator de produção utilizado nesta aplicação, que também é verificado no sistema. O utilizador tem a opção de sair da funcionalidade neste ponto.

A partir daí, o programa lê a quantidade do fator usado, em quilogramas, e a data em que essa operação ocorreu, no formato **DD/MM/YYYY**.

Para finalizar, esta informação é enviada para o método *inserirAplicacaoFatorProducaoOnDatabase*, que por si chama o procedimento *registarAplicacaoFatorProducao* da base de dados, registando-a como uma entrada nova na table "AplicacaoFitoFarmaco".

**Nota:** Como foi mencionado anteriormente, esta funcionalidade implica que haja uma conexão estabelecida com a base de dados, algo que o sistema testa e faz ao abrir o menu onde o utilizador tem acesso à funcionalidade em questão.

Caso não seja encontrado algum erro na base de dados, o utilizador será avisado que a operação pedida foi realizada com sucesso. Caso contrário, será avisado que ocorreu um erro no sistema.


## Dependências

Esta *User Story* apresenta uma dependência na USBD14, visto que, ao invocar a base de dados para registar a nova aplicação de fator de produção, o procedimento chamado é o resultado desta outra *User Story*.
