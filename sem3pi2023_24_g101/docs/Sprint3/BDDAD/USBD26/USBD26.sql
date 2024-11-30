CREATE OR REPLACE TRIGGER trg_create_aplicacaofitofarmaco_log
AFTER INSERT OR UPDATE ON aplicacaofitofarmaco
FOR EACH ROW
DECLARE
    vData operacao.data%TYPE;
    vInstante operacao.instante%TYPE;
BEGIN
    SELECT data, instante
    INTO vData, vInstante
    FROM operacao
    WHERE idOperacao = :NEW.idOperacao;
    IF INSERTING OR (UPDATING AND :OLD.idOperacao IS NULL) THEN
        INSERT INTO logOperacao(idOperacao, tipoOperacao, tipoLog, data, instante, designacaoSetor, designacaoFatorProducao, variedadeCultura, nomeComumCultura, produtoAgricola, quantidade, unidade, duracao)
        VALUES (:NEW.idOperacao, 'Aplicacaofitofarmaco', 'criação', vData, vInstante, null, :NEW.designacaoFatorProducao, null, null, null, :NEW.quantidadekg, 'kg', null);
    ELSIF UPDATING THEN
        INSERT INTO logOperacao(idOperacao, tipoOperacao, tipoLog, data, instante, designacaoSetor, designacaoFatorProducao, variedadeCultura, nomeComumCultura, produtoAgricola, quantidade, unidade, duracao)
        VALUES (:NEW.idOperacao, 'Aplicacaofitofarmaco', 'alteração', vData, vInstante, null, :NEW.designacaoFatorProducao, null, null, null, :NEW.quantidadekg, 'kg', null);    
    END IF;
END;
/


CREATE OR REPLACE TRIGGER trg_create_incorporacaosolo_log
AFTER INSERT OR UPDATE ON incorporacaosolo
FOR EACH ROW
DECLARE
    vData operacao.data%TYPE;
    vInstante operacao.instante%TYPE;
BEGIN
    SELECT data, instante
    INTO vData, vInstante
    FROM operacao
    WHERE idOperacao = :NEW.idOperacao;
    IF INSERTING OR (UPDATING AND :OLD.idOperacao IS NULL) THEN
        INSERT INTO logOperacao(idOperacao, tipoOperacao, tipoLog, data, instante, designacaoSetor, designacaoParcela, variedadeCultura, nomeComumCultura, produtoAgricola, quantidade, unidade, duracao)
        VALUES (:NEW.idOperacao, 'Aplicacaofitofarmaco', 'criação', vData, vInstante, null, :NEW.designacaoParcela, null, null, null, :NEW.quantidade, 'kg', null);
    ELSIF UPDATING THEN
        INSERT INTO logOperacao(idOperacao, tipoOperacao, tipoLog, data, instante, designacaoSetor, designacaoParcela, variedadeCultura, nomeComumCultura, produtoAgricola, quantidade, unidade, duracao)
        VALUES (:NEW.idOperacao, 'Aplicacaofitofarmaco', 'alteração', vData, vInstante, null, :NEW.designacaoParcela, null, null, null, :NEW.quantidade, 'kg', null);    
    END IF;
END;
/


CREATE OR REPLACE TRIGGER trg_create_incorporacaosolo_log
AFTER INSERT OR UPDATE ON incorporacaosolo
FOR EACH ROW
DECLARE
    vData operacao.data%TYPE;
    vInstante operacao.instante%TYPE;
