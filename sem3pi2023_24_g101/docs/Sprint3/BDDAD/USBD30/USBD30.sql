CREATE OR REPLACE TRIGGER trg_alter_operacoes
BEFORE UPDATE ON operacao
    FOR EACH ROW
DECLARE
    v_days_difference NUMBER;
BEGIN
    v_days_difference := SYSDATE - :OLD.data;

    IF v_days_difference > 3 THEN
        RAISE_APPLICATION_ERROR(-20004, 'Não podes anular operações com mais de 3 dias.');
    END IF;
END;
/