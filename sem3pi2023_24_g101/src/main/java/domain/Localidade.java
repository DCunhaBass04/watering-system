package domain;

import domain.graph.map.MapGraph;

import java.awt.geom.Point2D;
import java.time.LocalTime;
import java.util.Objects;

public class Localidade {

    private final String id;
    private final Point2D.Double coords;
    private LocalTime tempoInicial;
    private LocalTime tempoFinal;
    private boolean hub;

    public Localidade(String id, Point2D.Double coords){
        this.id = id;
        this.coords = coords;
        tempoInicial = null;
        tempoFinal = null;
        hub = false;
    }
    public Localidade(String id, Point2D.Double coords, LocalTime tempoInicial, LocalTime tempoFinal){
        this.id = id;
        this.coords = coords;
        this.tempoInicial = tempoInicial;
        this.tempoFinal = tempoFinal;
        hub = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Localidade that = (Localidade) o;
        return Objects.equals(id, that.id) && Objects.equals(coords, that.coords)
                && Objects.equals(tempoInicial, that.tempoInicial) && Objects.equals(tempoFinal, that.tempoFinal);
    }

    @Override
    public int hashCode() { return Objects.hash(id, coords); }

    public Point2D.Double getCoords() { return coords; }

    public String getId() { return id; }
    public boolean isHub(){return hub;}
    public void setHub(boolean hub){this.hub = hub;}
    public LocalTime getTempoFinal() {return tempoFinal;}
    public LocalTime getTempoInicial() {return tempoInicial;}
    public void setTempoInicial(LocalTime tempoInicial){this.tempoInicial = tempoInicial;}
    public void setTempoFinal(LocalTime tempoFinal){this.tempoFinal = tempoFinal;}

    public static Localidade findLocalidadeByCoordinates(MapGraph<Localidade, Integer> redeDistribuicao, Point2D.Double coordinates) {
        for (Localidade currentLocalidade : redeDistribuicao.vertices()) {
            if (currentLocalidade.getCoords() == coordinates) {
                return currentLocalidade;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder(String.format("Localidade %s:%n-Latitude: %.2f%n-Longitude: %.2f%n",
                id, coords.getX(), coords.getY()));
        if(tempoInicial != null && tempoFinal != null)
            returnString.append(String.format("Horário de Funcionamento: %s - %s%n",
                    tempoInicial, tempoFinal));
        return returnString.toString();
    }
}
