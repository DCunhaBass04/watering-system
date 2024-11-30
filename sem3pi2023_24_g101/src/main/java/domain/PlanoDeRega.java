package domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class PlanoDeRega {
    private final LocalDate dataInicio;
    private final LocalDate dataFim;
    private List<LocalTime> dates;
    private final List<Rega> regasDoPlanoDeRega;

    public PlanoDeRega(List<LocalTime> dates, List<Rega> regasDoPlanoDeRega){
        dataInicio = LocalDate.now();
        dataFim = dataInicio.plusDays(30);
        this.dates = dates;
        this.regasDoPlanoDeRega = regasDoPlanoDeRega;
    }

    public PlanoDeRega(LocalDate dataInicio, LocalDate dataFim, List<Rega> regas){
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.regasDoPlanoDeRega = regas;
    }

    public LocalDate getDataInicio(){return dataInicio;}

    public LocalDate getDataFim(){return dataFim;}

    public List<LocalTime> getDates(){return dates;}

    public List<Rega> getRegasDoPlanoDeRega(){return regasDoPlanoDeRega;}

    public String toString(){
        StringBuilder builder = new StringBuilder();
        for(LocalTime date : dates) builder.append(String.format("às %02d:%02d, ", date.getHour(), date.getMinute()));
        builder.append(String.format("(%d vezes) do dia %2d/%2d/%4d até ao dia %2d/%2d/%4d ", dates.size(), dataInicio.getDayOfMonth(), dataInicio.getMonthValue(),
                        dataInicio.getYear(), dataFim.getDayOfMonth(), dataFim.getMonthValue(), dataFim.getYear()));
        for(Rega linha : regasDoPlanoDeRega) builder.append(linha.toString());
        return builder.toString();
    }
}
