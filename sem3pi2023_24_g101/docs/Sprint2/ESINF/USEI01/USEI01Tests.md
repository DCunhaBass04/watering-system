# Testes unitários para a USEI01

Neste ficheiro, vamos visualizar os testes que foram realizados para a funcionalidade pedida na USEI01, analizando a classe testada.

## FileAnalyzer.java

Os testes desta classe têm como objetivo verificar que os ficheiros são lidos como pretendido. Os ficheiros usados para estes testes são os exemplos fornecidos juntamente com o enunciado. Nomeadamente, [locais_small.csv](../Data/locais_small.csv) e [distancias_small.csv](../Data/distancias_small.csv).

```java
@Test void assertGraphHasCorrectEdgesForDistancesSmall() throws FileNotFoundException {
    MapGraph<Localidade, Integer> grafoCriado = FileAnalyzer.createMapGraph(locaisSmallFilePath, distanciasSmallFilePath);
    assertTrue(grafoCriado.edges().containsAll(getAllEdgesFromSmallFile()));
}
```
Neste teste, vemos se o *MapGraph* criado contém todas as distâncias entre locais. Desta forma, poderíamos concluir que também contém os locais contidos dessas distâncias.

Para alcançar este objetivo, o método *getAllEdgesFromSmallFile()* para obter uma lista com todas as distâncias nesse ficheiro, colocadas manualmente com o objetivo de testar o método principal.

```java
private List<Edge<Localidade, Integer>> getAllEdgesFromSmallFile(){
    Localidade ct1 = new Localidade("CT1", new Point2D.Double(40.6389, -8.6553)),
            ct2 = new Localidade("CT2", new Point2D.Double(38.0333, -7.8833)),
            ct3 = new Localidade("CT3", new Point2D.Double(41.5333, -8.4167)),
            ct15 = new Localidade("CT15", new Point2D.Double(41.7, -8.8333)),
            ct16 = new Localidade("CT16", new Point2D.Double(41.3002, -7.7398)),
            ct12 = new Localidade("CT12", new Point2D.Double(41.1495, -8.6108)),
            ct7 = new Localidade("CT7", new Point2D.Double(38.5667, -7.9)),
            ct8 = new Localidade("CT8", new Point2D.Double(37.0161, -7.935)),
            ct13 = new Localidade("CT13", new Point2D.Double(39.2369, -8.685)),
            ct14 = new Localidade("CT14", new Point2D.Double(38.5243, -8.8926)),
            ct11 = new Localidade("CT11", new Point2D.Double(39.3167, -7.4167)),
            ct5 = new Localidade("CT5", new Point2D.Double(39.823, -7.4931)),
            ct9 = new Localidade("CT9", new Point2D.Double(40.5364, -7.2683)),
            ct4 = new Localidade("CT4", new Point2D.Double(41.8, -6.75)),
            ct17 = new Localidade("CT17", new Point2D.Double(40.6667, -7.9167)),
            ct6 = new Localidade("CT6", new Point2D.Double(40.2111, -8.4291)),
            ct10 = new Localidade("CT10", new Point2D.Double(39.7444, -8.8072));
    return Arrays.asList(
            new Edge<>(ct10, ct13, 63448),
            new Edge<>(ct10, ct6, 67584),
            new Edge<>(ct10, ct1, 110848),
            new Edge<>(ct10, ct5, 125041),
            new Edge<>(ct12, ct3, 50467),
            new Edge<>(ct12, ct1, 62877),
            new Edge<>(ct12, ct15, 70717),
            new Edge<>(ct11, ct5, 62655),
            new Edge<>(ct11, ct13, 121584),
            new Edge<>(ct11, ct10, 142470),
            new Edge<>(ct14, ct13, 89813),
            new Edge<>(ct14, ct7, 95957),
            new Edge<>(ct14, ct2, 114913),
            new Edge<>(ct14, ct8, 207558),
            new Edge<>(ct13, ct7, 111686),
            new Edge<>(ct16, ct3, 68957),
            new Edge<>(ct16, ct17, 79560),
            new Edge<>(ct16, ct12, 82996),
            new Edge<>(ct16, ct9, 103704),
            new Edge<>(ct16, ct4, 110133),
            new Edge<>(ct15, ct3, 43598),
            new Edge<>(ct17, ct9, 62879),
            new Edge<>(ct17, ct1, 69282),
            new Edge<>(ct17, ct6, 73828),
            new Edge<>(ct1, ct6, 56717),
            new Edge<>(ct2, ct7, 65574),
            new Edge<>(ct2, ct8, 125105),
            new Edge<>(ct2, ct11, 163996),
            new Edge<>(ct4, ct3, 157223),
            new Edge<>(ct4, ct9, 162527),
            new Edge<>(ct5, ct9, 90186),
            new Edge<>(ct5, ct6, 100563),
            new Edge<>(ct5, ct17, 111134)
    );
}
```
Desta forma, vemos que todas estas *Edge* estão contidas no grafo criado.