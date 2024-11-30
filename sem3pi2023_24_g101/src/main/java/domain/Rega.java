package domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

import static java.time.temporal.ChronoUnit.MINUTES;

public class Rega implements Comparable<Rega> {

    private LocalDate dia;
    private Setor setorRega;
    private LocalTime horaInicial;
    private LocalTime horaFinal;
    private int duration;
    private String mix;


    public Rega(LocalDate dia, Setor setorRega, LocalTime horaInicial, LocalTime horaFinal, int duration) {
        this.dia = dia;
        this.setorRega = setorRega;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
        this.duration = duration;
    }

    public Rega(LocalDate dia, Setor setorRega, int duration, LocalTime horaInicial) {
        this.dia = dia;
        this.setorRega = setorRega;
        this.duration = duration;
        this.horaInicial = horaInicial;
        horaFinal = horaInicial.plusMinutes(duration);
    }
    public Rega(LocalDate dia, Setor setorRega, int duration, LocalTime horaInicial, String mix) {
        this.dia = dia;
        this.setorRega = setorRega;
        this.duration = duration;
        this.horaInicial = horaInicial;
        horaFinal = horaInicial.plusMinutes(duration);
        this.mix = mix;
    }

    public Setor getSetorRega(){return setorRega;}

    public int getDuration(){return duration;}

    public LocalDate getDia(){return dia;}

    public LocalTime getHoraInicial(){return horaInicial;}

    public LocalTime getHoraFinal(){return horaFinal;}

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }
    public String getMix(){return mix;}
    public void setSetorRega(Setor setorRega) {
        this.setorRega = setorRega;
    }

    public void setHoraInicial(LocalTime horaInicial) {
        this.horaInicial = horaInicial;
    }

    public void setHoraFinal(LocalTime horaFinal) {
        this.horaFinal = horaFinal;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Atravessa a lista de parcelas, retornando o objeto sector através do seu nome
     * @param sectorName nome da sector procurada
     * @param sectorList lista de parcelas
     * @return objeto sector (ou null se este não for encontrado)
     */
    private Setor getSectorByName(String sectorName, List<Setor> sectorList){
       for(Setor sector : sectorList)
           if(sector.getDesignacao().equals(sectorName))
               return sector;
       return null;
    }

    /**
     * Vê se esta rega está ativa no momento pedido
     * @param date dia procurado
     * @param time hora procurada
     * @return se está, retorna o tempo até o final da rega. Se não, retorna -1
     */
    public int estaAtiva(LocalDate date, LocalTime time){
        if (date.equals(dia) && time.isAfter(horaInicial) && time.isBefore(horaFinal))
            return (int) MINUTES.between(time, horaFinal);
        return -1;
    }

    public String toString(){
        StringBuilder returnString = new StringBuilder(String.format("Rega no sector %s no dia %d/%d/%d das %d:%d às %d:%d", setorRega.toString(),
                dia.getDayOfMonth(), dia.getMonthValue(), dia.getYear(), horaInicial.getHour(), horaInicial.getMinute(),
                horaFinal.getHour(), horaFinal.getMinute()));
        if(mix != null)
            returnString.append(String.format(" usando o mix %s", mix));
        return returnString.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rega rega = (Rega) o;
        return duration == rega.duration && Objects.equals(dia, rega.dia) && Objects.equals(setorRega, rega.setorRega)
                && Objects.equals(horaInicial, rega.horaInicial) && Objects.equals(horaFinal, rega.horaFinal)
                && Objects.equals(mix, rega.mix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dia, setorRega, horaInicial, horaFinal, duration);
    }

    public int compareTo(Rega outraRega){
        int dayDifference = dia.compareTo(outraRega.dia);
        if (dayDifference == 0)
            return horaInicial.compareTo(outraRega.horaInicial);
        return dayDifference;
    }
}
