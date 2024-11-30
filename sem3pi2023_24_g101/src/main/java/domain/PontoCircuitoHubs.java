package domain;

import java.time.LocalTime;

public class PontoCircuitoHubs {
    private final Localidade local;
    private final int duracaoDeChegada, duracaoDeCarregamento, duracaoDeDescarregamento;
    private final int distancia;
    private final int numColabs;
    public PontoCircuitoHubs(Localidade local, int duracaoDeChegada, int distancia){
        this.local = local;
        this.duracaoDeChegada = duracaoDeChegada;
        this.distancia = distancia;
        duracaoDeCarregamento = 0;
        duracaoDeDescarregamento = 0;
        if(local.isHub())
            numColabs = Integer.parseInt(local.getId().substring(3));
        else
            numColabs = -1;
    }
    public PontoCircuitoHubs(int duracaoDeCarregamento, Localidade local, int duracaoDeChegada, int distancia){
        this.local = local;
        this.duracaoDeChegada = duracaoDeChegada;
        this.distancia = distancia;
        this.duracaoDeCarregamento = duracaoDeCarregamento;
        duracaoDeDescarregamento = 0;
        if(local.isHub())
            numColabs = Integer.parseInt(local.getId().substring(3));
        else
            numColabs = -1;
    }
    public PontoCircuitoHubs(Localidade local, int duracaoDeChegada, int duracaoDeDescarregamento, int distancia){
        this.local = local;
        this.duracaoDeChegada = duracaoDeChegada;
        this.distancia = distancia;
        duracaoDeCarregamento = 0;
        this.duracaoDeDescarregamento = duracaoDeDescarregamento;
        if(local.isHub())
            numColabs = Integer.parseInt(local.getId().substring(2));
        else
            numColabs = -1;
    }
    public PontoCircuitoHubs(int duracaoDeCarregamento, Localidade local, int duracaoDeChegada, int duracaoDeDescarregamento, int distancia){
        this.local = local;
        this.duracaoDeChegada = duracaoDeChegada;
        this.distancia = distancia;
        this.duracaoDeCarregamento = duracaoDeCarregamento;
        this.duracaoDeDescarregamento = duracaoDeDescarregamento;
        if(local.isHub())
            numColabs = Integer.parseInt(local.getId().substring(3));
        else
            numColabs = -1;
    }
    public Localidade getLocal() {return local;}
    public int getDistancia() {return distancia;}
    public int getDuracaoDeChegada() {return duracaoDeChegada;}
    public int getDuracaoDeCarregamento() {return duracaoDeCarregamento;}
    public int getDuracaoDeDescarregamento() {return duracaoDeDescarregamento;}
    public int getNumColabs() {return numColabs;}

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Ponto: %s%n-Duração até Chegada: %s minutos%n", local.getId(), duracaoDeChegada));
        if(local.isHub()) {
            stringBuilder.append(String.format("-Duração até Saída: %s minutos%n", (duracaoDeCarregamento+duracaoDeDescarregamento)));
            stringBuilder.append(String.format("Número de colaboradores: %s%n", numColabs));
        }
        stringBuilder.append("Distância do ponto anterior: ").append(distancia).append(" metros");
        return stringBuilder.toString();
    }
}
