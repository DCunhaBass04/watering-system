# Testes unitários para a USEI08

Neste ficheiro, vamos visualizar os testes que foram realizados para a funcionalidade pedida na USEI08, analizando cada classe testada.
* USEI08ObterCircuitoControllerTest.java

## USEI08ObterCircuitoControllerTest.java

Os testes desta classe têm como objetivo verificar que o circuito calculado tem os dados esperados.

```java
@Test
void assertThatSmallGraphCircuitoHasCorrectValues() {
    CircuitoHubs circuito = USEI08ObterCircuitoController.obtainCircuit(grafoSmall, Utils.getLocalidadeById("CT4",grafoSmall.vertices()),
        new Veiculo(500000, 240, 15, 10), 5);
    assertEquals(circuito.getTempoTotalDeViagem(), 345);
    assertEquals(circuito.getTempoTotalDeCarregamento(), 30);
    assertEquals(circuito.getTempoTotalDeDescarregamento(), 40);
    assertEquals(obterRatioDeHubsDentroDoCircuito(circuito, grafoSmall.vertices()), (float)4/5);
}
```
```java
@Test
void assertThatBigGraphCircuitoHasCorrectValues(){
    CircuitoHubs circuito = USEI08ObterCircuitoController.obtainCircuit(grafoBig, Utils.getLocalidadeById("CT6",grafoBig.vertices()),
        new Veiculo(500000, 240, 20, 15), 5);
    assertEquals(circuito.getTempoTotalDeViagem(), 58);
    assertEquals(circuito.getTempoTotalDeCarregamento(), 20);
    assertEquals(circuito.getTempoTotalDeDescarregamento(), 135);
    assertEquals(obterRatioDeHubsDentroDoCircuito(circuito, grafoBig.vertices()), 1);
}
```
O método ***obtainCircuit*** tem como objetivo saber quantos dos hubs totais é que conseguimos alcançar no circuito calculado.

```java
private float obterRatioDeHubsDentroDoCircuito(CircuitoHubs percursoHubs, List<Localidade> localidades){
    return (float) Utils.getHubs(Utils.getLocalidadesFromPontosDeCircuito(percursoHubs.getPontosDoPercurso())).size() / Utils.getHubs(localidades).size();
}
```

Assim como na **USEI07**, o método ***obterPercursoComMaxNumHubs*** do ***USEI08ObterCircuitoController*** invoca o método principal da **USEI02**.