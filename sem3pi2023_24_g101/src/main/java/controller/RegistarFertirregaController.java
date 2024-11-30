package controller;

import database.InserirFertirrega;

import java.sql.SQLException;
import java.time.LocalTime;

public final class RegistarFertirregaController {

    private static RegistarFertirregaController instance;

    private RegistarFertirregaController() {

    }

    public static RegistarFertirregaController getInstance() {
        if (instance == null) {
            instance = new RegistarFertirregaController();
        }
        return instance;
    }

    public void registarFertirrega(String designacaoSetor, String receitaFertirrega, LocalTime hora, int duracaoMin) throws SQLException {
        InserirFertirrega.inserirFertirrega(designacaoSetor, receitaFertirrega, hora, duracaoMin);
    }
}
