package domain;


public class Parcela {

    private int idParcela;
    private String designacao;
    private double area; // Area em hectares (ha)
    private Setor setorDaParcela;

    public Parcela(int idParcela, String designacao, double area, Setor setorDaParcela) {
        this.idParcela = idParcela;
        this.designacao = designacao;
        this.area = area;
        this.setorDaParcela = setorDaParcela;
    }

    public int getIdParcela() {
        return idParcela;
    }

    public void setIdParcela(int idParcela) {
        this.idParcela = idParcela;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Setor getSetorDaParcela() {
        return setorDaParcela;
    }

    public void setSetorDaParcela(Setor setorDaParcela) {
        this.setorDaParcela = setorDaParcela;
    }
}
