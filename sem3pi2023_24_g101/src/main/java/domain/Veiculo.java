package domain;

import domain.graph.Edge;
import domain.graph.algorithms.ShortestPathMapGraph;
import domain.graph.map.MapGraph;
import utils.Utils;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class Veiculo {

    private double autonomia;
    private double velocidadeMedia;
    private double tempoMediaCarregamentoBateria;
    private double tempoMediaDescargaCabazes;

    public Veiculo(double autonomia, double velocidadeMedia, double tempoMediaCarregamentoBateria, double tempoMediaDescargaCabazes) {
        this.autonomia = autonomia;
        this.velocidadeMedia = velocidadeMedia;
        this.tempoMediaCarregamentoBateria = tempoMediaCarregamentoBateria;
        this.tempoMediaDescargaCabazes = tempoMediaDescargaCabazes;
    }

    public Veiculo(double autonomia, double velocidadeMedia) {
        this.autonomia = autonomia;
        this.velocidadeMedia = velocidadeMedia;
        this.tempoMediaCarregamentoBateria = 0;
        this.tempoMediaDescargaCabazes = 0;
    }

    public Veiculo(double autonomia) {
        this.autonomia = autonomia;
        velocidadeMedia = 0;
        tempoMediaCarregamentoBateria = 0;
        tempoMediaDescargaCabazes = 0;
    }

    public double getAutonomia() {
        return autonomia;
    }

    public double getAutonomiaMetros() {
        return autonomia * 1000;
    }

    public void setAutonomia(double autonomia) {
        this.autonomia = autonomia;
    }

    public double getVelocidadeMedia() {
        return velocidadeMedia;
    }

    public void setVelocidadeMedia(double velocidadeMedia) {
        this.velocidadeMedia = velocidadeMedia;
    }

    public double getTempoMediaCarregamentoBateria() {
        return tempoMediaCarregamentoBateria;
    }

    public void setTempoMediaCarregamentoBateria(double tempoMediaCarregamentoBateria) {
        this.tempoMediaCarregamentoBateria = tempoMediaCarregamentoBateria;
    }

    public double getTempoMediaDescargaCabazes() {
        return tempoMediaDescargaCabazes;
    }

    public void setTempoMediaDescargaCabazes(double tempoMediaDescargaCabazes) {
        this.tempoMediaDescargaCabazes = tempoMediaDescargaCabazes;
    }

    /**
     * Calcula o percurso minimo de uma rede de distribuicao.
     * @param redeDistribuicao A rede de distribuicao fornecida.
     * @return Percurso com a informação relevante, inclusive pontos de abastecimento.
     */

    public Percurso calcularPercursoMinimo(MapGraph<Localidade, Integer> redeDistribuicao) {
        Point2D.Double[] furthestPoints = Utils.findFurthestPoints(getCoordinates(redeDistribuicao));
        Localidade origem = Localidade.findLocalidadeByCoordinates(redeDistribuicao, furthestPoints[0]);
        Localidade destino = Localidade.findLocalidadeByCoordinates(redeDistribuicao, furthestPoints[1]);
        ShortestPathMapGraph<Localidade, Integer> shortestPathAlgorithm = new ShortestPathMapGraph<>();
        List<Edge<Localidade, Integer>> percursoMinimo = shortestPathAlgorithm.getShortestPath(redeDistribuicao, origem, destino);
        int distanciaTotal = calcularDistanciaTotal(percursoMinimo);
        List<Localidade> locaisCarregamento = calcularLocaisCarregamento(percursoMinimo);
        return new Percurso(origem, destino, distanciaTotal, locaisCarregamento);
    }

    private List<Point2D.Double> getCoordinates(MapGraph<Localidade, Integer> redeDistribuicao) {
        List<Localidade> localidadesList = redeDistribuicao.vertices();
        List<Point2D.Double> points = new ArrayList<>();
        for (Localidade current : localidadesList) {
            points.add(current.getCoords());
        }
        return points;
    }

    private int calcularDistanciaTotal(List<Edge<Localidade, Integer>> percursoMinimo) {
        Integer total = 0;
        for (Edge distancia : percursoMinimo) {
            Integer current = (Integer) distancia.getWeight();
            total += current;
        }
        return total;
    }

    private List<Localidade> calcularLocaisCarregamento(List<Edge<Localidade, Integer>> percursoMinimo) {
        List<Localidade> locaisCarregamento = new ArrayList<>();
        double autonomiaTemp = getAutonomiaMetros();
        for (Edge<Localidade, Integer> distancia : percursoMinimo) {
            if (autonomiaTemp - distancia.getWeight() < 0) {
                locaisCarregamento.add(distancia.getVOrig());
                autonomiaTemp = getAutonomiaMetros();
            } else {
                autonomiaTemp -= getAutonomiaMetros();
            }
        }
        return locaisCarregamento;
    }

}
