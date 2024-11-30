package controller;

import database.DatabaseUtils;
import database.InserirColheita;

import java.sql.SQLException;
import java.time.LocalDate;

public class RegistarColheitaController {
    /**
     * Método intermédio entre a UI e o método que acede à base de dados
     * @param parcelaName nome da parcela onde a colheita foi feita
     * @param produtoAgricolaName nome do produto agrícola colhido
     * @param dia dia em que a colheita foi feita
     * @param quantidade quantidade do produto colhido (em kg)
     * @param diaAtual dia atual no sistema
     * @throws SQLException caso haja algum erro na interação com a base de dados
     */
    public void inserirProdutoAgricola(String parcelaName, String produtoAgricolaName, LocalDate dia, float quantidade, LocalDate diaAtual) throws SQLException {
        InserirColheita.inserirColheitaOnDatabase(parcelaName,produtoAgricolaName,dia,quantidade, diaAtual);
    }

}
