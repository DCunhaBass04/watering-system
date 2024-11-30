# USEI07 - Encontrar percurso com número máximo de hubs

**No seguinte documento apresentam-se:**
* Explicação da Resolução
* Dependências
* Testes Unitários

## Explicação da Resolução

Esta funcionalidade visa calcular um caminho que começa num determinado ponto que passe pelo maior número de *hubs* possível, respeitando o horário de cada um deles.

**Nota 1:** Para esta funcionalidade funcionar, é obrigatório todas as localidades terem um horário estabelecido. Caso haja pelo menos uma localidade sem horário definido, a funcionalidade é impedida.

Depois da verificação anterior ter sido passada com sucesso, o utilizador terá de inserir os seguintes elementos:
* Autonomia do veículo (em metros)
* Velocidade média do veículo (em km/h)
* Duração média do carregamento da bateria do veículo (em minutos)
* Duração média do descarregamento dos cabazes do veículo (em minutos)
* Número de hubs no grafo
* Hora a que o percurso irá começar
* ID da localidade considerada como ponto inicial do percurso

Depois destes valores serem inseridos, o *Controller* irá calcular o percurso com o maior número de hubs possível. 

No objeto retornado, é possível obter todos os pontos do percurso, assim como a hora de chegada e de saída em cada um destes, e a distância de cada ponto ao ponto anterior no percurso. O tempo total de viagem e o tempo total de carregamentos e descarregamentos também está contido neste objeto.

**Nota 2:** As localidades que são tornadas em *hubs* são decididas pelos critérios definidos na **USEI02**.

**Nota 3:** Para o grafo não ser permanentemente alterado por esta funcionalidade, esta não tem acesso ao grafo em si, mas só a um clone do mesmo.

## Dependências

Esta *User Story* tem uma dependência nas seguintes *User Stories*:
* Na **USEI01**, visto que essa é a *User Story* que fornece um grafo preenchido ao resto do programa.
* Na **USEI02**, visto que é esta *User Story* que decide quais são as N localidades a serem tornadas em *hubs*.
* Na **USEI11**, visto que é nesta *User Story* que são atribuídos os horários necessários a todas as localidades.

## Testes Unitários

De seguida, foi colocado por baixo um documento de texto com as informações relacionadas aos testes unitários criados para esta funcionalidade.

[Testes Unitários](USEI07Tests.md)