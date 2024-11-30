# USEI08 - Encontrar circuito de entrega

**No seguinte documento apresentam-se:**
* Explicação da Resolução
* Dependências
* Testes Unitários

## Explicação da Resolução

Esta funcionalidade visa calcular um circuito que parte de um local origem, passa por N *hubs* com maior número de colaboradores uma só vez e volta ao local origem, minimizando a distância total percorrida.

**Nota 1:** No caminho de volta, não será considerada a ideia de só passar por cada *hub* uma vez. A razão para esta decisão está apresentada na seguinte resposta:

![Resposta da professora](files/Fim%20do%20Circuito.PNG)

O utilizador terá de inserir os seguintes elementos:
* Autonomia do veículo (em metros)
* Velocidade média do veículo (em km/h)
* Duração média do carregamento da bateria do veículo (em minutos)
* Duração média do descarregamento dos cabazes do veículo (em minutos)
* Número de hubs no grafo
* ID da localidade considerada como ponto inicial do percurso

Depois destes valores serem inseridos, o *Controller* irá calcular o circuito com o maior número de hubs possível, e com o caminho mais curto quando possível, chamando o método *shortestPath* no último ponto até ao inicial, para acabar o ciclo. 

No objeto retornado, é possível obter todos os pontos do percurso, a distância e tempo de cada ponto ao ponto anterior no percurso, o número de colaboradores (se a localidade em questão for um *hub*), assim como o tempo de carregamento e descarregamento. O tempo total de viagem e o tempo total de carregamentos e descarregamentos também está contido neste objeto.

**Nota 2:** As localidades que são tornadas em *hubs* são decididas pelos critérios definidos na **USEI02**.

**Nota 3:** Para o grafo não ser permanentemente alterado por esta funcionalidade, esta não tem acesso ao grafo em si, mas só a um clone do mesmo.

## Dependências

Esta *User Story* tem uma dependência nas seguintes *User Stories*:
* Na **USEI01**, visto que essa é a *User Story* que fornece um grafo preenchido ao resto do programa.
* Na **USEI02**, visto que é esta *User Story* que decide quais são as N localidades a serem tornadas em *hubs*.

## Testes Unitários

De seguida, foi colocado por baixo um documento de texto com as informações relacionadas aos testes unitários criados para esta funcionalidade.

[Testes Unitários](USEI08Tests.md)