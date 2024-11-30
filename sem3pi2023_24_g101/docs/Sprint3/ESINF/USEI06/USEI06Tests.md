### Testes unitários
```java
@Test
    void autonomiaElevada() {
        MapGraph<Localidade, Integer> rede = obterRedeTeste();
        Localidade origem = rede.vertex(0); // Porto
        Localidade destino = rede.vertex(4); // Braga
        double autonomia = 500;
        List<LinkedList<Localidade>> percursosLimite = PercursosLimite.calcularPercursosLimite(rede, origem, destino, autonomia);
        printPercursosLimite(percursosLimite, destino);
    }

    @Test
    void autonomiaPequena() {
        MapGraph<Localidade, Integer> rede = obterRedeTeste();
        Localidade origem = rede.vertex(0); // Porto
        Localidade destino = rede.vertex(4); // Braga
        double autonomia = 50;
        List<LinkedList<Localidade>> percursosLimite = PercursosLimite.calcularPercursosLimite(rede, origem, destino, autonomia);
        printPercursosLimite(percursosLimite, destino);
    }

    @Test
    void autonomiaNula() {
        MapGraph<Localidade, Integer> rede = obterRedeTeste();
        Localidade origem = rede.vertex(0); // Porto
        Localidade destino = rede.vertex(4); // Braga
        double autonomia = 0;
        List<LinkedList<Localidade>> percursosLimite = PercursosLimite.calcularPercursosLimite(rede, origem, destino, autonomia);
        printPercursosLimite(percursosLimite, destino);
    }

    @Test
    void autonomiaNegativa() {
        MapGraph<Localidade, Integer> rede = obterRedeTeste();
        Localidade origem = rede.vertex(0); // Porto
        Localidade destino = rede.vertex(4); // Braga
        double autonomia = -50;
        List<LinkedList<Localidade>> percursosLimite = PercursosLimite.calcularPercursosLimite(rede, origem, destino, autonomia);
        printPercursosLimite(percursosLimite, destino);
    }

    @Test
    void testarRedeGrande() {
        Localidade origem = rede.vertex(0); // CT43
        Localidade destino = rede.vertex(5); // CT156
        double autonomia = 500000;
        List<LinkedList<Localidade>> percursosLimite = PercursosLimite.calcularPercursosLimite((MapGraph<Localidade, Integer>) rede, origem, destino, autonomia);
        printPercursosLimite(percursosLimite, destino);
    }
```