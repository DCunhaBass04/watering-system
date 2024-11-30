create or replace noneditionable function ObterFatorParcela (pParcelaEscolhida parcela.designacaoParcela%TYPE, pDataInicio fertilizacaoSolo.data%TYPE, pDataFim fertilizacaoSolo.data%TYPE)
return SYS_REFCURSOR 
as
    ObterFatoresParcela SYS_REFCURSOR;

begin
    open ObterFatoresParcela FOR
        select aplicacaofitofarmaco.designacaoParcela, aplicacaofitofarmaco.designacaoFatorProducao, aplicacaofitofarmaco.quantidade, aplicacaofitofarmaco.data 
        from aplicacaofitofarmaco
        where aplicacaofitofarmaco.designacaoParcela LIKE pParcelaEscolhida
        and aplicacaofitofarmaco.data between pDataInicio AND pDataFim

        union all

        select fertilizacaoSolo.designacaoParcela, fertilizacaoSolo.designacaoFatorProducao, fertilizacaoSolo.quantidade, fertilizacaoSolo.data
        from fertilizacaoSolo
        where fertilizacaoSolo.designacaoParcela like pParcelaEscolhida
        and fertilizacaoSolo.data between pDataInicio AND pDataFim

        union all

        select fertilizacaoCultura.designacaoParcela, fertilizacaoCultura.designacaoFatorProducao, fertilizacaoCultura.quantidade, fertilizacaoCultura.data 
        from fertilizacaoCultura
        where fertilizacaoCultura.designacaoParcela LIKE pParcelaEscolhida
        and fertilizacaoCultura.data between pDataInicio AND pDataFim;

    return ObterFatoresParcela;
end;   

  --