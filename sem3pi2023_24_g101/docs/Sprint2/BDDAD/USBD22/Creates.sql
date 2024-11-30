CREATE TABLE Parcela (
    designacaoParcela varchar2(255) NOT NULL,
    areaHa number(19) NOT NULL,
    PRIMARY KEY (designacaoParcela));
CREATE TABLE Cultura (
    variedadeCultura varchar2(255) NOT NULL,
    nomeComum varchar2(255) NOT NULL,
    especie varchar2(255) NOT NULL,
    tipoPlantacao varchar2(255) NOT NULL,
    plantacao varchar2(255),
    poda varchar2(255),
    floracao varchar2(255),
    colheita varchar2(255),
    PRIMARY KEY (variedadeCultura));
CREATE TABLE CulturaParcela (
    designacaoParcela varchar2(255) NOT NULL,
    variedadeCultura varchar2(255) NOT NULL,
    dataInicial date NOT NULL,
    dataFinal date,
    quantidade number(19, 1) NOT NULL,
    PRIMARY KEY (designacaoParcela, variedadeCultura, dataInicial));
CREATE TABLE FatorProducao (
    designacaoFatorProducao varchar2(255) NOT NULL,
    fabricante varchar2(255) NOT NULL,
    formato varchar2(255) NOT NULL,
    tipoFatorProducao varchar2(255) NOT NULL,
    aplicacao varchar2(255) NOT NULL,
    PRIMARY KEY (designacaoFatorProducao));
CREATE TABLE Quimico (
    designacaoQuimico varchar2(255) NOT NULL,
    PRIMARY KEY (designacaoQuimico));
CREATE TABLE FatorProducaoQuimico (
    designacaoFatorProducao varchar2(255) NOT NULL,
    designacaoQuimico varchar2(255) NOT NULL,
    percentagem number(3, 2) NOT NULL,
    PRIMARY KEY (designacaoFatorProducao, designacaoQuimico));
CREATE TABLE ProdutoAgricola (
    nomeProdutoAgricola varchar2(255) NOT NULL,
    variedadeCultura varchar2(255) NOT NULL,
    PRIMARY KEY (nomeProdutoAgricola, variedadeCultura));
CREATE TABLE AplicacaoFitofarmaco (
    designacaoParcela varchar2(255) NOT NULL,
    variedadeCultura varchar2(255) NOT NULL,
    data date NOT NULL,
    quantidade number(19, 2) NOT NULL,
    designacaoFatorProducao varchar2(255) NOT NULL,
    PRIMARY KEY (designacaoParcela, variedadeCultura, data));
CREATE TABLE Colheita (
    designacaoParcela varchar2(255) NOT NULL,
    produtoAgricola varchar2(255) NOT NULL,
    data date NOT NULL,
    quantidade number(19) NOT NULL,
    PRIMARY KEY (designacaoParcela, produtoAgricola, data));
CREATE TABLE FertilizacaoSolo (
    designacaoParcela varchar2(255) NOT NULL,
    modo varchar2(255) NOT NULL,
    data date NOT NULL,
    quantidade number(19) NOT NULL,
    designacaoFatorProducao varchar2(255) NOT NULL,
    area number(10),
    PRIMARY KEY (designacaoParcela, modo, data));
CREATE TABLE FertilizacaoCultura (
    designacaoParcela varchar2(255) NOT NULL,
    modo varchar2(255) NOT NULL,
    data date NOT NULL,
    variedadeCultura varchar2(255) NOT NULL,
    designacaoFatorProducao varchar2(255) NOT NULL,
    quantidade number(19) NOT NULL,
    PRIMARY KEY (designacaoParcela, modo, data, variedadeCultura));
CREATE TABLE IncorporacaoSolo (
    designacaoParcela varchar2(255) NOT NULL,
    variedadeCultura varchar2(255) NOT NULL,
    data date NOT NULL,
    quantidade number(19, 2) NOT NULL,
    PRIMARY KEY (designacaoParcela, variedadeCultura, data));
CREATE TABLE Plantacao (
    designacaoParcela varchar2(255) NOT NULL,
    variedadeCultura varchar2(255) NOT NULL,
    data date NOT NULL,
    quantidade number(19) NOT NULL,
    PRIMARY KEY (designacaoParcela, variedadeCultura, data));
CREATE TABLE Poda (
    designacaoParcela varchar2(255) NOT NULL,
    variedadeCultura varchar2(255) NOT NULL,
    data date NOT NULL,
    quantidade number(19) NOT NULL,
    PRIMARY KEY (designacaoParcela, variedadeCultura, data));
CREATE TABLE Rega (
    designacaoSetor varchar2(255) NOT NULL,
    variedadeCultura varchar2(255) NOT NULL,
    dataInicio date NOT NULL,
    quantidade number(19),
    duracaoMin number(10),
    PRIMARY KEY (designacaoSetor, variedadeCultura, dataInicio));
CREATE TABLE Semeadura (
    designacaoParcela varchar2(255) NOT NULL,
    variedadeCultura varchar2(255) NOT NULL,
    data date NOT NULL,
    quantidade number(19, 2) NOT NULL,
    unidade varchar2(255) NOT NULL,
    PRIMARY KEY (designacaoParcela, variedadeCultura, data));
CREATE TABLE Monda (
    designacaoParcela varchar2(255) NOT NULL,
    variedadeCultura varchar2(255) NOT NULL,
    data date NOT NULL,
    quantidade number(19, 2) NOT NULL,
    PRIMARY KEY (designacaoParcela, variedadeCultura, data));
CREATE TABLE Setor (
    designacaoSetor varchar2(255) NOT NULL,
    caudalMaximo number(19, 2) NOT NULL,
    PRIMARY KEY (designacaoSetor));
CREATE TABLE ParcelaSetor (
    designacaoParcela varchar2(255) NOT NULL,
    designacaoSetor varchar2(255) NOT NULL,
    PRIMARY KEY (designacaoParcela, designacaoSetor));
CREATE TABLE UnidadeCultura (
    tipoPlantacao varchar2(255) NOT NULL,
    unidade varchar2(255) NOT NULL,
    PRIMARY KEY (tipoPlantacao));