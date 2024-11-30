-- USBD31 Como Gestor Agrıcola, pretendo registar uma receita de fertirrega para usar em operaçoes de rega
create or replace NONEDITIONABLE PROCEDURE prcd_registarReceitaFertirrega(receita_a_registar ReceitaFatorLista, 
                                                                        pDesignacao receita.designacao%TYPE) 
AS
    vDesignacaoFatorProducao receitaFator.designacaoFatorProducao%TYPE;
    vQuantidade              receitaFator.quantidade%TYPE;
    vUnidade                 receitaFator.unidade%TYPE;
BEGIN
    INSERT INTO receita (designacao)
    VALUES (pDesignacao);
    FOR i IN 1..receita_a_registar.COUNT LOOP
        vDesignacaoFatorProducao := receita_a_registar(i).designacaoFatorProducao;
        vQuantidade := receita_a_registar(i).quantidade;
        vUnidade := receita_a_registar(i).unidade;
    
        INSERT INTO receitafator (designacaoReceita, designacaoFatorProducao, quantidade, unidade)
        VALUES (pDesignacao, vDesignacaoFatorProducao, vQuantidade, vUnidade);
    END LOOP;
END;
