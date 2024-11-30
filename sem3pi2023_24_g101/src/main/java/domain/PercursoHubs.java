package domain;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.MINUTES;

public class PercursoHubs {
    private final Localidade localInicial;
    private final Localidade localFinal;
    private final LocalTime horaInicial;
    private final LocalTime horaFinal;
    private final List<PontoPercursoHubs> pontosDoPercurso;
    private final int tempoTotalDeViagem;
    private final int tempoTotalDeCarregamento;
    public PercursoHubs (Localidade localInicial, Localidade localFinal, LocalTime horaInicial,
                         LocalTime horaFinal, List<PontoPercursoHubs> pontosDoPercurso){
        this.localInicial = localInicial;
        this.localFinal = localFinal;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
        this.pontosDoPercurso = pontosDoPercurso;
        this.tempoTotalDeViagem = calculateTempoTotalDeViagem(pontosDoPercurso);
        this.tempoTotalDeCarregamento = calculateTempoTotalDeCarregamento(pontosDoPercurso);
    }
    public Localidade getLocalInicial() {return localInicial;}
    public Localidade getLocalFinal() {return localFinal;}
    public LocalTime getHoraInicial() {return horaInicial;}
    public LocalTime getHoraFinal() {return horaFinal;}
    public List<PontoPercursoHubs> getPontosDoPercurso() {return pontosDoPercurso;}
    public int getTempoTotalDeViagem() {return tempoTotalDeViagem;}
    public int getTempoTotalDeCarregamento() {return tempoTotalDeCarregamento;}
    private int calculateTempoTotalDeViagem(List<PontoPercursoHubs> pontosDoPercurso){
        int tempoTotal = 0, listaTamanho = pontosDoPercurso.size();
        for(int i = 0; i < listaTamanho - 1; i++)
            tempoTotal += (int) MINUTES.between(pontosDoPercurso.get(i).getHoraDeSaida(),
                    pontosDoPercurso.get(i+1).getHoraDeChegada());
        return tempoTotal;
    }
    private int calculateTempoTotalDeCarregamento(List<PontoPercursoHubs> pontosDoPercurso){
        int tempoTotal = 0;
        for(PontoPercursoHubs ponto : pontosDoPercurso)
            tempoTotal += (int) MINUTES.between(ponto.getHoraDeChegada(), ponto.getHoraDeSaida());
        return tempoTotal;
    }
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Ponto Inicial: %s%nPonto Final: %s%nHora Inicial: %s%nHora Final: %s%n-Tempo de Viagem: %d minutos%n-Tempo de Carregamento de Cabazes: %d minutos%n",
                localInicial.getId(),localFinal.getId(), horaInicial, horaFinal, tempoTotalDeViagem, tempoTotalDeCarregamento));
        for(PontoPercursoHubs ponto : pontosDoPercurso)
            stringBuilder.append(String.format("%n%s%n", ponto));
        return stringBuilder.toString();
    }
}
