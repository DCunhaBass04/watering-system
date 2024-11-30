BEGIN
    UPDATE operacao SET estado = 'new_value' WHERE idoperacao = 1;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;