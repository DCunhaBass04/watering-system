package database;

import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

public final class DatabaseUtils {

    public static final String textoDeSaida = "Pode inserir 0 se quiser sair do método.";
    public static final String mensagemDeErro = "Ocorreu um erro";
    public static final String naoEncontrado = "Por favor insira um nome válido";

    /**
     * Método que pede à base de dados para obter o produto agrícola através do nome da cultura, através da função getProdutoByCulturaName
     * @param culturaName nome da cultura
     * @return nome do produto agrícola
     * @throws SQLException caso haja algum erro na interação com a base de dados
     */
    public static String getProdutoName(String culturaName) throws SQLException {
        CallableStatement callStmt = null;
        String value;

        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            callStmt = connection.prepareCall("{ ? = call getProdutoByCulturaName(?) }");

            callStmt.registerOutParameter(1, OracleTypes.VARCHAR);
            callStmt.setString(2,culturaName);

            callStmt.execute();
            value = (String) callStmt.getObject(1);
        } finally {
            if(!Objects.isNull(callStmt)) {
                callStmt.close();
            }
        }
        return value;
    }

    /**
     * Método que verifica na base de dados se o produto agrícola existe, e se está contido na parcela inserida, através da função verifyProdutoAgricola
     * @param parcelaName nome da parcela
     * @param produtoAgricolaName nome do produto agrícola
     * @return sinal de sucesso (True) ou insucesso (False)
     * @throws SQLException caso haja algum erro na interação com a base de dados
     */
    public static boolean verificarProdutoAgricolaEParcela(String parcelaName, String produtoAgricolaName) throws SQLException {
        CallableStatement callStmt = null;
        boolean value;

        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            callStmt = connection.prepareCall("{ ? = call verifyProdutoAgricola(?,?) }");

            callStmt.registerOutParameter(1, OracleTypes.BOOLEAN);
            callStmt.setString(2,parcelaName);
            callStmt.setString(3,produtoAgricolaName);

            callStmt.execute();
            value = (boolean) callStmt.getObject(1);
        } finally {
            if(!Objects.isNull(callStmt)) {
                callStmt.close();
            }
        }
        return value;
    }
    /**
     * Método que verifica na base de dados se a cultura existe, e se está contida na parcela inserida, através da função verifyCultura
     * @param parcelaName nome da parcela
     * @param culturaName nome da cultura
     * @return sinal de sucesso (True) ou insucesso (False)
     * @throws SQLException caso haja algum erro na interação com a base de dados
     */
    public static boolean verificarCulturaEParcela(String parcelaName, String culturaName) throws SQLException {
        CallableStatement callStmt = null;
        boolean value;

        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
                callStmt = connection.prepareCall("{ ? = call verifyCultura(?,?) }");

            callStmt.registerOutParameter(1, OracleTypes.BOOLEAN);
            callStmt.setString(2,parcelaName);
            callStmt.setString(3,culturaName);

            callStmt.execute();
            value = (boolean) callStmt.getObject(1);
        } finally {
            if(!Objects.isNull(callStmt)) {
                callStmt.close();
            }
        }
        return value;
    }
    /**
     * Método que verifica na base de dados se a parcela existe, através da função verifyParcela
     * @param parcelaName nome da parcela
     * @return sinal de sucesso (True) ou insucesso (False)
     * @throws SQLException caso haja algum erro na interação com a base de dados
     */
    public static boolean verificarParcela(String parcelaName) throws SQLException {
        CallableStatement callStmt = null;
        boolean value;

        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            callStmt = connection.prepareCall("{ ? = call verifyParcela(?) }");

            callStmt.registerOutParameter(1, OracleTypes.BOOLEAN);
            callStmt.setString(2,parcelaName);

            callStmt.execute();
            value = (boolean) callStmt.getObject(1);
        } finally {
            if(!Objects.isNull(callStmt)) {
                callStmt.close();
            }
        }
        return value;
    }

    /**
     * Método que verifica na base de dados se o fator de produção existe, através da função verifyFatorProducao
     * @param fatorProducaoName nome da parcela
     * @return sinal de sucesso (True) ou insucesso (False)
     * @throws SQLException caso haja algum erro na interação com a base de dados
     */
    public static boolean verificarFatorProducao(String fatorProducaoName) throws SQLException {
        CallableStatement callStmt = null;
        boolean value;

        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            callStmt = connection.prepareCall("{ ? = call verifyFatorProducao(?) }");

            callStmt.registerOutParameter(1, OracleTypes.BOOLEAN);
            callStmt.setString(2,fatorProducaoName);

            callStmt.execute();
            value = (boolean) callStmt.getObject(1);
        } finally {
            if(!Objects.isNull(callStmt)) {
                callStmt.close();
            }
        }
        return value;
    }
    /**
     * Método que verifica na base de dados o nome comum da cultura, através da função verifyNomeComumCultura
     * @param designacaoParcela nome da parcela
     * @param variedadeCultura nome da cultura
     * @return nome comum da cultura
     * @throws SQLException caso haja algum erro na interação com a base de dados
     */
    public static String verificarNomeComumCultura(String designacaoParcela, String variedadeCultura) throws SQLException {
        CallableStatement callStmt = null;
        String nome;

        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            callStmt = connection.prepareCall("{ ? = call verifyNomeComumCultura(?,?) }");

            callStmt.registerOutParameter(1, OracleTypes.VARCHAR);
            callStmt.setString(2,designacaoParcela);
            callStmt.setString(3, variedadeCultura);

            callStmt.execute();
            nome = (String) callStmt.getObject(1);
        } finally {
            if(!Objects.isNull(callStmt)) {
                callStmt.close();
            }
        }
        return nome;
    }
}