BEGIN
    SELECT data, instante
    INTO vData, vInstante
    FROM operacao
    WHERE idOperacao = :NEW.idOperacao;
    IF INSERTING OR (UPDATING AND :OLD.idOperacao IS NULL) THEN
        INSERT INTO logOperacao(idOperacao, tipoOperacao, tipoLog, data, instante, designacaoSetor, designacaoParcela, variedadeCultura, nomeComumCultura, produtoAgricola, quantidade, unidade, duracao)
        VALUES (:NEW.idOperacao, 'Aplicacaofitofarmaco', 'criação', vData, vInstante, null, :NEW.designacaoParcela, null, null, null, :NEW.quantidade, 'kg', null);
    ELSIF UPDATING THEN
        INSERT INTO logOperacao(idOperacao, tipoOperacao, tipoLog, data, instante, designacaoSetor, designacaoParcela, variedadeCultura, nomeComumCultura, produtoAgricola, quantidade, unidade, duracao)
        VALUES (:NEW.idOperacao, 'Aplicacaofitofarmaco', 'alteração', vData, vInstante, null, :NEW.designacaoParcela, null, null, null, :NEW.quantidade, 'kg', null);    
    END IF;
END;
/


CREATE OR REPLACE TRIGGER trg_create_monda_log
AFTER INSERT OR UPDATE ON monda
FOR EACH ROW
DECLARE
    vData operacao.data%TYPE;
    vInstante operacao.instante%TYPE;
BEGIN
    SELECT data, instante
    INTO vData, vInstante
    FROM operacao
    WHERE idOperacao = :NEW.idOperacao;
    IF INSERTING OR (UPDATING AND :OLD.idOperacao IS NULL) THEN
        INSERT INTO logOperacao(idOperacao, tipoOperacao, tipoLog, data, instante, designacaoSetor, designacaoParcela, variedadeCultura, nomeComumCultura, produtoAgricola, quantidade, unidade, duracao)
        VALUES (:NEW.idOperacao, 'Aplicacaofitofarmaco', 'criação', vData, vInstante, null, :NEW.designacaoParcela, null, null, null, :NEW.quantidade, 'kg', null);
    ELSIF UPDATING THEN
        INSERT INTO logOperacao(idOperacao, tipoOperacao, tipoLog, data, instante, designacaoSetor, designacaoParcela, variedadeCultura, nomeComumCultura, produtoAgricola, quantidade, unidade, duracao)
        VALUES (:NEW.idOperacao, 'Aplicacaofitofarmaco', 'alteração', vData, vInstante, null, :NEW.designacaoParcela, null, null, null, :NEW.quantidade, 'kg', null);    
    END IF;
END;
/


CREATE OR REPLACE TRIGGER trg_create_monda_log
AFTER INSERT OR UPDATE ON monda
FOR EACH ROW
DECLARE
    vData operacao.data%TYPE;
    vInstante operacao.instante%TYPE;
BEGIN
    SELECT data, instante
    INTO vData, vInstante
    FROM operacao
    WHERE idOperacao = :NEW.idOperacao;
    IF INSERTING OR (UPDATING AND :OLD.idOperacao IS NULL) THEN
        INSERT INTO logOperacao(idOperacao, tipoOperacao, tipoLog, data, instante, designacaoSetor, designacaoParcela, variedadeCultura, nomeComumCultura, produtoAgricola, quantidade, unidade, duracao)
        VALUES (:NEW.idOperacao, 'Aplicacaofitofarmaco', 'criação', vData, vInstante, null, :NEW.designacaoParcela, null, null, null, :NEW.quantidade, 'kg', null);
    ELSIF UPDATING THEN
        INSERT INTO logOperacao(idOperacao, tipoOperacao, tipoLog, data, instante, designacaoSetor, designacaoParcela, variedadeCultura, nomeComumCultura, produtoAgricola, quantidade, unidade, duracao)
        VALUES (:NEW.idOperacao, 'Aplicacaofitofarmaco', 'alteração', vData, vInstante, null, :NEW.designacaoParcela, null, null, null, :NEW.quantidade, 'kg', null);    
    END IF;
END;
/


CREATE OR REPLACE TRIGGER trg_create_plantacao_log
AFTER INSERT OR UPDATE ON plantacao
FOR EACH ROW
DECLARE
    vData operacao.data%TYPE;
    vInstante operacao.instante%TYPE;
