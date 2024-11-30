package domain;

import domain.graph.Edge;

import java.util.List;

public class Percurso {
    private Localidade origem;
    private Localidade destino;
    private double distanciaTotal;
    private List<Localidade> locaisCarregamento;

    public Percurso(Localidade origem, Localidade destino, double distanciaTotal, List<Localidade> locaisCarregamento) {
        this.origem = origem;
        this.destino = destino;
        this.distanciaTotal = distanciaTotal;
        this.locaisCarregamento = locaisCarregamento;
    }

    public Localidade getOrigem() {
        return origem;
    }

    public void setOrigem(Localidade origem) {
        this.origem = origem;
    }

    public Localidade getDestino() {
        return destino;
    }

    public void setDestino(Localidade destino) {
        this.destino = destino;
    }

    public double getDistanciaTotal() {
        return distanciaTotal;
    }

    public void setDistanciaTotal(double distanciaTotal) {
        this.distanciaTotal = distanciaTotal;
    }

    public List<Localidade> getLocaisCarregamento() {
        return locaisCarregamento;
    }

    public void setLocaisCarregamento(List<Localidade> locaisCarregamento) {
        this.locaisCarregamento = locaisCarregamento;
    }
}
