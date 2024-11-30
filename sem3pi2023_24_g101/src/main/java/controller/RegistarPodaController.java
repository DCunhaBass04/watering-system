package controller;

import java.sql.SQLException;
import java.time.LocalDate;

import static database.InserirPoda.inserirPodaOnDatabase;

public class RegistarPodaController {
    public void inserirPoda(String parcelaName, String culturaName, String nomeComumCultura, LocalDate dia, int quantidade, LocalDate diaAtual) throws SQLException {
        inserirPodaOnDatabase(parcelaName,culturaName,nomeComumCultura,dia,quantidade, diaAtual);
    }
}
