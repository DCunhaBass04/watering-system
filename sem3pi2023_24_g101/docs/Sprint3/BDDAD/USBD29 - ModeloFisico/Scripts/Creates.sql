CREATE TABLE Parcela (
    designacaoParcela varchar2(25) NOT NULL,
    area float(10) NOT NULL CHECK(0<area),
    PRIMARY KEY (designacaoParcela)
);

CREATE TABLE Cultura (
    variedadeCultura varchar2(50) NOT NULL,
    nomeComumCultura varchar2(25) NOT NULL,
    tipoPlantacao varchar2(25) NOT NULL,
    especie varchar2(50) NOT NULL,
    PRIMARY KEY (variedadeCultura, nomeComumCultura)
);

CREATE TABLE CulturaParcela (
    designacaoParcela varchar2(25) NOT NULL,
    variedadeCultura varchar2(50) NOT NULL,
    nomeComumCultura varchar2(25) NOT NULL,
    dataInicial date NOT NULL,
    dataFinal date,
    quantidade float(10) NOT NULL CHECK(0<quantidade),
    PRIMARY KEY (designacaoParcela, variedadeCultura, nomeComumCultura)
);

CREATE TABLE FatorProducao (
    designacaoFatorProducao varchar2(50) NOT NULL,
    fabricante varchar2(25) NOT NULL,
    formato varchar2(50) NOT NULL,
    tipo varchar2(25) NOT NULL,
    ph float(3) CHECK(0<=ph AND ph<=14),
    densidadeKgPorL float(3) CHECK(0<densidadeKgPorL),
    PRIMARY KEY (designacaoFatorProducao)
);

CREATE TABLE Substancia (
    designacaoSubstancia varchar2(50) NOT NULL,
    PRIMARY KEY (designacaoSubstancia)
);

CREATE TABLE FatorProducaoSubstancia (
    designacaoFatorProducao varchar2(50) NOT NULL,
    designacaoSubstancia varchar2(50) NOT NULL,
    percentagem float(10) NOT NULL CHECK(0<percentagem AND percentagem<100),
    PRIMARY KEY (designacaoFatorProducao, designacaoSubstancia)
);

CREATE TABLE ProdutoAgricolaCultura (
    produtoAgricolaDesignacao varchar2(50) NOT NULL,
    variedadeCultura varchar2(50) NOT NULL,
    nomeComum varchar2(25) NOT NULL,
    PRIMARY KEY (produtoAgricolaDesignacao, variedadeCultura, nomeComum)
);

CREATE TABLE AplicacaoFatorProducao (
    idOperacao number(10) NOT NULL,
    area float(10) CHECK(0<area),
    PRIMARY KEY (idOperacao)
);

CREATE TABLE Colheita (
    idOperacao number(10) NOT NULL,
    produtoAgricolaDesignacao varchar2(50) NOT NULL,
    designacaoParcela varchar2(25) NOT NULL,
    quantidade float(10) NOT NULL CHECK(0<quantidade),
    PRIMARY KEY (idOperacao)
);

CREATE TABLE AplicacaoFatorSolo (
    idOperacao number(10) NOT NULL,
    designacaoParcela varchar2(25) NOT NULL,
    PRIMARY KEY (idOperacao)
);

CREATE TABLE AplicacaoFatorCultura (
    idOperacao number(10) NOT NULL,
    designacaoParcela varchar2(25) NOT NULL,
    variedadeCultura varchar2(50) NOT NULL,
    nomeComumCultura varchar2(25) NOT NULL,
    modo varchar2(20) NOT NULL,
    PRIMARY KEY (idOperacao)
);

CREATE TABLE IncorporacaoSolo (
    idOperacao number(10) NOT NULL,
    designacaoParcela varchar2(25) NOT NULL,
    variedadeCultura varchar2(50) NOT NULL,
    nomeComumCultura varchar2(25) NOT NULL,
    quantidade float(10) NOT NULL CHECK(0<quantidade),
    PRIMARY KEY (idOperacao)
);

CREATE TABLE Plantacao (
    idOperacao number(10) NOT NULL,
    designacaoParcela varchar2(25) NOT NULL,
    variedadeCultura varchar2(50) NOT NULL,
    nomeComumCultura varchar2(25) NOT NULL,
    quantidade float(10) NOT NULL CHECK(0<quantidade),
    PRIMARY KEY (idOperacao)
);

CREATE TABLE Poda (
    idOperacao number(10) NOT NULL,
    designacaoParcela varchar2(25) NOT NULL,
    variedadeCultura varchar2(50) NOT NULL,
    nomeComumCultura varchar2(25) NOT NULL,
    quantidade float(10) NOT NULL CHECK(0<quantidade),
    PRIMARY KEY (idOperacao)
);

CREATE TABLE Rega (
    idOperacao number(10) NOT NULL,
    designacaoSetor varchar2(25) NOT NULL,
    dataHora timestamp(0) NOT NULL,
    duracaoMin number(10) NOT NULL CHECK(0<duracaoMin),
    PRIMARY KEY (idOperacao)
);

CREATE TABLE Semeadura (
    idOperacao number(10) NOT NULL,
    designacaoParcela varchar2(25) NOT NULL,
    variedadeCultura varchar2(50) NOT NULL,
    nomeComumCultura varchar2(25) NOT NULL,
    quantidade float(10) NOT NULL CHECK(quantidade > 0),
    unidade varchar2(10) NOT NULL,
    PRIMARY KEY (idOperacao)
);

