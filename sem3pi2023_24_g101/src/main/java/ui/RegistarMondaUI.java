package ui;

import controller.RegistarMondaController;
import database.DatabaseUtils;
import utils.Utils;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RegistarMondaUI implements Runnable {

    private final Scanner ler = new Scanner(System.in);

    @Override
    public void run() {
        String designacaoParcela = insertParcelaName();
        if(designacaoParcela.equals("0"))
            return;
        String variedadeCultura = insertCulturaName(designacaoParcela);
        if(variedadeCultura.isEmpty())
            return;
        try{
            String nomeComumCultura = DatabaseUtils.verificarNomeComumCultura(designacaoParcela, variedadeCultura);
            LocalDate diaMonda = insertDate(LocalDate.now());
            float quantidade = inserirQuantidade();
            RegistarMondaController.registarMonda(designacaoParcela, variedadeCultura, nomeComumCultura, diaMonda, quantidade);
            System.out.println("Operação completada com sucesso");
        } catch (SQLException e) {
            System.out.println(DatabaseUtils.mensagemDeErro);
        }

    }

    private String insertParcelaName() {
        System.out.printf("Por favor insira o nome da parcela onde quer realizar a monda%n%s%n", DatabaseUtils.textoDeSaida);
        return ler.nextLine();
    }

    private String insertCulturaName(String parcelaName) {
        String nameCultura;
        boolean existe;
        do {
            System.out.printf("Por favor insira o nome da cultura a realizar a monda%n%s%n", DatabaseUtils.textoDeSaida);
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
            System.out.println("Insira o dia em que esta operacao ocorreu");
            dia = Utils.getParsedDate();
            if(!dia.isAfter(diaAtual))
                valid = true;
            else
                System.out.println("Por favor insira um dia anterior ao dia atual");
        } while(!valid);
        return dia;
    }

    private float inserirQuantidade() {
        float quantidade = 0;
        boolean valid = false;
        do {
            try {
                quantidade = Utils.readFloatFromConsole("Insira quantidade de monda a realizar: ");
                if (quantidade > 0) {
                    valid = true;
                } else {
                    System.out.println("Quantidade tem de ser maior que zero!");
                    ler.nextLine();
                }

            } catch (InputMismatchException e) {
                System.out.println("Quantidade inválida insira um valor válido!");
                ler.nextLine();
            }
        } while (!valid);
        return quantidade;
    }
}
