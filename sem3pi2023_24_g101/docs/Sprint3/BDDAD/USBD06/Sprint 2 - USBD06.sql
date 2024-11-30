SELECT operacao.exploracaoAgricolaId, COALESCE(operacao.fatorProducaoDesignacao, 'Nenhum') AS "Fator de Produção", COUNT(*) AS "Fatores Aplicados"
FROM operacao
INNER JOIN cultura ON operacao.culturaId = cultura.id
WHERE operacao.data BETWEEN DATE '2021-12-06' AND DATE '2023-08-24'
AND operacao.exploracaoAgricolaId LIKE '104'
GROUP BY operacao.exploracaoAgricolaId, COALESCE(operacao.fatorProducaoDesignacao, 'Nenhum')
ORDER BY COUNT(*) ASC;