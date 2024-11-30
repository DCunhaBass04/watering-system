create or replace NONEDITIONABLE TRIGGER trg_trocar_operacao_instante
BEFORE INSERT ON operacao
FOR EACH ROW
BEGIN
    :NEW.instante := SYSTIMESTAMP;
END;