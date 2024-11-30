--US10: Como Gestor Agrícola, pretendo saber qual a parcela com mais operações de rega num dado intervalo de tempo
--Com SUBQUERIES

-- Selecionar o nome da parcela da tabela EXPLORACAOAGRICOLA
SELECT EXPLORACAOAGRICOLA.DESIGNACAO AS "PARCELA"
FROM OPERACAO
JOIN EXPLORACAOAGRICOLA  ON OPERACAO.EXPLORACAOAGRICOLAID = EXPLORACAOAGRICOLA.ID

WHERE LOWER(OPERACAO.TIPO) LIKE 'rega'
--Filtrar peloa Id e tipo ,que resultado pede
GROUP BY EXPLORACAOAGRICOLA.DESIGNACAO,OPERACAO.TIPO

HAVING COUNT(OPERACAO.ID) = (
    -- Subquerie para sacar  o numero o maximo de operaçoes para o tipo escolhido .
    SELECT MAX(cnt)
    FROM (
        SELECT EXPLORACAOAGRICOLA.DESIGNACAO, COUNT(OPERACAO.ID) AS cnt
        FROM OPERACAO
    --Join necessario também pois preciso desnigaçao aqui tambem
        JOIN EXPLORACAOAGRICOLA ON OPERACAO.EXPLORACAOAGRICOLAID = EXPLORACAOAGRICOLA.ID
    -- Tipo rega dado no exercicio e data escolhida pelo utilizador
        WHERE LOWER(OPERACAO.TIPO) LIKE 'rega'
        AND OPERACAO.data BETWEEN DATE '2016-10-06' AND DATE '2023-01-12'
        GROUP BY EXPLORACAOAGRICOLA.DESIGNACAO
    )
);
 --Testing Done,Only one test failed sabed on vs code.: