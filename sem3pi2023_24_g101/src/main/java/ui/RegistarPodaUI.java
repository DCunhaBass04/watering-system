package ui;

import controller.RegistarPodaController;
import database.DatabaseUtils;
import utils.Utils;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class RegistarPodaUI implements Runnable {
    private final Scanner ler = new Scanner(System.in);
    private final RegistarPodaController ctrl = new RegistarPodaController();
    public void run() {
        String parcelaName = insertParcelaName();
        if(parcelaName.equals("0"))
            return;
        String culturaName = insertCulturaName(parcelaName);
        if(culturaName.isEmpty())
            return;
        try{
            String nomeComumCultura = DatabaseUtils.verificarNomeComumCultura(parcelaName,culturaName);
            LocalDate diaAtual = LocalDate.now(), dia = insertDate(diaAtual);
            int quantidade = Utils.readIntegerFromConsole("Insira a quantidade de plantas afetas pela poda");
            ctrl.inserirPoda(parcelaName,culturaName,nomeComumCultura,dia,quantidade, diaAtual);
                System.out.println("Operação completada com sucesso");
        } catch (SQLException e) {
            System.out.println(DatabaseUtils.mensagemDeErro);
        }
    }
    private String insertParcelaName() {
        System.out.printf("Por favor insira o nome da parcela onde a poda é feita%n%s%n", DatabaseUtils.textoDeSaida);
        return ler.nextLine();
    }
    private String insertCulturaName(String parcelaName){
        String nameCultura;
        boolean existe;
        do {
            System.out.printf("Por favor insira o nome da cultura onde a poda é feita%n%s%n", DatabaseUtils.textoDeSaida);
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

    private LocalDate insertDate(LocalDate diaAtual){
        LocalDate dia;
        boolean valid = false;
        do {
            System.out.println("Insira o dia em que esta poda ocorreu");
            dia = Utils.getParsedDate();
            if(!dia.isAfter(diaAtual))
                valid = true;
            else
                System.out.println("Por favor insira um dia anterior ao dia atual");
        } while(!valid);
        return dia;
    }
}
