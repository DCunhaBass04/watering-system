package database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public final class InserirFertirrega {

    private InserirFertirrega() {

    }


    public static void inserirFertirrega(String designacaoSetor, String receitaFertirrega, LocalTime hora, int duracaoMin) throws SQLException {
        CallableStatement callStatement = null;
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            callStatement = connection.prepareCall("{ call INSERIR_FERTIRREGA(?,?,?,?,?) }");
            callStatement.setString(1, designacaoSetor);
            callStatement.setString(2, receitaFertirrega);
            // TODO: Transformar em LocalDateTime
            LocalDateTime dataHora = LocalDateTime.of(LocalDate.now(), hora);
            callStatement.setTimestamp(3, Timestamp.valueOf(dataHora)); // Inserido pelo utilizador
            callStatement.setInt(4, duracaoMin);
            callStatement.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now())); // Automatico pelo sistema
            callStatement.execute();
        } finally {
            if(!Objects.isNull(callStatement)) {
                callStatement.close();
            }
        }
    }

}
