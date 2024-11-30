package domain;

import java.util.List;

public class CircuitoHubs {
    private final Localidade localInicial;
    private final List<PontoCircuitoHubs> pontosDoPercurso;
    private final int tempoTotalDeViagem, tempoTotalDeCarregamento, tempoTotalDeDescarregamento;
    public CircuitoHubs (Localidade localInicial, List<PontoCircuitoHubs> pontosDoPercurso){
        this.localInicial = localInicial;
        this.pontosDoPercurso = pontosDoPercurso;
        tempoTotalDeViagem = calculateTempoTotalDeViagem(pontosDoPercurso);
        tempoTotalDeCarregamento = calculateTempoTotalDeCarregamento(pontosDoPercurso);
        tempoTotalDeDescarregamento = calculateTempoTotalDeDescarregamento(pontosDoPercurso);
    }
    public Localidade getLocalInicial() {return localInicial;}
    public List<PontoCircuitoHubs> getPontosDoPercurso() {return pontosDoPercurso;}
    public int getTempoTotalDeViagem() {return tempoTotalDeViagem;}
    public int getTempoTotalDeCarregamento() {return tempoTotalDeCarregamento;}
    public int getTempoTotalDeDescarregamento() {return tempoTotalDeDescarregamento;}
    private int calculateTempoTotalDeViagem(List<PontoCircuitoHubs> pontosDoPercurso){
        int tempoTotal = 0;
        for(PontoCircuitoHubs ponto : pontosDoPercurso)
            tempoTotal += ponto.getDuracaoDeChegada();
        return tempoTotal;
    }
    private int calculateTempoTotalDeCarregamento(List<PontoCircuitoHubs> pontosDoPercurso){
        int tempoTotal = 0;
        for(PontoCircuitoHubs ponto : pontosDoPercurso)
            tempoTotal += ponto.getDuracaoDeCarregamento();
        return tempoTotal;
    }
    private int calculateTempoTotalDeDescarregamento(List<PontoCircuitoHubs> pontosDoPercurso){
        int tempoTotal = 0;
        for(PontoCircuitoHubs ponto : pontosDoPercurso)
            tempoTotal += ponto.getDuracaoDeDescarregamento();
        return tempoTotal;
    }
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Ponto Inicial: %s%n-Tempo de Viagem: %d minutos%n-Tempo de Carregamento de Cabazes: %d minutos%n-Tempo de Descarregamento de Cabazes: %d minutos%n",
                localInicial.getId(),tempoTotalDeViagem,tempoTotalDeCarregamento,tempoTotalDeDescarregamento));
        for(PontoCircuitoHubs ponto : pontosDoPercurso)
            stringBuilder.append(String.format("%n%s%n", ponto));
        return stringBuilder.toString();
    }
}
