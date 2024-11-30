package controller;

import domain.Localidade;
import domain.graph.Graph;
import utils.FileAnalyzer;

import java.io.File;
import java.io.FileNotFoundException;

public class LerHorariosController {
    public static void lerHorariosDeLocalidades(Graph<Localidade, Integer> graph, File horarios) throws FileNotFoundException {
        FileAnalyzer.readHorarios(graph, horarios);
    }
}
