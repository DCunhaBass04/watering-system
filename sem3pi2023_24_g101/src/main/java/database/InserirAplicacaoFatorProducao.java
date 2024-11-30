package database;

import oracle.jdbc.OracleType;

import java.sql.*;
import java.time.LocalDate;
import java.util.Objects;

public class InserirAplicacaoFatorProducao {
    /**
     * Método que pede à base de dados para inserir uma nova aplicação de fator de produção, através da função registarAplicacaoFatorProducao
     * @param parcelaName nome da parcela onde a aplicação foi feita
     * @param culturaName nome da cultura onde a aplicação foi feita
     * @param dia dia em que a aplicação foi feita
     * @param quantidade quantidade do fator de produção usado (em kg)
     * @param fatorProducaoName nome do fator de produção usado
     * @param diaAtual dia atual no sistema
     * @throws SQLException caso haja algum erro na interação com a base de dados
     */
    public static void inserirAplicacaoFatorProducaoCulturaOnDatabase(String parcelaName, String culturaName, String nomeComumCultura, LocalDate dia, float quantidade, Float area, String fatorProducaoName, String modo, LocalDate diaAtual) throws SQLException {
        CallableStatement callStmt = null;

        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            callStmt = connection.prepareCall("{ call prcd_inserir_aplicacao_fator_producao_cultura(?,?,?,?,?,?,?,?,?,?,?) }");

            callStmt.setInt(1, 0);
            callStmt.setString(2,parcelaName);
            callStmt.setString(3,culturaName);
            callStmt.setString(4,nomeComumCultura);
            callStmt.setString(5,modo);
            callStmt.setDate(6, Date.valueOf(dia));
            callStmt.setString(7,fatorProducaoName);
            callStmt.setFloat(8,quantidade);
            if(area != null)
                callStmt.setFloat(9, area);
            else
                callStmt.setNull(9, Types.FLOAT);
            callStmt.setDate(10,Date.valueOf(diaAtual));
            callStmt.setTimestamp(11, Timestamp.valueOf("2019-04-21 14:17:02.0"));

            callStmt.execute();
        } finally {
            if(!Objects.isNull(callStmt)) {
                callStmt.close();
            }
        }
    }
    public static void inserirAplicacaoFatorProducaoSoloOnDatabase(String parcelaName, LocalDate dia, float quantidade, Float area, String fatorProducaoName, LocalDate diaAtual) throws SQLException {
        CallableStatement callStmt = null;

        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            callStmt = connection.prepareCall("{ call prcd_inserir_aplicacao_fator_producao_solo(?,?,?,?,?,?,?,?) }");

            callStmt.setInt(1, 0);
            callStmt.setString(2,parcelaName);
            callStmt.setDate(3, Date.valueOf(dia));
            callStmt.setString(4,fatorProducaoName);
            callStmt.setFloat(5,quantidade);
            if(area != null)
                callStmt.setFloat(6, area);
            else
                callStmt.setNull(6, Types.FLOAT);
            callStmt.setDate(7,Date.valueOf(diaAtual));
            callStmt.setTimestamp(8, Timestamp.valueOf("2019-04-21 14:17:02.0"));

            callStmt.execute();
        } finally {
            if(!Objects.isNull(callStmt)) {
                callStmt.close();
            }
        }
    }
}
