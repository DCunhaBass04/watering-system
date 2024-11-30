package domain;

import java.time.LocalTime;

public class PontoPercursoHubs {
    private final Localidade local;
    private final LocalTime horaDeChegada;
    private final LocalTime horaDeSaida;
    private final int distancia;
    public PontoPercursoHubs(Localidade local, LocalTime horaDeChegada, int distancia){
        this.local = local;
        this.horaDeChegada = horaDeChegada;
        horaDeSaida = horaDeChegada;
        this.distancia = distancia;
    }
    public PontoPercursoHubs(Localidade local, LocalTime horaDeChegada, LocalTime horaDeSaida, int distancia){
        this.local = local;
        this.horaDeChegada = horaDeChegada;
        this.horaDeSaida = horaDeSaida;
        this.distancia = distancia;
    }
    public LocalTime getHoraDeSaida() {return horaDeSaida;}
    public LocalTime getHoraDeChegada() {return horaDeChegada;}
    public Localidade getLocal() {return local;}
    public int getDistancia() {return distancia;}
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Ponto: %s%n-Hora de Chegada: %s%n", local.getId(), horaDeChegada));
        if(local.isHub())
            stringBuilder.append(String.format("-Hora de Saída: %s%n", horaDeSaida));
        stringBuilder.append("Distância do ponto anterior: ").append(distancia).append(" metros");
        return stringBuilder.toString();
    }
}
