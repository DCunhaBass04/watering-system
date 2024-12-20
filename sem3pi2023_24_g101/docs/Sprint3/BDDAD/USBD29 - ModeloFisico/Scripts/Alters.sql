ALTER TABLE CulturaParcela ADD CONSTRAINT FKCulturaPar602640 FOREIGN KEY (designacaoParcela) REFERENCES Parcela (designacaoParcela);
ALTER TABLE CulturaParcela ADD CONSTRAINT FKCulturaPar240369 FOREIGN KEY (variedadeCultura, nomeComumCultura) REFERENCES Cultura (variedadeCultura, nomeComumCultura);
ALTER TABLE ProdutoAgricolaCultura ADD CONSTRAINT FKProdutoAgr959364 FOREIGN KEY (variedadeCultura, nomeComum) REFERENCES Cultura (variedadeCultura, nomeComumCultura);
ALTER TABLE AplicacaoFatorSolo ADD CONSTRAINT FKAplicacaoF385809 FOREIGN KEY (designacaoParcela) REFERENCES Parcela (designacaoParcela);
ALTER TABLE ParcelaSetor ADD CONSTRAINT FKParcelaSet298204 FOREIGN KEY (designacaoParcela) REFERENCES Parcela (designacaoParcela);
ALTER TABLE ParcelaSetor ADD CONSTRAINT FKParcelaSet783859 FOREIGN KEY (designacaoSetor) REFERENCES Setor (designacaoSetor);
ALTER TABLE CulturaSetor ADD CONSTRAINT FKCulturaSet63248 FOREIGN KEY (designacaoSetor) REFERENCES Setor (designacaoSetor);
ALTER TABLE CulturaSetor ADD CONSTRAINT FKCulturaSet52178 FOREIGN KEY (variedadeCultura, nomeComumCultura) REFERENCES Cultura (variedadeCultura, nomeComumCultura);
ALTER TABLE Rega ADD CONSTRAINT FKRega164767 FOREIGN KEY (designacaoSetor) REFERENCES Setor (designacaoSetor);
ALTER TABLE Cultura ADD CONSTRAINT FKCultura364460 FOREIGN KEY (tipoPlantacao) REFERENCES UnidadeCultura (tipoPlantacao);
ALTER TABLE ReceitaFator ADD CONSTRAINT FKReceitaFat378990 FOREIGN KEY (designacaoReceita) REFERENCES Receita (designacao);
ALTER TABLE ReceitaFator ADD CONSTRAINT FKReceitaFat607813 FOREIGN KEY (designacaoFatorProducao) REFERENCES FatorProducao (designacaoFatorProducao);
ALTER TABLE Plantacao ADD CONSTRAINT FKPlantacao228914 FOREIGN KEY (idOperacao) REFERENCES Operacao (idOperacao);
ALTER TABLE Colheita ADD CONSTRAINT FKColheita605445 FOREIGN KEY (idOperacao) REFERENCES Operacao (idOperacao);
ALTER TABLE IncorporacaoSolo ADD CONSTRAINT FKIncorporac76173 FOREIGN KEY (idOperacao) REFERENCES Operacao (idOperacao);
ALTER TABLE Semeadura ADD CONSTRAINT FKSemeadura613384 FOREIGN KEY (idOperacao) REFERENCES Operacao (idOperacao);
ALTER TABLE Monda ADD CONSTRAINT FKMonda54896 FOREIGN KEY (idOperacao) REFERENCES Operacao (idOperacao);
ALTER TABLE Poda ADD CONSTRAINT FKPoda88645 FOREIGN KEY (idOperacao) REFERENCES Operacao (idOperacao);
ALTER TABLE Rega ADD CONSTRAINT FKRega38580 FOREIGN KEY (idOperacao) REFERENCES Operacao (idOperacao);
ALTER TABLE AplicacaoFatorProducao ADD CONSTRAINT FKAplicacaoF136092 FOREIGN KEY (idOperacao) REFERENCES Operacao (idOperacao);
ALTER TABLE LogOperacao ADD CONSTRAINT FKLogOperaca237741 FOREIGN KEY (idOperacao) REFERENCES Operacao (idOperacao);
ALTER TABLE FatorProducaoSubstancia ADD CONSTRAINT FKFatorProdu764205 FOREIGN KEY (designacaoFatorProducao) REFERENCES FatorProducao (designacaoFatorProducao);
ALTER TABLE ProdutoAgricolaCultura ADD CONSTRAINT FKProdutoAgr343345 FOREIGN KEY (produtoAgricolaDesignacao) REFERENCES ProdutoAgricola (produtoAgricolaDesignacao);
ALTER TABLE ProdutoAgricolaParcela ADD CONSTRAINT FKProdutoAgr708392 FOREIGN KEY (produtoAgricolaDesignacao) REFERENCES ProdutoAgricola (produtoAgricolaDesignacao);
ALTER TABLE ProdutoAgricolaParcela ADD CONSTRAINT FKProdutoAgr921106 FOREIGN KEY (designacaoParcela) REFERENCES Parcela (designacaoParcela);
ALTER TABLE Poda ADD CONSTRAINT FKPoda20065 FOREIGN KEY (designacaoParcela, variedadeCultura, nomeComumCultura) REFERENCES CulturaParcela (designacaoParcela, variedadeCultura, nomeComumCultura);
ALTER TABLE Semeadura ADD CONSTRAINT FKSemeadura249496 FOREIGN KEY (designacaoParcela, variedadeCultura, nomeComumCultura) REFERENCES CulturaParcela (designacaoParcela, variedadeCultura, nomeComumCultura);
ALTER TABLE AplicacaoFatorCultura ADD CONSTRAINT FKAplicacaoF23390 FOREIGN KEY (designacaoParcela, variedadeCultura, nomeComumCultura) REFERENCES CulturaParcela (designacaoParcela, variedadeCultura, nomeComumCultura);
ALTER TABLE AplicacaoFatorCultura ADD CONSTRAINT FKAplicacaoF712970 FOREIGN KEY (idOperacao) REFERENCES AplicacaoFatorProducao (idOperacao);
ALTER TABLE AplicacaoFatorSolo ADD CONSTRAINT FKAplicacaoF959532 FOREIGN KEY (idOperacao) REFERENCES AplicacaoFatorProducao (idOperacao);
ALTER TABLE AplicacaoFatorSetor ADD CONSTRAINT FKAplicacaoF134120 FOREIGN KEY (idOperacao) REFERENCES AplicacaoFatorProducao (idOperacao);
ALTER TABLE AplicacaoFatorSetor ADD CONSTRAINT FKAplicacaoF6473 FOREIGN KEY (designacaoSetor) REFERENCES Setor (designacaoSetor);
ALTER TABLE FatoresProducaoAplicados ADD CONSTRAINT FKFatoresPro490273 FOREIGN KEY (designacaoFatorProducao) REFERENCES FatorProducao (designacaoFatorProducao);
ALTER TABLE FatoresProducaoAplicados ADD CONSTRAINT FKFatoresPro404775 FOREIGN KEY (idOperacao) REFERENCES AplicacaoFatorProducao (idOperacao);
ALTER TABLE Plantacao ADD CONSTRAINT FKPlantacao879795 FOREIGN KEY (designacaoParcela, variedadeCultura, nomeComumCultura) REFERENCES CulturaParcela (designacaoParcela, variedadeCultura, nomeComumCultura);
ALTER TABLE IncorporacaoSolo ADD CONSTRAINT FKIncorporac32537 FOREIGN KEY (designacaoParcela, variedadeCultura, nomeComumCultura) REFERENCES CulturaParcela (designacaoParcela, variedadeCultura, nomeComumCultura);
ALTER TABLE Colheita ADD CONSTRAINT FKColheita967530 FOREIGN KEY (produtoAgricolaDesignacao, designacaoParcela) REFERENCES ProdutoAgricolaParcela (produtoAgricolaDesignacao, designacaoParcela);
ALTER TABLE Monda ADD CONSTRAINT FKMonda917776 FOREIGN KEY (designacaoParcela, variedadeCultura, nomeComumCultura) REFERENCES CulturaParcela (designacaoParcela, variedadeCultura, nomeComumCultura);
ALTER TABLE FatorProducao ADD CONSTRAINT FKFatorProdu465001 FOREIGN KEY (fabricante) REFERENCES FatorProducaoFabricante (fabricante);
ALTER TABLE AplicacaoFatorCultura ADD CONSTRAINT FKAplicacaoF15244 FOREIGN KEY (modo) REFERENCES AplicacaoModo (modo);
ALTER TABLE FatorProducao ADD CONSTRAINT FKFatorProdu501342 FOREIGN KEY (formato) REFERENCES FatorProducaoFormato (formato);
ALTER TABLE FatorProducao ADD CONSTRAINT FKFatorProdu62802 FOREIGN KEY (tipo) REFERENCES FatorProducaoTipo (tipo);
ALTER TABLE TipoAplicacaoFatorProducao ADD CONSTRAINT FKTipoAplica423020 FOREIGN KEY (aplicacao) REFERENCES TipoAplicacao (aplicacao);
ALTER TABLE TipoAplicacaoFatorProducao ADD CONSTRAINT FKTipoAplica527981 FOREIGN KEY (designacaoFatorProducao) REFERENCES FatorProducao (designacaoFatorProducao);
ALTER TABLE UnidadeCultura ADD CONSTRAINT FKUnidadeCul109569 FOREIGN KEY (unidade) REFERENCES Unidade (unidade);
ALTER TABLE ReceitaFator ADD CONSTRAINT FKReceitaFat820495 FOREIGN KEY (unidade) REFERENCES Unidade (unidade);
ALTER TABLE Semeadura ADD CONSTRAINT FKSemeadura849593 FOREIGN KEY (unidade) REFERENCES Unidade (unidade);
ALTER TABLE Cultura ADD CONSTRAINT FKCultura772225 FOREIGN KEY (especie) REFERENCES EspecieCultura (especie);
ALTER TABLE Operacao ADD CONSTRAINT FKOperacao992195 FOREIGN KEY (estado) REFERENCES EstadoOperacao (estado);
ALTER TABLE LogOperacao ADD CONSTRAINT FKLogOperaca187383 FOREIGN KEY (tipoOperacao) REFERENCES TipoOperacao (tipo);
ALTER TABLE LogOperacao ADD CONSTRAINT FKLogOperaca721495 FOREIGN KEY (tipoLog) REFERENCES TipoLog (tipo);
