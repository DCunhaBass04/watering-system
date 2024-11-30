# USLP06 - Registar uma Colheita

**No seguinte documento apresentam-se:**
* Explicação da Resolução
    * Verificações usadas
* Dependências

## Explicação da Resolução

Aqui, vemos que o processo começa com a interação do utilizador com a UI (User Interface) desenvolvida para a funcionalidade.
A UI pede para o utilizador algumas informações relacionadas com a colheita que este quer inserir no sistema.

Primeiro, é pedido para o utilizador inserir o nome da parcela e o nome da cultura onde esta nova colheita ocorreu. De seguida, o sistema verifica se os itens inseridos existem. Caso contrário, este processo é repetido. O utilizador pode sair da funcionalidade nesta secção, se este quiser.

A partir daí, o programa lê a quantidade do produto agrícola colhido, em quilogramas, e a data em que essa colheita ocorreu, no formato **DD/MM/YYYY**.

Para finalizar, esta informação é enviada para o método *inserirColheitaOnDatabase*, que por si chama o procedimento *registerColheita* da base de dados, registando-a como uma entrada nova na table "Colheita".

**Nota:** Como foi mencionado anteriormente, esta funcionalidade implica que haja uma conexão estabelecida com a base de dados, algo que o sistema testa e faz ao abrir o menu onde o utilizador tem acesso à funcionalidade em questão.

Caso não seja encontrado algum erro na base de dados, o utilizador será avisado que a operação pedida foi realizada com sucesso. Caso contrário, será avisado que ocorreu um erro no sistema.

## Dependências

Esta *User Story* apresenta uma dependência na USBD13, visto que, ao invocar a base de dados para registar a nova colheita, o procedimento chamado é o resultado desta outra *User Story*.
