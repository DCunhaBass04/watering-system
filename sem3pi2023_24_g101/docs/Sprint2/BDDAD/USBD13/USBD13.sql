create or replace NONEDITIONABLE PROCEDURE registarColheita(pDesignacaoParcela colheita.designacaoParcela%TYPE,
                                                            pProdutoAgricola colheita.produtoAgricola%TYPE,
                                                            pData colheita.data%TYPE,
                                                            pQuantidade colheita.quantidade%TYPE,
                                                            pDataAtual colheita.data%TYPE)
AS
BEGIN
    IF(pData <= pDataAtual) THEN
        INSERT INTO colheita (designacaoParcela, produtoAgricola, data, quantidade)
        VALUES (pDesignacaoParcela, pProdutoAgricola, pData, pQuantidade);
    END IF;
END;