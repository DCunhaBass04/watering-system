--US05:
--Como gestor agricola pretendo saber a quantidade de produtos colhidos numa dada parcela
		-- para cada produto em um dados intervalo de tempo

SELECT
    EXPLORACAOAGRICOLA.DESIGNACAO AS "PARCELA",
    SUM(OPERACAO.quantidade) AS "QUANTIDADE DE PRODUTOS (EM KG) COLHIDOS "

    --A UNIDADE É SEMPRE KG NA COLHEITA
FROM
    operacao
INNER JOIN
--Dar join the ambas as tabelas para conseguir ir buscar o id

    EXPLORACAOAGRICOLA ON OPERACAO.EXPLORACAOAGRICOLAID = EXPLORACAOAGRICOLA.ID
WHERE

    LOWER(OPERACAO.tipo) LIKE 'colheita'
    AND OPERACAO.data BETWEEN DATE '2022-08-12' AND DATE '2022-11-6'
    --Isto ou id é igual
    AND EXPLORACAOAGRICOLA.DESIGNACAO like 'Lameiro da ponte'
GROUP BY
    EXPLORACAOAGRICOLA.DESIGNACAO;


    --Testing Done, saved on vs code:






