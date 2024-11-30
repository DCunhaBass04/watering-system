package controller;

import domain.Setor;
import domain.PlanoDeRega;
import domain.Rega;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;


public class CriarPlanoDeRegaController {
    /**
     * Método vai pela lista de regas, vendo se há alguma ativa
     * @param date dia procurado
     * @param time data procurada
     * @param planoDeRega plano de rega com todas as regas
     * @return objeto com a parcela a ser regada e o tempo que falta para a rega do mesmo acabar (ou null se não houver nenhuma)
     */
    public Map.Entry<Setor, Integer> verSeHaRegasNoMomento(LocalDate date, LocalTime time, PlanoDeRega planoDeRega){
        for(Rega rega : planoDeRega.getRegasDoPlanoDeRega()){
            int tempoAteFimDeRega = rega.estaAtiva(date, time);
            if(tempoAteFimDeRega != -1){
                return new AbstractMap.SimpleEntry<>(rega.getSetorRega(), tempoAteFimDeRega);
            }
        }
        return null;
    }
}
