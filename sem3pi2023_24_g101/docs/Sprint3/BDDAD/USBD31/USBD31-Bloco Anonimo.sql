DECLARE
    vValores ReceitaFatorLista;
    vCursor SYS_REFCURSOR;
    vDesignacao receitaFator.designacaoReceita%TYPE;
    vFatorProducao receitaFator.designacaoFatorProducao%TYPE;
    vQuantidade receitaFator.quantidade%TYPE;
    vUnidade receitaFator.unidade%TYPE;
BEGIN
    vValores := ReceitaFatorLista(
        ReceitaFatorEntrada('EPSO Top', 1, 'kg/ha'),
        ReceitaFatorEntrada('soluSOP 52', 2, 'kg/ha'),
        ReceitaFatorEntrada('Floracal Flow SL', 1, 'l/ha')
    );
    prcd_registarReceitaFertirrega(vValores, 'Receita 13');    
    
    OPEN vCursor FOR
        SELECT designacaoReceita, designacaoFatorProducao, quantidade, unidade
        FROM receitaFator;
    FETCH vCursor INTO vDesignacao, vFatorProducao, vQuantidade, vUnidade;

    WHILE vCursor%FOUND LOOP
        DBMS_OUTPUT.PUT_LINE('Designacao ' || vDesignacao || ', Fator Produção: ' || vFatorProducao || ', Quantidade: ' || vQuantidade || ', Unidade: ' || vUnidade);
        FETCH vCursor INTO vDesignacao, vFatorProducao, vQuantidade, vUnidade;
    END LOOP;
    CLOSE vCursor;
    rollback;
END;
/