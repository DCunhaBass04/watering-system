create or replace noneditionable function ObterProdutosParcela (pParcelaEscolhida parcela.designacaoParcela%TYPE, pDataInicio colheita.data%TYPE, pDataFim colheita.data%TYPE)
return SYS_REFCURSOR 
as
    ObterProdutosParcela SYS_REFCURSOR;

begin
    open ObterProdutosParcela for
        select colheita.designacaoParcela, culturaParcela.variedadeCultura, colheita.produtoAgricola, colheita.data
        from culturaParcela
        inner join colheita on culturaParcela.designacaoParcela = colheita.designacaoParcela
        where culturaParcela.designacaoParcela like pParcelaEscolhida
        and colheita.data > pDataInicio and colheita.data < pDataFim;
    return ObterProdutosParcela;
end;   