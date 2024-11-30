create or replace NONEDITIONABLE TRIGGER trg_trocar_operacao_id
BEFORE INSERT ON operacao
FOR EACH ROW
DECLARE
    v_id operacao.idOperacao%TYPE;
BEGIN
    SELECT MAX(idOperacao) + 1
    INTO v_id
    FROM operacao;

    IF v_id IS NULL THEN
            v_id := 1;
    END IF;

    :NEW.idOperacao := v_id;
END;
