CREATE OR REPLACE
    FUNCTION fnc_obter_aplicacoes_de_receita(
    p_designacaosetor setor.designacaosetor%TYPE,
    p_receita receita.designacao%TYPE)
    RETURN SYS_REFCURSOR AS c_aplicacoes SYS_REFCURSOR;
BEGIN
    OPEN c_aplicacoes FOR
        SELECT parcelasetor.designacaoparcela,
               receitafator.designacaofatorproducao, receitafator.quantidade, receitafator.unidade,
               fatorproducao.formato,
               culturaparcela.variedadecultura, culturaparcela.nomecomumcultura
        FROM parcelasetor
                 INNER JOIN receitafator ON (designacaoreceita = p_receita)
                 INNER JOIN fatorproducao ON (receitafator.designacaofatorproducao = fatorproducao.designacaofatorproducao)
                 INNER JOIN culturaparcela ON (parcelasetor.designacaoparcela = culturaparcela.designacaoparcela)
        WHERE (designacaosetor = p_designacaosetor);
    RETURN c_aplicacoes;
END;