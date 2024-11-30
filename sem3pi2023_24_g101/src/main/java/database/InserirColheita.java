package database;

import oracle.jdbc.OracleType;

import java.sql.*;
import java.time.LocalDate;
import java.util.Objects;

public class InserirColheita {
    /**
     * Método que pede à base de dados para inserir uma nova colheita, através da função registarColheita
     * @param parcelaName nome da parcela onde a colheita foi feita
     * @param produtoName nome do produto agrícola colhido
     * @param dia dia em que a colhida foi feita
     * @param quantidade quantidade do produto agrícola colhido (em kg)
     * @param diaAtual dia atual no sistema
     * @throws SQLException caso haja algum erro na interação com a base de dados
     */
    public static void inserirColheitaOnDatabase(String parcelaName, String produtoName, LocalDate dia, float quantidade, LocalDate diaAtual) throws SQLException {
        CallableStatement callStmt = null;

        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            callStmt = connection.prepareCall("{ call prcd_registarColheita(?,?,?,?,?,?,?) }");

            callStmt.setInt(1, 0);
            callStmt.setString(2,parcelaName);
            callStmt.setString(3,produtoName);
            callStmt.setDate(4, Date.valueOf(dia));
            callStmt.setFloat(5,quantidade);
            callStmt.setTimestamp(6, Timestamp.valueOf("2019-04-21 14:17:02.0"));
            callStmt.setDate(7, Date.valueOf(diaAtual));

            callStmt.execute();
        } finally {
            if(!Objects.isNull(callStmt)) {
                callStmt.close();
            }
        }
    }
}
