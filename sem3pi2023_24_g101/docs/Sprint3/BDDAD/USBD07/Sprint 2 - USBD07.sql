--US07:
--Como gestor agricula pretendo saber o numero de operaçoes realizado em uma dada parcela para cada


SELECT
    EXPLORACAOAGRICOLA.DESIGNACAO AS "PARCELA",
    operacao.tipo,
    COUNT(operacao.ID) as "NÚMERO DE OPERAÇÕES REALIZADAS NA PARCELA EM CERTA DATA"
FROM
    operacao
JOIN
--Dar join the ambas as tabelas para conseguir ir buscar o id

    EXPLORACAOAGRICOLA ON OPERACAO.EXPLORACAOAGRICOLAID = EXPLORACAOAGRICOLA.ID
WHERE
    operacao.data BETWEEN DATE '2016-10-6' AND DATE '2023-01-12'
    AND EXPLORACAOAGRICOLA.DESIGNACAO like 'Lameiro da ponte'
GROUP BY
   	EXPLORACAOAGRICOLA.DESIGNACAO,
    operacao.tipo
order by COUNT(operacao.ID) ;


    --Testing Done, sabed on vs code: