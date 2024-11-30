package database;

import domain.Rega;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;
import java.util.TimerTask;

import static java.time.LocalDate.now;

/** USLP03 */

public class InserirRega extends TimerTask {

    private final Rega rega;

    public InserirRega(Rega rega) {
        this.rega = rega;
    }

    @Override
    public void run() {
        try {
            inserirRega(rega.getDia(), rega.getSetorRega().getDesignacao(), rega.getDuration(), rega.getHoraInicial());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void inserirRega(LocalDate dataRega, String designacaoSetor, int duracao, LocalTime horaInicial) throws SQLException {
        CallableStatement callStatement = null;
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            callStatement = connection.prepareCall("{ call INSERIR_REGA(?,?,?) }");
            callStatement.setString(1, designacaoSetor);
            callStatement.setTimestamp(2, Timestamp.valueOf(LocalDateTime.of(dataRega, horaInicial)));
            callStatement.setInt(3, duracao);
            callStatement.execute();
            connection.commit();
        } finally {
            if(!Objects.isNull(callStatement)) {
                callStatement.close();
            }
        }
    }
}