BEGIN
    SELECT data, instante
    INTO vData, vInstante
    FROM operacao
    WHERE idOperacao = :NEW.idOperacao;
    IF INSERTING OR (UPDATING AND :OLD.idOperacao IS NULL) THEN
        INSERT INTO logOperacao(idOperacao, tipoOperacao, tipoLog, data, instante, designacaoSetor, designacaoParcela, variedadeCultura, nomeComumCultura, produtoAgricola, quantidade, unidade, duracao)
        VALUES (:NEW.idOperacao, 'Aplicacaofitofarmaco', 'criação', vData, vInstante, null, :NEW.designacaoParcela, null, null, null, :NEW.quantidade, 'kg', null);
    ELSIF UPDATING THEN
        INSERT INTO logOperacao(idOperacao, tipoOperacao, tipoLog, data, instante, designacaoSetor, designacaoParcela, variedadeCultura, nomeComumCultura, produtoAgricola, quantidade, unidade, duracao)
        VALUES (:NEW.idOperacao, 'Aplicacaofitofarmaco', 'alteração', vData, vInstante, null, :NEW.designacaoParcela, null, null, null, :NEW.quantidade, 'kg', null);    
    END IF;
END;
/


CREATE OR REPLACE TRIGGER trg_create_poda_log
AFTER INSERT OR UPDATE ON poda
FOR EACH ROW
DECLARE
    vData operacao.data%TYPE;
    vInstante operacao.instante%TYPE;
BEGIN
    SELECT data, instante
    INTO vData, vInstante
    FROM operacao
    WHERE idOperacao = :NEW.idOperacao;
    IF INSERTING OR (UPDATING AND :OLD.idOperacao IS NULL) THEN
        INSERT INTO logOperacao(idOperacao, tipoOperacao, tipoLog, data, instante, designacaoSetor, designacaoParcela, variedadeCultura, nomeComumCultura, produtoAgricola, quantidade, unidade, duracao)
        VALUES (:NEW.idOperacao, 'Aplicacaofitofarmaco', 'criação', vData, vInstante, null, :NEW.designacaoParcela, null, null, null, :NEW.quantidade, 'kg', null);
    ELSIF UPDATING THEN
        INSERT INTO logOperacao(idOperacao, tipoOperacao, tipoLog, data, instante, designacaoSetor, designacaoParcela, variedadeCultura, nomeComumCultura, produtoAgricola, quantidade, unidade, duracao)
        VALUES (:NEW.idOperacao, 'Aplicacaofitofarmaco', 'alteração', vData, vInstante, null, :NEW.designacaoParcela, null, null, null, :NEW.quantidade, 'kg', null);    
    END IF;
END;
/


CREATE OR REPLACE TRIGGER trg_create_semeadura_log
AFTER INSERT OR UPDATE ON semeadura
FOR EACH ROW
DECLARE
    vData operacao.data%TYPE;
    vInstante operacao.instante%TYPE;
BEGIN
    SELECT data, instante
    INTO vData, vInstante
    FROM operacao
    WHERE idOperacao = :NEW.idOperacao;
    IF INSERTING OR (UPDATING AND :OLD.idOperacao IS NULL) THEN
        INSERT INTO logOperacao(idOperacao, tipoOperacao, tipoLog, data, instante, designacaoSetor, designacaoParcela, variedadeCultura, nomeComumCultura, produtoAgricola, quantidade, unidade, duracao)
        VALUES (:NEW.idOperacao, 'Aplicacaofitofarmaco', 'criação', vData, vInstante, null, :NEW.designacaoParcela, null, null, null, :NEW.quantidade, 'kg', null);
    ELSIF UPDATING THEN
        INSERT INTO logOperacao(idOperacao, tipoOperacao, tipoLog, data, instante, designacaoSetor, designacaoParcela, variedadeCultura, nomeComumCultura, produtoAgricola, quantidade, unidade, duracao)
        VALUES (:NEW.idOperacao, 'Aplicacaofitofarmaco', 'alteração', vData, vInstante, null, :NEW.designacaoParcela, null, null, null, :NEW.quantidade, 'kg', null);    
    END IF;
END;
/