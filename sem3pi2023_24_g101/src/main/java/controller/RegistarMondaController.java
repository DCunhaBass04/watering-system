package controller;

import database.InserirMonda;

import java.sql.SQLException;
import java.time.LocalDate;

public final class RegistarMondaController {

    public static void registarMonda(String designacaoParcela, String cultura, String nomeComumCultura, LocalDate data, float quantidade) throws SQLException {
        try {
            InserirMonda.inserirMonda(designacaoParcela, cultura, nomeComumCultura, data, quantidade);
        } catch (SQLException e) {
            throw new RuntimeException("A operação não foi realizada com sucesso, verifique os seus dados.");
        }
    }

}
