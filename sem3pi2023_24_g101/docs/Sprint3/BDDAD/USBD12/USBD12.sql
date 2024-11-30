CREATE OR REPLACE FUNCTION INSERIR_MONDA(
    idParcela NUMBER,
    variedadeCultura VARCHAR2,
    data DATE,
    quantidadeHa NUMBER)
    RETURN VARCHAR2 IS insert_status VARCHAR2(20);
BEGIN
    INSERT INTO MONDA (IDPARCELA, MODO, VARIEDADECULTURA, DATA, QUANTIDADE, UNIDADE)
    VALUES (idParcela, modo, variedadeCultura, data, quantidadeHa);
    IF SQL%ROWCOUNT = 1 THEN
        insert_status := 'Success';
    ELSE
        insert_status := 'Error';
    END IF;
    RETURN insert_status;
END INSERIR_MONDA;
/

