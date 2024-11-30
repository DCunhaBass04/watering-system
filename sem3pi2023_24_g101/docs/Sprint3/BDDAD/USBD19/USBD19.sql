
-- USBD19 - Como Gestor Agrícola, pretendo obter a lista de aplicacões de fator de produção aplicados na instalação agrícola, incluindo a parcela e cultura (se aplicável), por tipo de fator de produção, num dado intervalo de tempo.


create or replace noneditionable function ObterAolicacoesFator (pDataInicio fertilizacaoSolo.data%TYPE, pDataFim fertilizacaoSolo.data%TYPE)
return SYS_REFCURSOR 
as
    ObterAolicacoesFator SYS_REFCURSOR;

begin
    open ObterAolicacoesFator for
        select aplicacaofitofarmaco.data, fatorproducao.designacaofatorproducao, fatorproducao.aplicacao, aplicacaofitofarmaco.designacaoparcela, aplicacaofitofarmaco.variedadecultura
        from fatorproducao
        inner join aplicacaoFitofarmaco on fatorproducao.designacaofatorproducao = aplicacaoFitofarmaco.designacaofatorproducao
        where aplicacaofitofarmaco.data between pDataInicio and pDataFim
   
        union all
        
        select fertilizacaocultura.data, fatorproducao.designacaofatorproducao, fatorproducao.aplicacao, fertilizacaocultura.designacaoparcela, fertilizacaocultura.variedadecultura
        from fatorproducao
        inner join fertilizacaocultura on fatorproducao.designacaofatorproducao = fertilizacaocultura.designacaofatorproducao
        where fertilizacaocultura.data between pDataInicio and pDataFim

        union all
        
        select fertilizacaosolo.data, fatorproducao.designacaofatorproducao, fatorproducao.aplicacao, fertilizacaosolo.designacaoparcela, 'Sem cultura' as variedadecultura
        from fatorproducao
        inner join fertilizacaosolo on fatorproducao.designacaofatorproducao = fertilizacaosolo.designacaofatorproducao
        where fertilizacaosolo.data between pDataInicio and pDataFim;

    return ObterAolicacoesFator;
end;   




