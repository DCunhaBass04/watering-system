package ui;

import database.InserirFertirregaPlano;
import database.InserirRega;
import domain.Rega;
import domain.Setor;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;

public class ConsumirPlanoFertirregaUI implements Runnable {

    @Override
    public void run() {
        File plano = escolherPlanoFertirrega();
        try {
            inserirFertirregas(plano);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static File escolherPlanoFertirrega() {
        JFrame frame = new JFrame("Escolha o ficheiro do plano fertirrega.");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        } else {
            return null;
        }
    }

    public static void inserirFertirregas(File plano) throws FileNotFoundException, SQLException {
        Scanner scannerPlano = new Scanner(plano);
        scannerPlano.nextLine();
        while (scannerPlano.hasNext()) {
            String[] linhaAtual = scannerPlano.nextLine().split(";");
            if (!linhaAtual[5].equalsIgnoreCase("Null")) {
                String designacaoSetor = linhaAtual[1];
                String receita = linhaAtual[5];
                LocalDate data = LocalDate.parse(linhaAtual[0], DateTimeFormatter.ofPattern("d/M/yyyy"));
                LocalTime hora = LocalTime.parse(linhaAtual[3], DateTimeFormatter.ofPattern("HH:mm"));
                int duracaoMin = Integer.parseInt(linhaAtual[2]);
                LocalDateTime dateTime = LocalDateTime.of(data, hora);
                Instant instant = dateTime.atZone(ZoneId.systemDefault()).toInstant();
                Date schedulerDate = Date.from(instant);
                new Timer().schedule(new InserirFertirregaPlano(designacaoSetor, receita, data, hora, duracaoMin), schedulerDate);
            } else {
                String designacaoSetor = linhaAtual[1];
                LocalDate data = LocalDate.parse(linhaAtual[0], DateTimeFormatter.ofPattern("d/M/yyyy"));
                LocalTime hora = LocalTime.parse(linhaAtual[3], DateTimeFormatter.ofPattern("HH:mm"));
                int duracaoMin = Integer.parseInt(linhaAtual[2]);
                LocalDateTime dateTime = LocalDateTime.of(data, hora);
                Instant instant = dateTime.atZone(ZoneId.systemDefault()).toInstant();
                Date schedulerDate = Date.from(instant);
                Rega regaAInserir = new Rega(data, new Setor(designacaoSetor), duracaoMin, hora);
                new Timer().schedule(new InserirRega(regaAInserir), schedulerDate);
            }
        }
    }
}
