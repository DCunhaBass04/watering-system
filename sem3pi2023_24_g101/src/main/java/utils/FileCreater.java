package utils;

import com.opencsv.CSVWriter;
import domain.PlanoDeRega;
import domain.Rega;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class FileCreater {
    /**
     * Este método cria o ficheiro .csv com o plano já criado
     * @param plano objeto com as várias regas
     * @throws IOException caso haja erro na criação do ficheiro
     */
    public static void createPlan(PlanoDeRega plano) throws IOException{
        createRegaPlan(plano.getRegasDoPlanoDeRega(), plano.getDataInicio());
    }
    private static void createRegaPlan(List<Rega> regas, LocalDate diaInicial) throws IOException {
        CSVWriter writer = new CSVWriter(new FileWriter(String.format("planorega%d%d%d.csv", diaInicial.getDayOfMonth(),
                diaInicial.getMonthValue(), diaInicial.getYear())), ';', CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END);
        String[] line = {"Dia", "Sector", "Duracao", "Inicio", "Final", "Mix"};
        writer.writeNext(line);
        for(Rega rega : regas){
            String mix = rega.getMix() != null ? rega.getMix() : "NULL";
            line = new String[]{String.format("%d/%d/%d", rega.getDia().getDayOfMonth(), rega.getDia().getMonthValue(), rega.getDia().getYear()),   //dia
                    rega.getSetorRega().getDesignacao(),                                                                                              //setorName
                    String.valueOf(rega.getDuration()),                                                                                             //duração
                    String.format("%02d:%02d", rega.getHoraInicial().getHour(), rega.getHoraInicial().getMinute()),                                   //início
                    String.format("%02d:%02d", rega.getHoraFinal().getHour(), rega.getHoraFinal().getMinute()),                                      //final
                    mix};
            writer.writeNext(line);
        }
        writer.flush();
        writer.close();
    }
}
