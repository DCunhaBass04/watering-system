package ui;

import controller.RegistarSemeaduraController;
import database.DatabaseUtils;
import utils.Utils;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class RegistarSemeaduraUI implements Runnable{
    private final Scanner ler = new Scanner(System.in);
    private final RegistarSemeaduraController ctrl = new RegistarSemeaduraController();

    /**
     * Método principal para a realização desta funcionalidade
     */
    public void run() {
        String parcelaName = insertParcelaName();
        if(parcelaName.equals("0"))
            return;
        String culturaName = insertCulturaName(parcelaName);
        if(culturaName.isEmpty())
            return;
        try {
            String nomeComum = DatabaseUtils.verificarNomeComumCultura(parcelaName, culturaName);
            LocalDate diaAtual = LocalDate.now(), dia = insertDate(diaAtual);
            String unidade = inserirUnidade();
            float quantidade = Utils.readFloatFromConsole(String.format("Insira a quantidade (em %s) da semente inserida", unidade));
            ctrl.inserirSemeadura(parcelaName,culturaName,nomeComum,dia,quantidade,unidade,diaAtual);
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
        System.out.printf("Por favor insira o nome da parcela onde a semeadura ocorreu%n%s%n", DatabaseUtils.textoDeSaida);
        return ler.nextLine();
    }
    /**
     * Método criado para ler o nome da cultura do utilizador, verificando a sua validade
     * @param parcelaName nome da parcela onde a cultura estará inserida
     * @return uma String com o nome da cultura
     */
    private String insertCulturaName(String parcelaName){
        String nameCultura;
        boolean existe;
        do {
            System.out.printf("Por favor insira o nome da cultura onde a semeadura ocorreu%n%s%n", DatabaseUtils.textoDeSaida);
            nameCultura = ler.nextLine();
            if(nameCultura.equals("0"))
                return "";
            try {
                existe = DatabaseUtils.verificarCulturaEParcela(parcelaName, nameCultura);
            } catch (SQLException e) {
                System.out.println(DatabaseUtils.mensagemDeErro);
                return "";
            }
            if(!existe)
                System.out.println(DatabaseUtils.naoEncontrado);
        } while (!existe);
        return nameCultura;
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
            System.out.println("Insira o dia em que esta semeadura ocorreu");
            dia = Utils.getParsedDate();
            if(!dia.isAfter(diaAtual))
                valid = true;
            else
                System.out.println("Por favor insira um dia anterior ao dia atual");
        } while(!valid);
        return dia;
    }
    private String inserirUnidade(){
        boolean valid = false;
        String unidade = "";
        int option;
        do {
            option = Utils.readIntegerFromConsole(String.format("Escolha a unidade que quer usar para esta semeadura:%n1 - ha%n2 - kg%n"));
            switch (option) {
                case 1:
                    unidade = "ha";
                    valid = true;
                    break;
                case 2:
                    unidade = "kg";
                    valid = true;
                    break;
            }
        } while (!valid);
        return unidade;
    }
}
