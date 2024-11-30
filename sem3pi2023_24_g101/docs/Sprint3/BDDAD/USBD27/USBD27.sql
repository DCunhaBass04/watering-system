CREATE OR REPLACE TRIGGER trg_no_alter_delete_log
BEFORE UPDATE OR DELETE ON logOperacao
    FOR EACH ROW
BEGIN
    RAISE_APPLICATION_ERROR(-20004, 'Não podes alterar nem eliminar Logs de operações.');
END;
/