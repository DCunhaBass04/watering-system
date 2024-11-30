package database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Objects;

public final class InserirMonda {

    private InserirMonda() {

    }
    public static void inserirMonda(String designacaoParcela, String variedadeCultura, String nomeComumCultura, LocalDate data, float quantidade) throws SQLException {
        CallableStatement callStatement = null;
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            callStatement = connection.prepareCall("{ call prcd_inserir_monda(?,?,?,?,?,?,?,?) }");

            callStatement.setInt(1, 0);
            callStatement.setString(2, designacaoParcela);
            callStatement.setString(3, variedadeCultura);
            callStatement.setString(4, nomeComumCultura);
            callStatement.setDate(5, java.sql.Date.valueOf(data));
            callStatement.setFloat(6, quantidade);
            callStatement.setTimestamp(7, Timestamp.valueOf("2019-04-21 14:17:02.0"));
            callStatement.setDate(8, java.sql.Date.valueOf(LocalDate.now()));

            callStatement.execute();
        } finally {
            if(!Objects.isNull(callStatement)) {
                callStatement.close();
            }
        }
    }
}