CREATE TABLE Monda (
    idOperacao number(10) NOT NULL,
    designacaoParcela varchar2(25) NOT NULL,
    variedadeCultura varchar2(50) NOT NULL,
    nomeComumCultura varchar2(25) NOT NULL,
    quantidade float(10) NOT NULL CHECK(0<quantidade),
    PRIMARY KEY (idOperacao)
);

CREATE TABLE Setor (
    designacaoSetor varchar2(25) NOT NULL,
    caudalMaximo float(10) NOT NULL CHECK(0<caudalMaximo),
    dataInicio date NOT NULL,
    dataFinal date,
    PRIMARY KEY (designacaoSetor)
);

CREATE TABLE ParcelaSetor (
    designacaoParcela varchar2(25) NOT NULL,
    designacaoSetor varchar2(25) NOT NULL,
    PRIMARY KEY (designacaoParcela, designacaoSetor)
);

CREATE TABLE CulturaSetor (
    designacaoSetor varchar2(25) NOT NULL,
    variedadeCultura varchar2(50) NOT NULL,
    nomeComumCultura varchar2(25) NOT NULL,
    PRIMARY KEY (designacaoSetor, variedadeCultura, nomeComumCultura)
);

CREATE TABLE UnidadeCultura (
    tipoPlantacao varchar2(25) NOT NULL,
    unidade varchar2(10) NOT NULL,
    PRIMARY KEY (tipoPlantacao)
);

CREATE TABLE Receita (
    designacao varchar2(50) NOT NULL,
    PRIMARY KEY (designacao)
);

CREATE TABLE ReceitaFator (
    designacaoReceita varchar2(50) NOT NULL,
    designacaoFatorProducao varchar2(50) NOT NULL,
    quantidade float(10) NOT NULL CHECK(0<quantidade),
    unidade varchar2(10) NOT NULL,
    PRIMARY KEY (designacaoReceita, designacaoFatorProducao)
);

CREATE TABLE Operacao (
    idOperacao number(10) NOT NULL,
    data date NOT NULL,
    instante timestamp(0) NOT NULL,
    estado varchar2(25) NOT NULL,
    PRIMARY KEY (idOperacao)
);

CREATE TABLE LogOperacao (
    idOperacao number(10) NOT NULL,
    tipoOperacao varchar2(50) NOT NULL,
    tipoLog varchar2(50) NOT NULL,
    data date NOT NULL,
    instante timestamp(0) NOT NULL,
    designacaoSetor varchar2(25),
    designacaoParcela varchar2(25),
    variedadeCultura varchar2(50),
    nomeComumCultura varchar2(25),
    produtoAgricola varchar2(50),
    quantidade number(10) CHECK(0<quantidade),
    unidade varchar2(10),
    duracao number(10),
    designacaoFatorProducao varchar2(50),
    PRIMARY KEY (idOperacao, tipoOperacao, tipoLog, data, instante)
);

CREATE TABLE ProdutoAgricola (
    produtoAgricolaDesignacao varchar2(50) NOT NULL,
    PRIMARY KEY (produtoAgricolaDesignacao)
);

CREATE TABLE ProdutoAgricolaParcela (
    produtoAgricolaDesignacao varchar2(50) NOT NULL,
    designacaoParcela varchar2(25) NOT NULL,
    PRIMARY KEY (produtoAgricolaDesignacao, designacaoParcela)
);

CREATE TABLE AplicacaoFatorSetor (
    idOperacao number(10) NOT NULL,
    designacaoSetor varchar2(25) NOT NULL,
    PRIMARY KEY (idOperacao)
);

CREATE TABLE FatoresProducaoAplicados (
    idOperacao number(10) NOT NULL,
    designacaoFatorProducao varchar2(50) NOT NULL,
    quantidade float(10) NOT NULL CHECK(0<quantidade),
    PRIMARY KEY (idOperacao, designacaoFatorProducao)
);

CREATE TABLE FatorProducaoFabricante (
    fabricante varchar2(25) NOT NULL,
    PRIMARY KEY (fabricante)
);

CREATE TABLE AplicacaoModo (
    modo varchar2(20) NOT NULL,
    PRIMARY KEY (modo)
);

CREATE TABLE FatorProducaoFormato (
    formato varchar2(50) NOT NULL,
    PRIMARY KEY (formato)
);

CREATE TABLE FatorProducaoTipo (
    tipo varchar2(25) NOT NULL,
    PRIMARY KEY (tipo)
);

CREATE TABLE TipoAplicacao (
    aplicacao varchar2(50) NOT NULL,
    PRIMARY KEY (aplicacao)
);

CREATE TABLE TipoAplicacaoFatorProducao (
    designacaoFatorProducao varchar2(50) NOT NULL,
    aplicacao varchar2(50) NOT NULL,
    PRIMARY KEY (designacaoFatorProducao)
);

CREATE TABLE Unidade (
    unidade varchar2(10) NOT NULL,
    PRIMARY KEY (unidade)
);

CREATE TABLE EspecieCultura (
    especie varchar2(50) NOT NULL,
    PRIMARY KEY (especie)
);

CREATE TABLE EstadoOperacao (
    estado varchar2(25) NOT NULL,
    PRIMARY KEY (estado)
);

CREATE TABLE TipoOperacao (
    tipo varchar2(50) NOT NULL,
    PRIMARY KEY (tipo)
);

CREATE TABLE TipoLog (
    tipo varchar2(50) NOT NULL,
    PRIMARY KEY (tipo)
);
