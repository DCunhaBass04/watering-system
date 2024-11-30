-- USBD11: Como Gestor Agrıcola, quero registar uma operação de semeadura

create or replace NONEDITIONABLE PROCEDURE prcd_registarSemeadura(pDesignacaoParcela semeadura.designacaoParcela%TYPE,
                                                            pVariedadeCultura semeadura.variedadeCultura%TYPE, 
                                                            pData semeadura.data%TYPE, 
                                                            pQuantidade semeadura.quantidade%TYPE, 
                                                            pUnidade semeadura.unidade%TYPE,
                                                            pDataAtual semeadura.data%Type)
AS
BEGIN
    IF pData <= pDataAtual THEN
        INSERT INTO semeadura (designacaoParcela, variedadeCultura, data, quantidade,unidade)
        VALUES (pDesignacaoParcela, pVariedadeCultura, pData, pQuantidade,pUnidade);
    END IF;
END;


