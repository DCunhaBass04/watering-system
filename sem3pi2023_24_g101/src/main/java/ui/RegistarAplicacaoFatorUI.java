package ui;

import controller.RegistarAplicacaoFatorController;
import database.DatabaseUtils;
import utils.Utils;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class RegistarAplicacaoFatorUI implements Runnable {
    private final Scanner ler = new Scanner(System.in);
    private final RegistarAplicacaoFatorController ctrl = new RegistarAplicacaoFatorController();

    /**
     * Método principal para a realização desta funcionalidade
     */
    public void run() {
        String fatorProducaoName = insertFatorProducaoName();
        if(fatorProducaoName.isEmpty())
            return;
        float quantidade = Utils.readFloatFromConsole("Insira a quantidade (em kg) do fator de produção usado");
        Float area = inserirArea();
        String parcelaName = insertParcelaName();
        if(parcelaName.isEmpty())
            return;
        LocalDate diaAtual = LocalDate.now(), dia = insertDate(diaAtual);
        boolean eNoSolo = seraNoSolo();
        if(!eNoSolo) {
            String culturaName = insertCulturaName(parcelaName);
            if (culturaName.isEmpty())
                return;
            try {
                String nomeComumCultura = DatabaseUtils.verificarNomeComumCultura(parcelaName, culturaName);
                String modo = inserirModo();
                ctrl.inserirAplicacaoCultura(parcelaName, culturaName, nomeComumCultura, dia, quantidade, area, fatorProducaoName, modo, diaAtual);
                System.out.println("Operação completada com sucesso");
            } catch (SQLException e) {
                System.out.println(DatabaseUtils.mensagemDeErro);
            }
        } else {
            try {
                ctrl.inserirAplicacaoSolo(parcelaName, dia, quantidade, area, fatorProducaoName, diaAtual);
                System.out.println("Operação completada com sucesso");
            } catch (SQLException e) {
                System.out.println(DatabaseUtils.mensagemDeErro);
            }
        }
    }

    /**
     * Método criado para ler o nome da parcela do utilizador
     * @return uma String com o nome da parcela
     */
    private String insertParcelaName() {
        String nomeParcela;
        boolean existe;
        do {
            System.out.printf("Por favor insira o nome da parcela onde o fator de produção foi aplicado%n%s%n", DatabaseUtils.textoDeSaida);
            nomeParcela = ler.nextLine();
            if(nomeParcela.equals("0"))
                return "";
            try {
                existe = DatabaseUtils.verificarParcela(nomeParcela);
            } catch (SQLException e) {
                System.out.println(DatabaseUtils.mensagemDeErro);
                return "";
            }
            if(!existe)
                System.out.println(DatabaseUtils.naoEncontrado);
        } while (!existe);
        return nomeParcela;
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
            System.out.printf("Por favor insira o nome da cultura onde o fator de produção foi aplicado%n%s%n", DatabaseUtils.textoDeSaida);
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
     * Método criado para ler o nome do fator de produção do utilizador, verificando a sua validade
     * @return uma String com o nome do fator de produção
     */
    private String insertFatorProducaoName(){
        String nameFatorProducao;
        boolean existe;
        do {
            System.out.printf("Por favor insira o nome do fator de produção usado%n%s%n", DatabaseUtils.textoDeSaida);
            nameFatorProducao = ler.nextLine();
            if(nameFatorProducao.equals("0"))
                return "";
            try {
                existe = DatabaseUtils.verificarFatorProducao(nameFatorProducao);
            } catch (SQLException e) {
                System.out.println(DatabaseUtils.mensagemDeErro);
                return "";
            }
            if(!existe)
                System.out.println(DatabaseUtils.naoEncontrado);
        } while (!existe);
        return nameFatorProducao;
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
            System.out.println("Insira o dia em que esta aplicação ocorreu");
            dia = Utils.getParsedDate();
            if(!dia.isAfter(diaAtual))
                valid = true;
            else
                System.out.println("Por favor insira um dia anterior ao dia atual");
        } while(!valid);
        return dia;
    }
    private boolean seraNoSolo(){
        boolean eNoSolo = false, valid = false;
        int option;
        do {
            option = Utils.readIntegerFromConsole("Onde foi feita esta aplicação?\n1 - No solo\n2 - Numa cultura");
            switch(option){
                case 1:
                    eNoSolo = true;
                    valid = true;
                    break;
                case 2:
                    valid = true;
                    break;
                default:
                    System.out.println("Por favor insira um valor válido");
                    break;
            }
        }while(!valid);
        return eNoSolo;
    }
    private String inserirModo(){
        String modo = "";
        boolean valid = false;
        int option;
        do {
            option = Utils.readIntegerFromConsole("De que modo foi feita esta aplicação?\n1 - Solo\n2 - Foliar");
            switch(option){
                case 1:
                    modo = "Solo";
                    valid = true;
                    break;
                case 2:
                    modo = "Foliar";
                    valid = true;
                    break;
                default:
                    System.out.println("Por favor insira um valor válido");
                    break;
            }
        }while(!valid);
        return modo;
    }
    private Float inserirArea(){
        Float area = null;
        boolean valid = false;
        int option;
        do {
            option = Utils.readIntegerFromConsole("Deseja inserir a área?\n1 - Sim\n2 - Não");
            switch(option){
                case 1:
                    area = Utils.readFloatFromConsole("Insira o valor da área");
                    valid = true;
                    break;
                case 2:
                    valid = true;
                    break;
                default:
                    System.out.println("Por favor insira um valor válido");
                    break;
            }
        }while(!valid);
        return area;
    }
}
