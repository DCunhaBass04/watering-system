CREATE OR REPLACE TRIGGER trg_no_alter_delete_operacoes
BEFORE UPDATE OR DELETE ON operacao
    FOR EACH ROW
DECLARE
    vData operacao.data%TYPE;
    vInstante operacao.instante%TYPE;
BEGIN
    IF UPDATING THEN
        INSERT INTO logOperacao(idOperacao, tipoOperacao, tipoLog, data, instante, designacaoSetor, designacaoFatorProducao, variedadeCultura, nomeComumCultura, produtoAgricola, quantidade, unidade, duracao)
        VALUES (:NEW.idOperacao, ' ', 'anulação', vData, vInstante, null, null, null, null, null, null, 'kg', null);
    END IF;

    IF DELETING THEN
        RAISE_APPLICATION_ERROR(-20004, 'Não podes eliminar operações.');
    END IF;
END;