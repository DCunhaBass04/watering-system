--Este é o primeiro tipo que tem de ser criado antes de rodar o procedimento

CREATE TYPE ReceitaFatorEntrada IS OBJECT (
    designacaoFatorProducao VARCHAR2(100),
    quantidade FLOAT(10),
    unidade VARCHAR2(50)
);