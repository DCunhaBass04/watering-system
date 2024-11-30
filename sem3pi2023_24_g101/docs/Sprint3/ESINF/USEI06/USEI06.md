## USEI06 - Encontrar diferentes percursos
Encontrar para um produtor os diferentes percursos que consegue fazer entre um local de origem
e um hub limitados pelos Kms de autonomia do seu veículo elétrico, ou seja, não considerando carregamentos
no percurso. Critério de Aceitação: Devolver para cada percurso o local de origem, os locais de passagem
(sendo um hub, identificá-lo), distância entre todos os locais do percurso, distância total e tempo total de percurso.

### Método principal

```java
public static List<LinkedList<Localidade>> calcularPercursosLimite(MapGraph<Localidade, Integer> rede, Localidade origem, Localidade destino, double autonomia) {
        List<LinkedList<Localidade>> percursos = new ArrayList<>();
        Map<Localidade, Boolean> visitadas = new HashMap<>();
        for (Localidade vertex : rede.vertices()) {
            visitadas.put(vertex, false);
        }
        LinkedList<Localidade> currentPath = new LinkedList<>();
        depthFirstSearch(rede, origem, destino, visitadas, currentPath, percursos, autonomia, 0.0);
        return percursos;
    }
```
### Método auxiliar

```java
private static void depthFirstSearch(MapGraph<Localidade, Integer> rede, Localidade atual, Localidade destino, Map<Localidade, Boolean> visitadas,
        LinkedList<Localidade> percursoAtual, List<LinkedList<Localidade>> percursos, double autonomia, double distanciaAtual) {
        visitadas.put(atual, true);
        percursoAtual.addLast(atual);
        if (atual.equals(destino)) {
            if (distanciaAtual <= autonomia) {
            percursos.add(new LinkedList<>(percursoAtual));
            }
        } else {
            for (Localidade adjacente : rede.adjVertices(atual)) {
                int distancia = rede.edge(atual, adjacente).getWeight();
                if (!visitadas.get(adjacente) && distanciaAtual + distancia <= autonomia) {
                depthFirstSearch(rede, adjacente, destino, visitadas, percursoAtual, percursos, autonomia, distanciaAtual + distancia);
                }
            }
        }
        visitadas.put(atual, false);
        percursoAtual.removeLast();
        }
```

### Explicação da resolução
Para resolver o problema desta US utilizei uma adaptação conhecida do algoritmo Depth First Search. 
Essa adaptação envolve fazer backtracking dos caminhos que já foram descobertos com DFS entre a origem e o destino.
Por outras palavras, uma vez que queremos descobrir todos os caminhos entre a origem e o destino estamos sujeitos a que
uma node (localidade) contenha mais que um caminho possível, daí ser necessário usar backtrack para voltar a essa node e
descobrir os outros caminhos possíveis. Além desta adaptação foi também necessário utilizar uma condição adicional, a da
autonomia do veículo. Essa condição foi implementada no próprio DFS com backtrack onde adicionei a condição adicional de verificar
se a distância entre a node atual e a próxima a ser percorrida é menor ou igual à autonomia. Outro ponto importante a explicar é a
condição de paragem do DFS com backtrack (uma vez que a natureza do algoritmo é recursiva). Esta condição é muito simplesmente o
caso de a node a atualmente percorrida ser igual ao destino. Quando isto acontece o algoritmo prossegue com a realização do backtrack.

### Complexidade
* A complexidade para o pior caso é o(2^n), onde n representa o número de vértices do grafo.
Isto é assim porque no pior caso o algoritmo tem de visitar todos os caminhos possíveis
contidos no grafo entre a origem e o destino, e este número é exponencial. Isto também significa
que a autonomia do veículo permite percorrer todos os caminhos possíveis entre a origem e o destino.
* A complexidade para o melhor caso é constante uma vez que o melhor caso é quando existe apenas
um caminho possível entre a origem e o destino e o tamanho desse caminho (número de edges) é 1.