package controller;

import database.InserirAplicacaoFatorProducao;

import java.sql.SQLException;
import java.time.LocalDate;

public class RegistarAplicacaoFatorController {
    /**
     * Método intermédio entre a UI e o método que acede à base de dados
     * @param parcelaName nome da parcela onde a aplicação foi feita
     * @param culturaName nome da cultura onde a aplicação foi feita
     * @param dia dia em que a aplicação foi feita
     * @param quantidade quantidade do fator de produção usado (em kg)
     * @param fatorProducaoName nome do fator de produção usado
     * @param diaAtual dia atual no sistema
     * @throws SQLException caso haja algum erro na interação com a base de dados
     */
    public void inserirAplicacaoCultura(String parcelaName, String culturaName, String nomeComumCultura, LocalDate dia, float quantidade, Float area, String fatorProducaoName, String modo, LocalDate diaAtual) throws SQLException {
        InserirAplicacaoFatorProducao.inserirAplicacaoFatorProducaoCulturaOnDatabase(parcelaName,culturaName,nomeComumCultura,dia,quantidade,area,fatorProducaoName, modo, diaAtual);
    }
    public void inserirAplicacaoSolo(String parcelaName, LocalDate dia, float quantidade, Float area, String fatorProducaoName, LocalDate diaAtual) throws SQLException {
        InserirAplicacaoFatorProducao.inserirAplicacaoFatorProducaoSoloOnDatabase(parcelaName,dia,quantidade,area,fatorProducaoName,diaAtual);
   }
}
