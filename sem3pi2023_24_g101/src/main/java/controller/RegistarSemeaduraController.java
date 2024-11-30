package controller;

import database.InserirSemeadura;

import java.sql.SQLException;
import java.time.LocalDate;

public class RegistarSemeaduraController {
    public void inserirSemeadura(String parcelaName, String culturaName, String nomeComumCultura, LocalDate dia, float quantidade, String unidade, LocalDate diaAtual) throws SQLException {
        InserirSemeadura.inserirSemeaduraOnDatabase(parcelaName,culturaName,nomeComumCultura,dia,quantidade,unidade,diaAtual);
    }
}
