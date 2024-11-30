package ui;

import controller.LerHorariosController;
import domain.Localidade;
import domain.graph.Graph;
import utils.Utils;

import java.io.File;
import java.io.FileNotFoundException;

public class LerHorariosUI {
    public static void run(Graph<Localidade, Integer> graph){
        String horarioPath = Utils.readLineFromConsole("Insira o caminho para o ficheiro dos horários das localidades:");
        try{
            LerHorariosController.lerHorariosDeLocalidades(graph, new File(horarioPath));
        } catch (FileNotFoundException e) {
            System.out.println("Insira um caminho válido.");
        } catch (IllegalArgumentException e){
            System.out.println("O ficheiro inserido não é válido (Tem localidades não presentes no grafo enviado). Insira um ficheiro válido.");
        }
    }
}
