## USLP11 - Consumir o plano fertirrega
Como Product Owner, pretendo que seja melhorada
a funcionalidade desenvolvida na USLP03 que, de
forma automática, consume o plano de fertirrega
gerado pelo simulador do controlador desenvolvido 
na USLP10 e que de forma escalonada após a conclusão
da rega e/ou fertirrega em cada sector registe essa
operação no caderno de campo.

## Resolução
Para desenvolver as funcionalidades pedidas nesta US utilizei
o scheduler do Java. A partir do momento em que o utilizador seleciona
a opção para consumir o plano fertirrega o ficheiro que contém o plano é
automaticamente lido, e as fertirregas (ou regas se for o caso)
são planeadas usando o scheduler do Java. Os parâmetros utilizados para 
o scheduler são, obviamente, a ação para inserir a fertirrega na base de dados,
que corresponde ao chamamento de uma função PL/SQL, e a data de início da rega.
Todas estas informações são lidas do plano.

## Depêndencias
* USLP10 - Esta depêndencia é bastante óbvia uma vez que a própria US necessita
do plano gerado na USLP10.
* USBD32 - Também depende desta US de base de dados pois utiliza a função PL/SQL
criada na mesma para inserir a fertirrega ou rega, dependendo da situação.