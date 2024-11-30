# Testes unitários para a USLP10

Neste ficheiro, vamos visualizar os testes que foram realizados para a funcionalidade pedida na USLP10, analizando cada classe testada.
* FileAnalyzerTest.java
* CriarPlanoDeRegaControllerTest.java

## FileAnalyzer.java

Os testes desta classe têm como objetivo verificar que o ficheiro é lido como pretendido. O ficheiro usado para estes testes é o exemplo fornecido no enunciado, [USLP10.txt](files/USLP10.txt).

```java
@Test void assertPlanHasCorrectRegasForDay20231024() throws FileNotFoundException {
    LocalDate dia = LocalDate.parse("2023-10-24");
    PlanoDeRega plano = FileAnalyzer.criarPlanoRega(planoFertirregaFilePath,dia);
    Setor sectorA = new Setor("A"), sectorB = new Setor("B"), sectorC = new Setor("C"),
        sectorE = new Setor("E"), sectorF = new Setor("F");

    Rega regaA1 = new Rega(dia,sectorA,14, LocalTime.parse("08:30"), "mix1"),
        regaB1 = new Rega(dia,sectorB,8,LocalTime.parse("08:44")),
        regaC1 = new Rega(dia,sectorC,25,LocalTime.parse("08:52"),"mix2"),
        regaE1 = new Rega(dia,sectorE,7,LocalTime.parse("09:17"),"mix1"),
        regaF1 = new Rega(dia,sectorF,10,LocalTime.parse("09:24")),
        regaA2 = new Rega(dia,sectorA,14,LocalTime.parse("17:00"), "mix1"),
        regaB2 = new Rega(dia,sectorB,8,LocalTime.parse("17:14")),
        regaC2 = new Rega(dia,sectorC,25,LocalTime.parse("17:22"),"mix2"),
        regaE2 = new Rega(dia,sectorE,7,LocalTime.parse("17:47"),"mix1"),
        regaF2 = new Rega(dia,sectorF,10,LocalTime.parse("17:54"));

    assertTrue(plano.getRegasDoPlanoDeRega().containsAll(Arrays.asList(regaA1,regaB1,regaC1,regaE1,regaF1,
                regaA2,regaB2,regaC2,regaE2,regaF2)));
}
```
As regas testadas neste plano são baseadas numa resposta oficial por parte do cliente:

![Resposta do Cliente](files/Resposta%20do%20Cliente.PNG)

**Nota:** Esta resposta do cliente só tem em conta as regas sem nenhuma receita de fertirrega utilizada. O nosso teste conta com o ficheiro de input mostrado anteriormente, [USLP10](files/USLP10.txt).


## CriarPlanoDeRegaControllerTest.java

Todos os testes desta classe usam o método "**createPlanoToTest**"
```java
private PlanoDeRega createPlanoToTest(Sector sectorA, Sector sectorB, Sector sectorC){
    LocalDate diaInicial = LocalDate.parse("2023-10-20");
    LocalDate diaFinal = LocalDate.parse("2023-10-22");

    Rega regaA1 = new Rega(diaInicial,sectorA,14, LocalTime.parse("10:00"));
    Rega regaB1 = new Rega(diaInicial,sectorB,5, LocalTime.parse("10:00").plusMinutes(regaA1.getDuration()));
    Rega regaC1 = new Rega(diaInicial,sectorC,25, LocalTime.parse("10:00").plusMinutes(regaA1.getDuration()).plusMinutes(regaB1.getDuration()));

    Rega regaA2 = new Rega(LocalDate.parse("2023-10-21"),sectorA,14, LocalTime.parse("10:00"));
    Rega regaC2 = new Rega(LocalDate.parse("2023-10-21"),sectorC,25, LocalTime.parse("10:00").plusMinutes(regaA2.getDuration()));

    Rega regaB3 = new Rega(diaFinal,sectorB,5, LocalTime.parse("10:00"));
    Rega regaC3 = new Rega(diaFinal,sectorC,25, LocalTime.parse("10:00").plusMinutes(regaB3.getDuration()));

    return new PlanoDeRega(diaInicial, diaFinal, Arrays.asList(regaA1, regaB1, regaC1, regaA2, regaC2, regaB3, regaC3), List.of());
}
```

A partir deste método, testamos a funcionalidade da classe "**verSeHaRegasNoMomento**" com vários testes.
Três destes testes pretendem um resultado positivo do método.

```java
@Test void assertThatRegaA2IsDetectedWithCorrectDuration(){
    LocalDate diaAProcurar = LocalDate.parse("2023-10-21");
    LocalTime tempoAProcurar = LocalTime.parse("10:10");

    PlanoDeRega plano = createPlanoToTest(sectorA,sectorB,sectorC);

    Map.Entry<Sector, Integer> sectorRegado = ctrl.verSeHaRegasNoMomento(diaAProcurar, tempoAProcurar, plano);
    assertTrue(sectorRegado.getKey().equals(sectorA) && sectorRegado.getValue() == 4);
}
```

```java
@Test void assertThatRegaB1IsDetectedWithCorrectDuration(){
    LocalDate diaAProcurar = LocalDate.parse("2023-10-20");
    LocalTime tempoAProcurar = LocalTime.parse("10:16");

    PlanoDeRega plano = createPlanoToTest(sectorA,sectorB,sectorC);

    Map.Entry<Sector, Integer> sectorRegado = ctrl.verSeHaRegasNoMomento(diaAProcurar, tempoAProcurar, plano);
    assertTrue(sectorRegado.getKey().equals(sectorB) && sectorRegado.getValue() == 3);
}
```

```java
@Test void assertThatRegaC3IsDetectedWithCorrectDuration(){
    LocalDate diaAProcurar = LocalDate.parse("2023-10-22");
    LocalTime tempoAProcurar = LocalTime.parse("10:29");

    PlanoDeRega plano = createPlanoToTest(sectorA,sectorB,sectorC);

    Map.Entry<Sector, Integer> sectorRegado = ctrl.verSeHaRegasNoMomento(diaAProcurar, tempoAProcurar, plano);
    assertTrue(sectorRegado.getKey().equals(sectorC) && sectorRegado.getValue() == 1);
}
```

Este último teste tem como objetivo obter *null* da funcionalidade chamada.

```java
@Test void assertThatNoActiveRegaIsDetectedWithNull(){
    LocalDate diaAProcurar = LocalDate.parse("2023-10-22");
    LocalTime tempoAProcurar = LocalTime.parse("11:00");

    PlanoDeRega plano = createPlanoToTest(sectorA,sectorB,sectorC);

    Map.Entry<Sector, Integer> sectorRegado = ctrl.verSeHaRegasNoMomento(diaAProcurar, tempoAProcurar, plano);
    assertNull(sectorRegado);
}
```

