-- Como Gestor Agrícola pretendo saber o fator de produção com 
-- mais aplicações na instalação agrícola num dado intervalo de tempo.

SELECT MAX(COUNT(fatorproducaodesignacao)) AS quantidade
FROM operacao
WHERE operacao.data BETWEEN '06-OCT-16' AND '06-OCT-20'
GROUP BY fatorproducaodesignacao

