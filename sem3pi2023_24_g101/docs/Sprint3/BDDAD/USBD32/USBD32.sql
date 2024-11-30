CREATE OR REPLACE
    PROCEDURE inserir_fertirrega(
    p_designacaosetor rega.designacaosetor%TYPE,
    p_datahora rega.datahora%TYPE,
    p_duracaomin rega.duracaomin%TYPE,
    p_receita receita.designacao%TYPE)
    IS
    l_idoperacao operacao.idoperacao%TYPE;
    c_aplicacoes SYS_REFCURSOR;

    l_designacaoparcela parcela.designacaoparcela%TYPE;
    l_designacaofator receitafator.designacaofatorproducao%TYPE;
    l_quantidade receitafator.quantidade%TYPE;
    l_unidade receitafator.unidade%TYPE;
    l_formato fatorproducao.formato%TYPE;
    l_variedadecultura culturaparcela.variedadecultura%TYPE;
    l_nomecultura culturaparcela.nomecomumcultura%TYPE;

BEGIN
    -- Registar entrada na tabela operacao
    SELECT NVL(MAX(idoperacao), 0) + 1 INTO l_idoperacao FROM operacao;
    INSERT INTO operacao(idoperacao, data, instante, estado)
    VALUES (l_idoperacao, CAST(p_datahora AS DATE), p_datahora, 'Registado');

    -- Registar componente rega
    INSERT INTO rega(idoperacao, designacaosetor, datahora, duracaomin)
    VALUES (l_idoperacao, p_designacaosetor, CAST(p_datahora AS DATE), p_duracaomin);

    -- Registar componente fatores produção
    c_aplicacoes := fnc_obter_aplicacoes_de_receita(p_designacaosetor, p_receita);
    LOOP
        FETCH c_aplicacoes INTO l_designacaoparcela, l_designacaofator, l_quantidade, l_unidade, l_formato, l_variedadecultura, l_nomecultura;
        EXIT WHEN c_aplicacoes%NOTFOUND;

        INSERT INTO aplicacaofatorcultura(idoperacao, designacaoparcela, variedadecultura, nomecomumcultura, modo)
        VALUES (l_idoperacao, l_designacaoparcela, l_variedadecultura, l_nomecultura, l_formato);

        INSERT INTO aplicacaofatorproducao(idoperacao, area)
        VALUES (l_idoperacao, l_quantidade);

        INSERT INTO aplicacaofatorsetor(idoperacao, designacaosetor)
        VALUES (l_idoperacao, p_designacaosetor);

    END LOOP;

END;