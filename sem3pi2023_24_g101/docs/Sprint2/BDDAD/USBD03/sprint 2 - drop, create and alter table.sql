DROP TABLE Rega;
DROP TABLE PlanoRega;
DROP TABLE Planta;
DROP TABLE ExploracaoAgricola;
DROP TABLE Cultura;
DROP TABLE Operacao;
DROP TABLE FatorProducao;
DROP TABLE Quimico;
DROP TABLE "FatorProducao/Planta";


CREATE TABLE Rega (
  PlanoRegaid          number(10) NOT NULL, 
  ExploracaoAgricolaid number(10) NOT NULL, 
  duracao              number(10) NOT NULL, 
  regularidade         char(1) NOT NULL);

CREATE TABLE PlanoRega (
  id         number(10) NOT NULL, 
  dataInicio date NOT NULL, 
  dataFim    date NOT NULL);

CREATE TABLE Planta (
  id                  number(10) NOT NULL, 
  especie             varchar2(50) NOT NULL, 
  nomeComum           varchar2(50) NOT NULL, 
  variedade           varchar2(50) NOT NULL, 
  tipoPlantacao       varchar2(50) NOT NULL, 
  sementariaPlantacao varchar2(50), 
  poda                varchar2(50), 
  floracao            varchar2(50), 
  colheita            varchar2(50));

CREATE TABLE ExploracaoAgricola (
  id         number(10) NOT NULL, 
  tipo       varchar2(50) NOT NULL, 
  designacao varchar2(50) NOT NULL, 
  area       number(10), 
  unidade    varchar2(5));

CREATE TABLE Cultura (
  id                   number(10) NOT NULL, 
  nome                 varchar2(50) NOT NULL, 
  tipo                 varchar2(50) NOT NULL, 
  dataInicio           date NOT NULL, 
  dataFim              date, 
  quantidade           number(10) NOT NULL, 
  unidade              varchar2(5) NOT NULL, 
  ExploracaoAgricolaid number(10) NOT NULL);

CREATE TABLE Operacao (
  id                      number(10) NOT NULL, 
  tipo                    varchar2(50) NOT NULL, 
  modo                    varchar2(50), 
  data                    date NOT NULL, 
  quantidade              number(10), 
  unidade                 varchar2(5), 
  Culturaid               number(10), 
  FatorProducaodesignacao varchar2(50), 
  ExploracaoAgricolaid    number(10) NOT NULL);

CREATE TABLE FatorProducao (
  designacao varchar2(50) NOT NULL, 
  fabricante varchar2(50) NOT NULL, 
  formato    varchar2(50) NOT NULL, 
  tipo       varchar2(50) NOT NULL, 
  aplicacao  varchar2(50) NOT NULL);

CREATE TABLE Quimico (
  nomeComercial           varchar2(50) NOT NULL, 
  percentagem             float(5) NOT NULL, 
  FatorProducaodesignacao varchar2(50) NOT NULL);

CREATE TABLE "FatorProducao/Planta" (
  FatorProducaodesignacao varchar2(50) NOT NULL, 
  Plantaid                number(10) NOT NULL);



ALTER TABLE Rega ADD PRIMARY KEY (PlanoRegaid, ExploracaoAgricolaid);
ALTER TABLE PlanoRega ADD PRIMARY KEY (id);
ALTER TABLE Planta ADD PRIMARY KEY (id);
ALTER TABLE ExploracaoAgricola ADD PRIMARY KEY (id);
ALTER TABLE Cultura ADD PRIMARY KEY (id);
ALTER TABLE Operacao ADD PRIMARY KEY (id);
ALTER TABLE FatorProducao ADD PRIMARY KEY (designacao);
ALTER TABLE Quimico ADD PRIMARY KEY (nomeComercial, percentagem);
ALTER TABLE "FatorProducao/Planta" ADD PRIMARY KEY (FatorProducaodesignacao, Plantaid);