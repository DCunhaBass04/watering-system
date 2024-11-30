# Testes unitários para a USEI02

Neste ficheiro, vamos visualizar os testes que foram realizados para a funcionalidade pedida na USEI02, analizando as classes testada.

## CriteriaAlgorithmTest.java

Os testes desta classe têm como objetivo ter a certeza que os valores de *influência*, *proximidade* e *centralidade* estão corretos. Vemos isso nos seguintes testes.

```java
@Test
void assertCriteriosAreCorrectForSmallCT12AreCorrectForSmallFiles() {
    Localidade local = Utils.getLocalidadeById("CT12", grafoSmall.vertices());
    ShortestPathMapGraph<Localidade, Integer> spmg = new ShortestPathMapGraph<>();
    LinkedList<Localidade>[][] listaDeCaminhosCurtos = spmg.giveListOfShortestPaths(grafoSmall);
    assertEquals(CriteriaAlgorithm.getInfluencia(grafoSmall, local), 8);
    assertEquals(CriteriaAlgorithm.getProximidade(grafoSmall, local), 1);
    assertEquals(CriteriaAlgorithm.getCentralidade(local, listaDeCaminhosCurtos), 36);
}
```
```java
@Test
void assertCriteriosAreCorrectForSmallCT17AreCorrectForSmallFiles() {
    Localidade local = Utils.getLocalidadeById("CT17", grafoSmall.vertices());
    ShortestPathMapGraph<Localidade, Integer> spmg = new ShortestPathMapGraph<>();
    LinkedList<Localidade>[][] listaDeCaminhosCurtos = spmg.giveListOfShortestPaths(grafoSmall);
    assertEquals(CriteriaAlgorithm.getInfluencia(grafoSmall, local), 10);
    assertEquals(CriteriaAlgorithm.getProximidade(grafoSmall, local), 4);
    assertEquals(CriteriaAlgorithm.getCentralidade(local, listaDeCaminhosCurtos), 38);
}
```
```java
@Test
void assertCriteriosAreCorrectForBigCT285AreCorrectForBigFiles() {
    Localidade local = Utils.getLocalidadeById("CT285", grafoBig.vertices());
    ShortestPathMapGraph<Localidade, Integer> spmg = new ShortestPathMapGraph<>();
    LinkedList<Localidade>[][] listaDeCaminhosCurtos = spmg.giveListOfShortestPaths(grafoBig);
    assertEquals(CriteriaAlgorithm.getInfluencia(grafoBig, local), 14);
    assertEquals(CriteriaAlgorithm.getProximidade(grafoBig, local), 1);
    assertEquals(CriteriaAlgorithm.getCentralidade(local, listaDeCaminhosCurtos), 3383);
}
```
```java
@Test
void assertCriteriosAreCorrectForBigCT100AreCorrectForBigFiles() {
    Localidade local = Utils.getLocalidadeById("CT100", grafoBig.vertices());
    ShortestPathMapGraph<Localidade, Integer> spmg = new ShortestPathMapGraph<>();
    LinkedList<Localidade>[][] listaDeCaminhosCurtos = spmg.giveListOfShortestPaths(grafoBig);
    assertEquals(CriteriaAlgorithm.getInfluencia(grafoBig, local), 12);
    assertEquals(CriteriaAlgorithm.getProximidade(grafoBig, local), 1);
    assertEquals(CriteriaAlgorithm.getCentralidade(local, listaDeCaminhosCurtos), 4010);
}
```
Nestes testes, selecionamos um local e verificamos se os valores pedidos nos critérios são como previstos.

## ObterHubsControllerTest.java

Aqui testamos o método principal do método.

```java
@Test void assertTop5HubsAreCorrectForSmallFiles() {
    Map<CriteriosLocalidade, Localidade> map = ObterHubsController.obterTopNLocalidades(grafoSmall, 5);
    List<String> locais = new ArrayList<>(Arrays.asList("CT10", "CT13", "CT1", "CT6", "CT17"));
    int i = 0;
    for(Map.Entry<CriteriosLocalidade, Localidade> entry : map.entrySet()) {
        assertTrue(entry.getValue().getId().equalsIgnoreCase(locais.get(i)));
        i++;
    }
}
@Test void assertTop10HubsAreCorrectForSmallFiles() {
    Map<CriteriosLocalidade, Localidade> map = ObterHubsController.obterTopNLocalidades(grafoSmall, 10);
    List<String> locais = new ArrayList<>(Arrays.asList("CT10", "CT13", "CT1", "CT6", "CT17", "CT12", "CT5", "CT16", "CT11", "CT2"));
    int i = 0;
    for(Map.Entry<CriteriosLocalidade, Localidade> entry : map.entrySet()) {
        assertTrue(entry.getValue().getId().equalsIgnoreCase(locais.get(i)));
        i++;
    }
}
```
Desta forma, vemos que cada um dos Top *n* hubs têm os elementos previstos.