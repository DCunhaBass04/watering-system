package domain;

import java.util.Objects;

public class Setor {

    private final String designacao;

    public Setor(String designacao){
        this.designacao = designacao;
    }

    public String getDesignacao(){return designacao;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Setor sector = (Setor) o;
        return Objects.equals(designacao, sector.designacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(designacao);
    }

    public String toString(){return String.format("Sector %s", designacao);}
}
