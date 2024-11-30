# Testes unitários para a USEI04

Neste ficheiro, vamos visualizar os testes que foram realizados para a funcionalidade pedida na USEI04, analizando a classe testada.

## ObterRedeComMenorCustoController

Os testes desta classe visaM testar os valores  para a rede de menor custo obtida a partir do grafo criado com informação contida nos ficheiros:
[locais_small.csv](../Data/locais_small.csv) e [distancias_small.csv](../Data/distancias_small.csv).[locais_big.csv](../Data/locais_big.csv) e [distancias_big.csv](../Data/distancias_big.csv).

Primeiramente foi testado se o custo total obtido da rede com menor distância tinha  valores minimamente acessíveis (positivo pelo menos).
```java
 
@Test
void verificarCustoMinimoSmall() throws  FileNotFoundException {
    Graph<Localidade, Integer> grafoObtido = FileAnalyzer.createMapGraph(locaisSmallFilePath, distanciasSmallFilePath);
    int menorCusto = ObterRedeComMenorCustoController.obterCustoTotalDaRedeComMenorCusto(ObterRedeComMenorCustoController.obterRedeComMenorCusto(grafoObtido));

    assertNotNull(menorCusto);
    assertTrue(menorCusto > 0);
}


@Test   
    void verificarCustoMinimoBig() throws  FileNotFoundException {
        Graph<Localidade, Integer> grafoObtido = FileAnalyzer.createMapGraph(locaisBigFilePath, distanciasBigFilePath);
        int menorCusto = ObterRedeComMenorCustoController.obterCustoTotalDaRedeComMenorCusto(ObterRedeComMenorCustoController.obterRedeComMenorCusto(grafoObtido));

        assertNotNull(menorCusto);
        assertTrue(menorCusto > 0);
    }
    

```
A seguir, foi verificada a condição do algoritmo Kruskal: O número de arestas da nova árvore geradora terá de ser igual ao número de vertices do grafo inicial.
```java
    /**
     * Verificar a condiçao do algoritmo Kruskal |E’| = |V|-1
     * Nota: A forma de implementação adiciona o dobro de arestas para cada vertice desta forma: numEdges/2
     */
    @Test
    void verificarNumArestasMSTCorretasSmall() throws FileNotFoundException {
        Graph<Localidade, Integer> grafoObtido = FileAnalyzer.createMapGraph(locaisSmallFilePath, distanciasSmallFilePath);
        Graph<Localidade, Integer> redeComMenorCusto = ObterRedeComMenorCustoController.obterRedeComMenorCusto(grafoObtido);
        assertEquals(redeComMenorCusto.numEdges()/2,grafoObtido.numVertices()-1);
    }


    @Test
    void verificarNumArestasMSTCorretasBig() throws FileNotFoundException {
        Graph<Localidade, Integer> grafoObtido = FileAnalyzer.createMapGraph(locaisBigFilePath,distanciasBigFilePath);
        Graph<Localidade, Integer> redeComMenorCusto = ObterRedeComMenorCustoController.obterRedeComMenorCusto(grafoObtido);
        assertEquals(redeComMenorCusto.numEdges()/2,grafoObtido.numVertices()-1);
    }
    
    
``` 
Por fim foi verificado que a rede minima continha todos os vértices do grafo inicial (original):
```java


    @Test
    void verificarContemVerticesGrafoOriginalSmall() throws FileNotFoundException {
        Graph<Localidade, Integer> grafoObtido = FileAnalyzer.createMapGraph(locaisSmallFilePath, distanciasSmallFilePath);
        Graph<Localidade, Integer> redeComMenorCusto = ObterRedeComMenorCustoController.obterRedeComMenorCusto(grafoObtido);
        assertTrue(redeComMenorCusto.vertices().containsAll(grafoObtido.vertices()));
    }
    @Test
    void verificarContemVerticesGrafoOriginalBig() throws FileNotFoundException {
        Graph<Localidade, Integer> grafoObtido = FileAnalyzer.createMapGraph(locaisBigFilePath, distanciasSmallFilePath);
        Graph<Localidade, Integer> redeComMenorCusto = ObterRedeComMenorCustoController.obterRedeComMenorCusto(grafoObtido);
        assertTrue(redeComMenorCusto.vertices().containsAll(grafoObtido.vertices()));
    }
``` 

