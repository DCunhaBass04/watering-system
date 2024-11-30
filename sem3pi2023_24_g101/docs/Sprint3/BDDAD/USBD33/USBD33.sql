 --USBD33 Como Gestor Agrícola, pretendo obter a lista das culturas com maior consumo de  ́agua (rega) para um dado ano civil. O consumo  ́e em minutos e, em caso de empate, devem ser dadas todas essas culturas.


CREATE OR REPLACE NONEDITIONABLE FUNCTION fnc_ObterCulturasComMaiorConsumo (pAnoCivil Integer)
RETURN SYS_REFCURSOR 
AS
    culturasComMaiorConsumo SYS_REFCURSOR;
BEGIN
    OPEN culturasComMaiorConsumo FOR
        SELECT variedadecultura, nomecomumcultura, subconsulta.designacaoSetor, subconsulta.QuantidadeRega
        FROM (
            SELECT designacaoSetor, SUM(DuracaoMin) as QuantidadeRega,
                MAX(SUM(DuracaoMin)) OVER () as MaxQuantidadeRega
            FROM rega
            WHERE pAnoCivil = TO_CHAR(rega.dataHora, 'YYYY')
            GROUP BY designacaoSetor
        ) subconsulta
        INNER JOIN CulturaSetor ON subconsulta.designacaoSetor = CulturaSetor.designacaoSetor
        WHERE subconsulta.QuantidadeRega = subconsulta.MaxQuantidadeRega;

    RETURN culturasComMaiorConsumo;
END;
/
