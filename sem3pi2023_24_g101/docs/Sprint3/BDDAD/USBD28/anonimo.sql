BEGIN
    DELETE FROM operacao WHERE idoperacao = 1;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;


BEGIN
    UPDATE operacao SET estado = 'anulada' WHERE idoperacao = 1;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;