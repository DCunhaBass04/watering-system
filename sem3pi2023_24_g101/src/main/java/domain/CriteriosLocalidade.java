package domain;

public class CriteriosLocalidade {
    private final int influencia, proximidade, centralidade;
    public CriteriosLocalidade(int influencia, int proximidade, int centralidade){
        this.influencia = influencia;
        this.proximidade = proximidade;
        this.centralidade = centralidade;
    }
    public int getInfluencia() { return influencia; }
    public int getProximidade() { return proximidade; }
    public int getCentralidade() { return centralidade; }
}
