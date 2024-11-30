## Explicação da resolução

O objetivo desta us era mover uma certa quantidade de números de um buffer circular para um array.
Como tal, dada a natureza da estrutura de um buffer circular, o apontador write não é movido. 

O algoritmo desenvolvido
apenas move o apontador read o número de vezes da quantidade de números a transferir. Caso atinga o um endereço inválido, 
isto é, o endereço a seguir ao ultimo elemento do buffer, e ainda existirem números por ler, então o apontador read volta 
para o início do buffer. Por outras palavras, circula o mesmo. 

Exemplo do ficheiro de output: [Read operation.txt](files/Read operation.txt)

Foram também implementados uns testes básicos que verificam
se a quantidade de números a transferir é menor ou igual à quantidade de números existentes no buffer circular.

## Testes Unitários

[Testes Unitários](USAC03Tests.md)