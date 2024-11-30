package controller;

import domain.PlanoDeRega;
import domain.Rega;
import domain.Setor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class CriarPlanoDeRegaControllerTest {
    private CriarPlanoDeRegaController ctrl = new CriarPlanoDeRegaController();
    private final Setor sectorA = new Setor("A");
    private final Setor sectorB = new Setor("B");
    private final Setor sectorC = new Setor("C");
    @Test void assertThatRegaA2IsDetectedWithCorrectDuration(){
        LocalDate diaAProcurar = LocalDate.parse("2023-10-21");
        LocalTime tempoAProcurar = LocalTime.parse("10:10");

        PlanoDeRega plano = createPlanoToTest(sectorA,sectorB,sectorC);

        Map.Entry<Setor, Integer> sectorRegado = ctrl.verSeHaRegasNoMomento(diaAProcurar, tempoAProcurar, plano);
        assertTrue(sectorRegado.getKey().equals(sectorA) && sectorRegado.getValue() == 4);
    }
    @Test void assertThatRegaB1IsDetectedWithCorrectDuration(){
        LocalDate diaAProcurar = LocalDate.parse("2023-10-20");
        LocalTime tempoAProcurar = LocalTime.parse("10:16");

        PlanoDeRega plano = createPlanoToTest(sectorA,sectorB,sectorC);

        Map.Entry<Setor, Integer> sectorRegado = ctrl.verSeHaRegasNoMomento(diaAProcurar, tempoAProcurar, plano);
        assertTrue(sectorRegado.getKey().equals(sectorB) && sectorRegado.getValue() == 3);
    }
    @Test void assertThatRegaC3IsDetectedWithCorrectDuration(){
        LocalDate diaAProcurar = LocalDate.parse("2023-10-22");
        LocalTime tempoAProcurar = LocalTime.parse("10:29");

        PlanoDeRega plano = createPlanoToTest(sectorA,sectorB,sectorC);

        Map.Entry<Setor, Integer> sectorRegado = ctrl.verSeHaRegasNoMomento(diaAProcurar, tempoAProcurar, plano);
        assertTrue(sectorRegado.getKey().equals(sectorC) && sectorRegado.getValue() == 1);
    }
    @Test void assertThatNoActiveRegaIsDetectedWithNull(){
        LocalDate diaAProcurar = LocalDate.parse("2023-10-22");
        LocalTime tempoAProcurar = LocalTime.parse("11:00");

        PlanoDeRega plano = createPlanoToTest(sectorA,sectorB,sectorC);

        Map.Entry<Setor, Integer> sectorRegado = ctrl.verSeHaRegasNoMomento(diaAProcurar, tempoAProcurar, plano);
        assertNull(sectorRegado);
    }
    private PlanoDeRega createPlanoToTest(Setor sectorA, Setor sectorB, Setor sectorC){
        LocalDate diaInicial = LocalDate.parse("2023-10-20");
        LocalDate diaFinal = LocalDate.parse("2023-10-22");

        Rega regaA1 = new Rega(diaInicial,sectorA,14, LocalTime.parse("10:00"));
        Rega regaB1 = new Rega(diaInicial,sectorB,5, LocalTime.parse("10:00").plusMinutes(regaA1.getDuration()));
        Rega regaC1 = new Rega(diaInicial,sectorC,25, LocalTime.parse("10:00").plusMinutes(regaA1.getDuration()).plusMinutes(regaB1.getDuration()));

        Rega regaA2 = new Rega(LocalDate.parse("2023-10-21"),sectorA,14, LocalTime.parse("10:00"));
        Rega regaC2 = new Rega(LocalDate.parse("2023-10-21"),sectorC,25, LocalTime.parse("10:00").plusMinutes(regaA2.getDuration()));

        Rega regaB3 = new Rega(diaFinal,sectorB,5, LocalTime.parse("10:00"));
        Rega regaC3 = new Rega(diaFinal,sectorC,25, LocalTime.parse("10:00").plusMinutes(regaB3.getDuration()));

        return new PlanoDeRega(diaInicial, diaFinal, Arrays.asList(regaA1, regaB1, regaC1, regaA2, regaC2, regaB3, regaC3));
    }
}
