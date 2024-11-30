create or replace NONEDITIONABLE PROCEDURE registarAplicacaoFatorProducao(pDesignacaoParcela aplicacaoFitoFarmaco.designacaoParcela%TYPE,
                                                                            pVariedadeCultura aplicacaoFitoFarmaco.variedadeCultura%TYPE,
                                                                            pData aplicacaoFitoFarmaco.data%TYPE,
                                                                            pQuantidade aplicacaoFitoFarmaco.quantidade%TYPE,
                                                                            pDesignacaoFatorProducao aplicacaoFitoFarmaco.designacaoFatorProducao%TYPE,
                                                                            pDataAtual aplicacaoFitoFarmaco.data%TYPE)
AS
BEGIN
    IF(pData <= pDataAtual) THEN
        INSERT INTO aplicacaoFitoFarmaco (designacaoParcela, variedadeCultura, data, quantidade, designacaoFatorProducao)
        VALUES (pDesignacaoParcela, pVariedadeCultura, pData, pQuantidade, pDesignacaoFatorProducao);
    END IF;
END;