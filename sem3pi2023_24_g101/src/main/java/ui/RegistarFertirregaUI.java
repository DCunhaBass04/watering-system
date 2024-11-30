package ui;

import controller.RegistarFertirregaController;
import utils.Utils;

import java.sql.SQLException;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public final class RegistarFertirregaUI implements Runnable {

    private final RegistarFertirregaController ctrl = RegistarFertirregaController.getInstance();

    private static final String ERROR_MESSAGE_A = "Esse não é um formato válido, insira de novo.";


    @Override
    public void run() {
        try {
            ctrl.registarFertirrega(designacaoSetor(), receitaFertirrega(), hora(), duracao());
            System.out.println("Fertirrega registada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Ocorreu um erro com o registo da fertirrega, verifique novamente os dados.");
        }
    }

    private static String designacaoSetor() {
        Scanner in = new Scanner(System.in);
        System.out.println("Introduza o nome do setor onde a fertirrega ocorre (formato Setor X): ");
        boolean valid = false;
        String designacaoSetor = null;
        do {
            try {
                designacaoSetor = in.next();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println(ERROR_MESSAGE_A);
                in.next();
            }
        } while (!valid);
        return designacaoSetor;
    }

    private static String receitaFertirrega() {
        Scanner in = new Scanner(System.in);
        System.out.println("Introduza o nome da receita da fertirrega (formato Receita X): ");
        boolean valid = false;
        String receitaFertirrega = null;
        do {
            try {
                receitaFertirrega = in.next();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println(ERROR_MESSAGE_A);
                in.next();
            }
        } while (!valid);
        return receitaFertirrega;
    }

    private static LocalTime hora() {
        Scanner in = new Scanner(System.in);
        return Utils.inputTime(in);
    }

    private static int duracao() {
        Scanner in = new Scanner(System.in);
        System.out.println("Introduza a duração da fertirrega em minutos: ");
        boolean isValid = false;
        int duracao = 0;
        do {
            try {
                duracao = in.nextInt();
                isValid = true;
            } catch (InputMismatchException e) {
                System.out.print(ERROR_MESSAGE_A);
                in.next();
            }
        } while (!isValid);
        return duracao;
    }

}
