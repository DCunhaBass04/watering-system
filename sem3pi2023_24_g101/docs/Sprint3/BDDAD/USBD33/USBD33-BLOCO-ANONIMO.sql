--Bloco anonimo USBDADD33

DECLARE
    listaDeCulturasComMaiorConsumo  SYS_REFCURSOR;
    listaDeCulturasComMaiorConsumo_variedadecultura culturaSetor.variedadeCultura%TYPE;
    listaDeCulturasComMaiorConsumo_nomeComumCultura culturaSetor.nomeComumCultura%TYPE;
    listaDeCulturasComMaiorConsumo_designacaoSetor rega.DesignacaoSetor%TYPE;
    listaDeCulturasComMaiorConsumo_quantidade rega.duracaomin%TYPE;
BEGIN
     listaDeCulturasComMaiorConsumo:= fnc_ObterCulturasComMaiorConsumo(2023);
    LOOP
        FETCH listaDeCulturasComMaiorConsumo  INTO listaDeCulturasComMaiorConsumo_variedadecultura, listaDeCulturasComMaiorConsumo_nomeComumCultura, listaDeCulturasComMaiorConsumo_designacaoSetor,listaDeCulturasComMaiorConsumo_quantidade;
        EXIT WHEN listaDeCulturasComMaiorConsumo%NOTFOUND;

        dbms_output.put_line(listaDeCulturasComMaiorConsumo_variedadecultura|| ', ' ||  listaDeCulturasComMaiorConsumo_nomeComumCultura || ', ' || listaDeCulturasComMaiorConsumo_designacaoSetor || ', ' ||listaDeCulturasComMaiorConsumo_quantidade ||' min' );
    END LOOP;
    CLOSE listaDeCulturasComMaiorConsumo;
END;
/