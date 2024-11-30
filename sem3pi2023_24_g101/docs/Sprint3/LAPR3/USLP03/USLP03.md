## 1. Descrição da user story
Como Product Owner, pretendo que seja desenvolvida uma funcionalidade que,
de forma automática, consuma o plano de rega gerado pelo simulador do
controlador desenvolvido na USLP02 e que de forma escalonada após a conclusão
da rega em cada sector registe essa operação no caderno de campo.

## 2. Dependências
Esta user story tem uma clara depêndencia com a user story dois de LAPR. Esta última gera o plano de rega
que serve de input para a user story três de LAPR. Ao mesmo tempo, depende de todas as user stories de base
de dados que envolvem o design da própria base de dados, uma vez que a user story comunica com a mesma.

## 3. Classes da user story
* ConsumirPlanoDeRegaController - Esta é a classe controladora da user story. Essencialmente contêm o método
que regista as regas concluídas na base de dados. Isto é, o método usufrui do scheduler do java e quando chamado
planeia o registo das regas na base de dados conforme as datas que estão no plano de rega.
* InserirRegaBaseDeDados - Esta classe representa a tarefa a executar pelo scheduler do java. Neste caso a tarefa
é inserir uma rega na base de dados pelo que a classe chama o método PL/SQL responsável pela inserção de uma rega
na tabela rega.
* PlanoDeRega - O plano de rega que previamente preenchido na user story dois e que serve como input principal a
este user story. Todas as informações relativas à rega a serem inseridas encontram-se nesta classe.

## 4. Explicação da resolução
O itenerário de execução da resolução do problema começa no método da classe ConsumirPlanoDeRegaController.
O método, registarRegasConcluidas, recebe como parâmetro o plano de rega e obtém uma lista das regas presentes
no mesmo. De seguida, percorre a lista e para cada rega, usando o scheduler do java, planeia a inserção da rega na base
de dados de acordo com a data da rega presente no plano de rega. Essa inserção do scheduler recebe como parâmetros
a tarefa a executar e a data de execução dessa tarefa.
Para inserir a rega na base de dados foi necessário criar uma classe que extendesse a classe TimerTask. Esta última
é responsável por identificar uma tarefa que o scheduler do java possa referir. Ou seja a classe que extende TimerTask representa
a tarefa a planear pelo scheduler, neste caso a inserção de uma rega. Essa classe, InserirRegaBaseDeDados, simplesmente chama a função
PL/SQL responsável pela inserção da rega na base de dados. Esta classe é enviada como parâmetro para o scheduler e representa, claramente,
a tarefa a executar.