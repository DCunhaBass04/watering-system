package ui;

import controller.RegistarColheitaController;
import database.DatabaseUtils;
import utils.Utils;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class RegistarColheitaUI implements Runnable{
    private final Scanner ler = new Scanner(System.in);
    private final RegistarColheitaController ctrl = new RegistarColheitaController();

    /**
     * Método principal para a realização desta funcionalidade
     */
    public void run() {
        String parcelaName = insertParcelaName();
        if(parcelaName.equals("0"))
            return;
        String produtoAgricolaName = insertProdutoAgricolaName(parcelaName);
        if(produtoAgricolaName.isEmpty())
            return;
        LocalDate diaAtual = LocalDate.now(), dia = insertDate(diaAtual);
        float quantidade = Utils.readFloatFromConsole("Insira a quantidade (em kg) do produto agrícola colhido");
        try {
            ctrl.inserirProdutoAgricola(parcelaName,produtoAgricolaName,dia,quantidade, diaAtual);
            System.out.println("Operação completada com sucesso");
        } catch (SQLException e) {
            System.out.println(DatabaseUtils.mensagemDeErro);
        }
    }
    /**
     * Método criado para ler o nome da parcela do utilizador
     * @return uma String com o nome da parcela
     */
    private String insertParcelaName() {
        System.out.printf("Por favor insira o nome da parcela onde a colheita ocorreu%n%s%n", DatabaseUtils.textoDeSaida);
        return ler.nextLine();
    }
    /**
     * Método criado para ler o nome do produto agrícola do utilizador, verificando a sua validade
     * @param parcelaName nome da parcela onde a cultura estará inserida
     * @return uma String com o nome do produto agrícola
     */
    private String insertProdutoAgricolaName(String parcelaName){
        String nameProdutoAgricola;
        boolean existe;
        do {
            System.out.printf("Por favor insira o nome do produto agrícola colhido%n%s%n", DatabaseUtils.textoDeSaida);
            nameProdutoAgricola = ler.nextLine();
            if(nameProdutoAgricola.equals("0"))
                return "";
            try {
                existe = DatabaseUtils.verificarProdutoAgricolaEParcela(parcelaName, nameProdutoAgricola);
            } catch (SQLException e) {
                System.out.println(DatabaseUtils.mensagemDeErro);
                return "";
            }
            if(!existe)
                System.out.println(DatabaseUtils.naoEncontrado);
        } while (!existe);
        return nameProdutoAgricola;
    }
    /**
     * Método criado para ler a data do utilizador, verificando a sua validade
     * @param diaAtual dia atual (o dia inserido não pode ser posterior a este)
     * @return o objeto LocalDate com o dia inserido
     */
    private LocalDate insertDate(LocalDate diaAtual){
        LocalDate dia;
        boolean valid = false;
        do {
            System.out.println("Insira o dia em que esta colheita ocorreu");
            dia = Utils.getParsedDate();
            if(!dia.isAfter(diaAtual))
                valid = true;
            else
                System.out.println("Por favor insira um dia anterior ao dia atual");
        } while(!valid);
        return dia;
    }
}
