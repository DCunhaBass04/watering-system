DECLARE
    v_code  NUMBER;
    v_errm  VARCHAR2(200);
BEGIN
    DELETE FROM logOperacao;
    
    EXCEPTION
    WHEN OTHERS THEN
    v_code := SQLCODE;
    v_errm := SUBSTR(SQLERRM, 1, 64);
        DBMS_OUTPUT.PUT_LINE (v_code || ' ' || v_errm);
END;
/