package database;

import oracle.jdbc.OracleType;

import java.sql.*;
import java.time.LocalDate;
import java.util.Objects;

public class InserirPoda {
    public static void inserirPodaOnDatabase(String parcelaName, String variedadeCultura, String nomeComumCultura, LocalDate dia, int quantidade, LocalDate diaAtual) throws SQLException {
        CallableStatement callStmt = null;

        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            callStmt = connection.prepareCall("{ call prcd_inserir_poda(?,?,?,?,?,?,?,?) }");

            callStmt.setInt(1, 0);
            callStmt.setString(2,parcelaName);
            callStmt.setString(3,variedadeCultura);
            callStmt.setString(4,nomeComumCultura);
            callStmt.setDate(5, Date.valueOf(dia));
            callStmt.setInt(6,quantidade);
            callStmt.setTimestamp(7, Timestamp.valueOf("2019-04-21 14:17:02.0"));
            callStmt.setDate(8, Date.valueOf(diaAtual));

            callStmt.execute();
        } finally {
            if(!Objects.isNull(callStmt)) {
                callStmt.close();
            }
        }
    }
}
