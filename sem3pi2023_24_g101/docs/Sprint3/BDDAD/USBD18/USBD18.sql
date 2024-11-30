create or replace noneditionable function "OBTER_OPERACOES_PARCELA"
(parcelaEscolhida PARCELA.designacaoParcela%TYPE, pDataInicio fertilizacaoSolo.data%TYPE, pDataFim fertilizacaoSolo.data%TYPE)
    return SYS_REFCURSOR as operacoesParcela SYS_REFCURSOR;
begin
    open operacoesParcela for
        select poda.data, 'Poda' as OPERACAO, poda.designacaoparcela, poda.quantidade, 'kg' as unidade, null as DURACAOMIN
        from poda
        where poda.designacaoparcela = parcelaEscolhida
        and poda.data between pDataInicio and pDataFim

        union all

        select colheita.data, 'Colheita' as OPERACAO, colheita.designacaoparcela, colheita.quantidade, 'kg' as unidade, null as DURACAOMIN
        from colheita
        where colheita.designacaoparcela = parcelaEscolhida
        and colheita.data between pDataInicio and pDataFim

        union all

        select monda.data, 'Monda' as OPERACAO, monda.designacaoparcela, monda.quantidade, 'kg' as unidade, null as DURACAOMIN
        from monda
        where monda.designacaoparcela = parcelaEscolhida
        and monda.data between pDataInicio and pDataFim

        union all

        select plantacao.data, 'Plantacao' as OPERACAO, plantacao.designacaoparcela, plantacao.quantidade, 'kg' as unidade, null as DURACAOMIN
        from plantacao
        where plantacao.designacaoparcela = parcelaEscolhida
        and plantacao.data between pDataInicio and pDataFim

        union all

        select incorporacaosolo.data, 'Incorporacao Solo' as OPERACAO, incorporacaosolo.designacaoparcela, incorporacaosolo.quantidade, 'kg' as unidade, null as DURACAOMIN
        from incorporacaosolo
        where incorporacaosolo.designacaoparcela = parcelaEscolhida
        and incorporacaosolo.data between pDataInicio and pDataFim

        union all

        select fertilizacaocultura.data, 'Fertilizacao Cultura' as OPERACAO, fertilizacaocultura.designacaoparcela, fertilizacaocultura.quantidade, 'kg' as unidade, null as DURACAOMIN
        from fertilizacaocultura
        where fertilizacaocultura.designacaoparcela = parcelaEscolhida
        and fertilizacaocultura.data between pDataInicio and pDataFim

        union all

        select aplicacaofitofarmaco.data, 'Aplicacao Fitofarmaco' as OPERACAO, aplicacaofitofarmaco.designacaoparcela, aplicacaofitofarmaco.quantidade, 'kg' as unidade, null as DURACAOMIN
        from aplicacaofitofarmaco
        where aplicacaofitofarmaco.designacaoparcela = parcelaEscolhida
        and aplicacaofitofarmaco.data between pDataInicio and pDataFim

        union all

        select fertilizacaosolo.data, 'Fertilizacao Solo' as OPERACAO, fertilizacaosolo.designacaoparcela, fertilizacaosolo.quantidade, 'kg' as unidade, null as DURACAOMIN
        from fertilizacaosolo
        where fertilizacaosolo.designacaoparcela = parcelaEscolhida
        and fertilizacaosolo.data between pDataInicio and pDataFim

        union all

        select semeadura.data, 'Semeadura' as OPERACAO, semeadura.designacaoparcela, semeadura.quantidade, semeadura.unidade, null as DURACAOMIN
        from semeadura
        where semeadura.designacaoparcela = parcelaEscolhida
        and semeadura.data between pDataInicio and pDataFim

        union all

        select rega.datainicio, 'Rega' as OPERACAO, culturaparcela.designacaoparcela, rega.quantidade, 'kg' as unidade, rega.duracaomin
        from rega
        inner join culturaparcela on rega.variedadecultura = culturaparcela.variedadecultura
        where culturaparcela.designacaoparcela = parcelaEscolhida
        and rega.datainicio between pDataInicio and pDataFim;
    return operacoesParcela;
end;