create or replace NONEDITIONABLE FUNCTION totaisRegaMensal(pDataInicio rega.dataInicio%TYPE, pDataFim rega.dataInicio%TYPE)
RETURN SYS_REFCURSOR 
AS
    regasMensais SYS_REFCURSOR;

BEGIN
OPEN regasMensais FOR
SELECT culturaParcela.designacaoParcela,
       TO_CHAR(rega.dataInicio, 'Month') || ' de ' || TO_CHAR(rega.dataInicio, 'YYYY') AS mes_e_ano,
       SUM(rega.duracaoMin)
FROM rega
INNER JOIN culturaParcela ON rega.variedadeCultura LIKE culturaParcela.variedadeCultura
WHERE rega.dataInicio BETWEEN pDataInicio AND pDataFim
GROUP BY culturaParcela.designacaoParcela, TO_CHAR(rega.dataInicio, 'Month'), TO_CHAR(rega.dataInicio, 'YYYY')
ORDER BY culturaParcela.designacaoParcela, TO_CHAR(rega.dataInicio, 'Month'), TO_CHAR(rega.dataInicio, 'YYYY');
RETURN regasMensais;
END;