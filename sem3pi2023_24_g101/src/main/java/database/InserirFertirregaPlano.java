package database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;
import java.util.TimerTask;

public final class InserirFertirregaPlano extends TimerTask {

    private String designacaoSetor;
    private String receita;
    private LocalDate data;
    private LocalTime hora;
    private int duracaoMin;

    public InserirFertirregaPlano(String designacaoSetor, String receita, LocalDate data, LocalTime hora, int duracaoMin) {
        this.designacaoSetor = designacaoSetor;
        this.receita = receita;
        this.data = data;
        this.hora = hora;
        this.duracaoMin = duracaoMin;
    }

    @Override
    public void run() {
        try {
            inserirFertirregaDePlano(designacaoSetor, receita, data, hora, duracaoMin);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void inserirFertirregaDePlano(String designacaoSetor, String receita, LocalDate data, LocalTime hora, int duracaoMin) throws SQLException {
        CallableStatement callStatement = null;
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            callStatement = connection.prepareCall("{ call INSERIR_FERTIRREGA(?,?,?,?) }");
            callStatement.setString(1, designacaoSetor);
            LocalDateTime timestamp = LocalDateTime.of(data, hora);
            callStatement.setTimestamp(2, Timestamp.valueOf(timestamp));
            callStatement.setInt(3, duracaoMin);
            callStatement.setString(4, receita);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(!Objects.isNull(callStatement)) {
                callStatement.close();
            }
        }
    }
}
