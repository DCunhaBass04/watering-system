package database;

import java.sql.*;
import java.time.LocalDate;
import java.util.Objects;

public class InserirSemeadura {
    /**
     * Método que pede à base de dados para inserir uma nova semeadura, através da função prcd_registarSemeadura
     * @param parcelaName nome da parcela onde a aplicação foi feita
     * @param culturaName nome da cultura onde a aplicação foi feita
     * @param dia dia em que a aplicação foi feita
     * @param quantidade quantidade do fator de produção usado
     * @param unidade unidade em que a quantidade está estabelecida
     * @param diaAtual dia atual no sistema
     * @throws SQLException caso haja algum erro na interação com a base de dados
     */
    public static void inserirSemeaduraOnDatabase(String parcelaName, String culturaName, String nomeComumCultura, LocalDate dia, float quantidade, String unidade, LocalDate diaAtual) throws SQLException {
        CallableStatement callStmt = null;

        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            callStmt = connection.prepareCall("{ call prcd_registarSemeadura(?,?,?,?,?,?,?,?,?) }");

            callStmt.setInt(1, 0);
            callStmt.setString(2,parcelaName);
            callStmt.setString(3,culturaName);
            callStmt.setString(4,nomeComumCultura);
            callStmt.setDate(5, Date.valueOf(dia));
            callStmt.setFloat(6,quantidade);
            callStmt.setString(7,unidade);
            callStmt.setTimestamp(8, Timestamp.valueOf("2019-04-21 14:17:02.0"));
            callStmt.setDate(9,Date.valueOf(diaAtual));

            callStmt.execute();
        } finally {
            if(!Objects.isNull(callStmt)) {
                callStmt.close();
            }
        }
    }
}
