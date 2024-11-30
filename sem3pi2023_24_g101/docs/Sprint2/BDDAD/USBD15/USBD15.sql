create or replace NONEDITIONABLE FUNCTION registerPoda(pDesignacaoParcela poda.designacaoParcela%TYPE, pVariedadeCultura poda.variedadeCultura%TYPE,
                                                            pData poda.data%TYPE, pQuantidade poda.quantidade%TYPE, pDataAtual poda.data%TYPE)
RETURN BOOLEAN AS
insert_status BOOLEAN;
BEGIN
    IF pData <= pDataAtual THEN
        INSERT INTO poda (designacaoParcela, variedadeCultura, data, quantidade)
        VALUES (pDesignacaoParcela, pVariedadeCultura, pData, pQuantidade);
        insert_status := TRUE;
ELSE
        insert_status := FALSE;
END IF;

RETURN insert_status;
END;