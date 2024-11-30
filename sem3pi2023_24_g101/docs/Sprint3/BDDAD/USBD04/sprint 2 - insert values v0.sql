INSERT INTO cultura (id, nome, tipo, dataInicio, dataFim, quantidade, unidade, exploracaoAgricolaid) VALUES (1, 'Oliveira Galega', 'Permanente', DATE '2016-10-06', NULL, '30', 'un', '102');
INSERT INTO cultura (id, nome, tipo, dataInicio, dataFim, quantidade, unidade, exploracaoAgricolaid) VALUES (2, 'Oliveira Picual', 'Permanente', DATE '2016-10-10', NULL, '20', 'un', '102');
INSERT INTO cultura (id, nome, tipo, dataInicio, dataFim, quantidade, unidade, exploracaoAgricolaid) VALUES (3, 'Macieira Jonagored', 'Permanente', DATE '2017-01-07', NULL, '90', 'un', '104');
INSERT INTO cultura (id, nome, tipo, dataInicio, dataFim, quantidade, unidade, exploracaoAgricolaid) VALUES (4, 'Macieira Fuji', 'Permanente', DATE '2017-01-08', NULL, '60', 'un', '104');
INSERT INTO cultura (id, nome, tipo, dataInicio, dataFim, quantidade, unidade, exploracaoAgricolaid) VALUES (5, 'Macieira Royal Gala', 'Permanente', DATE '2017-01-08', NULL, '40', 'un', '104');
INSERT INTO cultura (id, nome, tipo, dataInicio, dataFim, quantidade, unidade, exploracaoAgricolaid) VALUES (6, 'Macieira Royal Gala', 'Permanente', DATE '2018-12-10', NULL, '30', 'un', '104');
INSERT INTO cultura (id, nome, tipo, dataInicio, dataFim, quantidade, unidade, exploracaoAgricolaid) VALUES (7, 'Tremoço Amarelo', 'Temporária', DATE '2020-10-10', DATE '2021-03-30', '1.1', 'ha', '101');
INSERT INTO cultura (id, nome, tipo, dataInicio, dataFim, quantidade, unidade, exploracaoAgricolaid) VALUES (8, 'Milho Doce Golden Bantam', 'Temporária', DATE '2021-04-10', DATE '2021-08-12', '0.9', 'ha', '101');
INSERT INTO cultura (id, nome, tipo, dataInicio, dataFim, quantidade, unidade, exploracaoAgricolaid) VALUES (9, 'Milho Doce Golden Bantam', 'Temporária', DATE '2021-04-15', DATE '2021-08-21', '0.9', 'ha', '101');
INSERT INTO cultura (id, nome, tipo, dataInicio, dataFim, quantidade, unidade, exploracaoAgricolaid) VALUES (10, 'Tremoço Amarelo', 'Temporária', DATE '2021-10-03', DATE '2022-04-05', '1.1', 'ha', '101');

INSERT INTO exploracaoAgricola (id, tipo, designacao, area, unidade) VALUES (101, 'Parcela', 'Campo da bouça', '1.2', 'ha');
INSERT INTO exploracaoAgricola (id, tipo, designacao, area, unidade) VALUES (102, 'Parcela', 'Campo grande', '3', 'ha');
INSERT INTO exploracaoAgricola (id, tipo, designacao, area, unidade) VALUES (103, 'Parcela', 'Campo do poço', '1.5', 'ha');
INSERT INTO exploracaoAgricola (id, tipo, designacao, area, unidade) VALUES (104, 'Parcela', 'Lameiro da ponte', '0.8', 'ha');
INSERT INTO exploracaoAgricola (id, tipo, designacao, area, unidade) VALUES (105, 'Parcela', 'Lameiro do moinho', '1.1', 'ha');
INSERT INTO exploracaoAgricola (id, tipo, designacao, area, unidade) VALUES (106, 'Parcela', 'Horta', '0.1', 'ha');
INSERT INTO exploracaoAgricola (id, tipo, designacao, area, unidade) VALUES (201, 'Armazém', 'Espigueiro', '600', 'm2');
INSERT INTO exploracaoAgricola (id, tipo, designacao, area, unidade) VALUES (202, 'Armazém', 'Armazém novo', '800', 'm2');
INSERT INTO exploracaoAgricola (id, tipo, designacao, area, unidade) VALUES (203, 'Garagem', 'Armazém grande', '900', 'm2');
INSERT INTO exploracaoAgricola (id, tipo, designacao, area, unidade) VALUES (250, 'Moinho', 'Moinho', NULL, NULL);
INSERT INTO exploracaoAgricola (id, tipo, designacao, area, unidade) VALUES (301, 'Rega', 'Tanque do campo grande', '15', 'm3');

INSERT INTO operacao (id, tipo, modo, data, quantidade, unidade, exploracaoAgricolaid, culturaId, fatorProducaodesignacao) VALUES (1, 'Plantação', NULL, DATE '2016-10-06', '30', 'un', '102', '1', NULL);
INSERT INTO operacao (id, tipo, modo, data, quantidade, unidade, exploracaoAgricolaid, culturaId, fatorProducaodesignacao) VALUES (2, 'Plantação', NULL, DATE '2016-10-10', '20', 'un', '102', '2', NULL);
INSERT INTO operacao (id, tipo, modo, data, quantidade, unidade, exploracaoAgricolaid, culturaId, fatorProducaodesignacao) VALUES (3, 'Plantação', NULL, DATE '2017-01-07', '90', 'un', '104', '3', NULL);
INSERT INTO operacao (id, tipo, modo, data, quantidade, unidade, exploracaoAgricolaid, culturaId, fatorProducaodesignacao) VALUES (4, 'Plantação', NULL, DATE '2017-01-08', '60', 'un', '104', '4', NULL);
INSERT INTO operacao (id, tipo, modo, data, quantidade, unidade, exploracaoAgricolaid, culturaId, fatorProducaodesignacao) VALUES (5, 'Plantação', NULL, DATE '2017-01-08', '40', 'un', '104', '5', NULL);
INSERT INTO operacao (id, tipo, modo, data, quantidade, unidade, exploracaoAgricolaid, culturaId, fatorProducaodesignacao) VALUES (6, 'Plantação', NULL, DATE '2018-12-10', '30', 'un', '104', '5', NULL);
INSERT INTO operacao (id, tipo, modo, data, quantidade, unidade, exploracaoAgricolaid, culturaId, fatorProducaodesignacao) VALUES (7, 'Sementeira', NULL, DATE '2020-10-10', NULL, NULL, '101', '7', NULL);
INSERT INTO operacao (id, tipo, modo, data, quantidade, unidade, exploracaoAgricolaid, culturaId, fatorProducaodesignacao) VALUES (8, 'Poda', NULL, DATE '2020-12-05', '70', 'un', '104', '5', NULL);
INSERT INTO operacao (id, tipo, modo, data, quantidade, unidade, exploracaoAgricolaid, culturaId, fatorProducaodesignacao) VALUES (9, 'Poda', NULL, DATE '2020-12-05', '50', 'un', '104', '3', NULL);
INSERT INTO operacao (id, tipo, modo, data, quantidade, unidade, exploracaoAgricolaid, culturaId, fatorProducaodesignacao) VALUES (10, 'Poda', NULL, DATE '2020-12-15', '40', 'un', '104', '3', NULL);
INSERT INTO operacao (id, tipo, modo, data, quantidade, unidade, exploracaoAgricolaid, culturaId, fatorProducaodesignacao) VALUES (11, 'Poda', NULL, DATE '2020-12-15', '60', 'un', '104', '4', NULL);
INSERT INTO operacao (id, tipo, modo, data, quantidade, unidade, exploracaoAgricolaid, culturaId, fatorProducaodesignacao) VALUES (12, 'Incorporação no solo', NULL, DATE '2021-03-30', NULL, NULL, '101', '7', NULL);
INSERT INTO operacao (id, tipo, modo, data, quantidade, unidade, exploracaoAgricolaid, culturaId, fatorProducaodesignacao) VALUES (13, 'Sementeira', NULL, DATE '2021-04-15', NULL, NULL, '101', '8', NULL);
INSERT INTO operacao (id, tipo, modo, data, quantidade, unidade, exploracaoAgricolaid, culturaId, fatorProducaodesignacao) VALUES (14, 'Fertilização', 'Foliar', DATE '2021-05-02', '10', 'kg', '104', '5', 'EPSO Microtop');
INSERT INTO operacao (id, tipo, modo, data, quantidade, unidade, exploracaoAgricolaid, culturaId, fatorProducaodesignacao) VALUES (15, 'Rega', NULL, DATE '2021-07-05', '5', 'm3', '104', '5', NULL);
INSERT INTO operacao (id, tipo, modo, data, quantidade, unidade, exploracaoAgricolaid, culturaId, fatorProducaodesignacao) VALUES (16, 'Colheita', NULL, DATE '2021-08-21', '3300', 'kg', '101', '8', NULL);
INSERT INTO operacao (id, tipo, modo, data, quantidade, unidade, exploracaoAgricolaid, culturaId, fatorProducaodesignacao) VALUES (17, 'Colheita', NULL, DATE '2021-08-24', '900', 'kg', '104', '5', NULL);
INSERT INTO operacao (id, tipo, modo, data, quantidade, unidade, exploracaoAgricolaid, culturaId, fatorProducaodesignacao) VALUES (18, 'Colheita', NULL, DATE '2021-09-05', '800', 'kg', '104', '5', NULL);
INSERT INTO operacao (id, tipo, modo, data, quantidade, unidade, exploracaoAgricolaid, culturaId, fatorProducaodesignacao) VALUES (19, 'Colheita', NULL, DATE '2021-09-12', '800', 'kg', '104', '3', NULL);
INSERT INTO operacao (id, tipo, modo, data, quantidade, unidade, exploracaoAgricolaid, culturaId, fatorProducaodesignacao) VALUES (20, 'Colheita', NULL, DATE '2021-09-23', '1200', 'kg', '104', '3', NULL);
INSERT INTO operacao (id, tipo, modo, data, quantidade, unidade, exploracaoAgricolaid, culturaId, fatorProducaodesignacao) VALUES (21, 'Sementeira', NULL, DATE '2021-10-03', NULL, NULL, '101', '7', NULL);
INSERT INTO operacao (id, tipo, modo, data, quantidade, unidade, exploracaoAgricolaid, culturaId, fatorProducaodesignacao) VALUES (22, 'Colheita', NULL, DATE '2021-10-12', '950', 'kg', '104', '4', NULL);
INSERT INTO operacao (id, tipo, modo, data, quantidade, unidade, exploracaoAgricolaid, culturaId, fatorProducaodesignacao) VALUES (23, 'Colheita', NULL, DATE '2021-11-03', '750', 'kg', '104', '4', NULL);
INSERT INTO operacao (id, tipo, modo, data, quantidade, unidade, exploracaoAgricolaid, culturaId, fatorProducaodesignacao) VALUES (24, 'Poda', NULL, DATE '2021-11-28', '70', 'un', '104', '5', NULL);
INSERT INTO operacao (id, tipo, modo, data, quantidade, unidade, exploracaoAgricolaid, culturaId, fatorProducaodesignacao) VALUES (25, 'Poda', NULL, DATE '2021-12-03', '90', 'un', '104', '3', NULL);
INSERT INTO operacao (id, tipo, modo, data, quantidade, unidade, exploracaoAgricolaid, culturaId, fatorProducaodesignacao) VALUES (26, 'Poda', NULL, DATE '2021-12-18', '60', 'un', '104', '4', NULL);
INSERT INTO operacao (id, tipo, modo, data, quantidade, unidade, exploracaoAgricolaid, culturaId, fatorProducaodesignacao) VALUES (27, 'Incorporação no solo', NULL, DATE '2022-04-05', NULL, NULL, '101', '7', NULL);
INSERT INTO operacao (id, tipo, modo, data, quantidade, unidade, exploracaoAgricolaid, culturaId, fatorProducaodesignacao) VALUES (28, 'Sementeira', NULL, DATE '2022-04-10', NULL, NULL, '101', '8', NULL);
INSERT INTO operacao (id, tipo, modo, data, quantidade, unidade, exploracaoAgricolaid, culturaId, fatorProducaodesignacao) VALUES (29, 'Fertilização', 'Foliar', DATE '2022-05-13', '10', 'kg', '104', '5', 'EPSO Microtop');
INSERT INTO operacao (id, tipo, modo, data, quantidade, unidade, exploracaoAgricolaid, culturaId, fatorProducaodesignacao) VALUES (30, 'Colheita', NULL, DATE '2022-08-12', '3500', 'kg', '101', '8', NULL);
INSERT INTO operacao (id, tipo, modo, data, quantidade, unidade, exploracaoAgricolaid, culturaId, fatorProducaodesignacao) VALUES (31, 'Colheita', NULL, DATE '2022-08-20', '950', 'kg', '104', '5', NULL);
INSERT INTO operacao (id, tipo, modo, data, quantidade, unidade, exploracaoAgricolaid, culturaId, fatorProducaodesignacao) VALUES (32, 'Colheita', NULL, DATE '2022-09-07', '830', 'kg', '104', '5', NULL);
INSERT INTO operacao (id, tipo, modo, data, quantidade, unidade, exploracaoAgricolaid, culturaId, fatorProducaodesignacao) VALUES (33, 'Colheita', NULL, DATE '2022-09-11', '750', 'kg', '104', '3', NULL);
INSERT INTO operacao (id, tipo, modo, data, quantidade, unidade, exploracaoAgricolaid, culturaId, fatorProducaodesignacao) VALUES (34, 'Colheita', NULL, DATE '2022-09-20', '1150', 'kg', '104', '3', NULL);
INSERT INTO operacao (id, tipo, modo, data, quantidade, unidade, exploracaoAgricolaid, culturaId, fatorProducaodesignacao) VALUES (35, 'Colheita', NULL, DATE '2022-10-17', '850', 'kg', '104', '4', NULL);
INSERT INTO operacao (id, tipo, modo, data, quantidade, unidade, exploracaoAgricolaid, culturaId, fatorProducaodesignacao) VALUES (36, 'Colheita', NULL, DATE '2022-11-06', '900', 'kg', '104', '4', NULL);
INSERT INTO operacao (id, tipo, modo, data, quantidade, unidade, exploracaoAgricolaid, culturaId, fatorProducaodesignacao) VALUES (37, 'Poda', NULL, DATE '2022-12-04', '70', 'un', '104', '5', NULL);
INSERT INTO operacao (id, tipo, modo, data, quantidade, unidade, exploracaoAgricolaid, culturaId, fatorProducaodesignacao) VALUES (38, 'Poda', NULL, DATE '2022-12-07', '90', 'un', '104', '3', NULL);
INSERT INTO operacao (id, tipo, modo, data, quantidade, unidade, exploracaoAgricolaid, culturaId, fatorProducaodesignacao) VALUES (39, 'Poda', NULL, DATE '2023-01-12', '60', 'un', '104', '4', NULL);


INSERT INTO fatorProducao (designacao, fabricante, formato, tipo, aplicacao) VALUES ('Calda Bordalesa ASCENZA', 'ASCENZA', 'Pó molhável', 'Fitofármaco', 'Fungicida');
INSERT INTO fatorProducao (designacao, fabricante, formato, tipo, aplicacao) VALUES ('Enxofre Bayer 80 WG', 'Bayer', 'Pó molhável', 'Fitofármaco', 'Fungicida');
INSERT INTO fatorProducao (designacao, fabricante, formato, tipo, aplicacao) VALUES ('Patentkali', 'K+S', 'Granulado', 'Adubo', 'Adubo solo');
INSERT INTO fatorProducao (designacao, fabricante, formato, tipo, aplicacao) VALUES ('ESTA Kieserit', 'K+S', 'Granulado', 'Adubo', 'Adubo solo');
INSERT INTO fatorProducao (designacao, fabricante, formato, tipo, aplicacao) VALUES ('EPSO Microtop', 'K+S', 'Granulado', 'Adubo', 'Adubo foliar+Fertirrega');
INSERT INTO fatorProducao (designacao, fabricante, formato, tipo, aplicacao) VALUES ('EPSO Top', 'K+S', 'Granulado', 'Adubo', 'Adubo foliar');
INSERT INTO fatorProducao (designacao, fabricante, formato, tipo, aplicacao) VALUES ('Biocal CaCo3', 'Biocal', 'Granulado', 'Corretor', 'Correção solo');
INSERT INTO fatorProducao (designacao, fabricante, formato, tipo, aplicacao) VALUES ('Biocal Composto', 'Biocal', 'Pó', 'Corretor', 'Correção solo');

INSERT INTO quimico (nomeComercial, percentagem, fatorProducaodesignacao) VALUES ('CU', '0.2', 'Calda Bordalesa ASCENZA');						
INSERT INTO quimico (nomeComercial, percentagem, fatorProducaodesignacao) VALUES ('S', '0.8', 'Enxofre Bayer 80 WG');						
INSERT INTO quimico (nomeComercial, percentagem, fatorProducaodesignacao) VALUES ('K', '0.249', 'Patentkali');		
INSERT INTO quimico (nomeComercial, percentagem, fatorProducaodesignacao) VALUES ('Mg', '0.06', 'Patentkali');		
INSERT INTO quimico (nomeComercial, percentagem, fatorProducaodesignacao) VALUES ('S', '0.176', 'Patentkali');		
INSERT INTO quimico (nomeComercial, percentagem, fatorProducaodesignacao) VALUES ('Mg', '0.151', 'ESTA Kieserit');		
INSERT INTO quimico (nomeComercial, percentagem, fatorProducaodesignacao) VALUES ('S', '0.208', 'ESTA Kieserit');				
INSERT INTO quimico (nomeComercial, percentagem, fatorProducaodesignacao) VALUES ('Mg', '0.09', 'EPSO Microtop');		
INSERT INTO quimico (nomeComercial, percentagem, fatorProducaodesignacao) VALUES ('S', '0.124', 'EPSO Microtop');		
INSERT INTO quimico (nomeComercial, percentagem, fatorProducaodesignacao) VALUES ('B', '0.009', 'EPSO Microtop');		
INSERT INTO quimico (nomeComercial, percentagem, fatorProducaodesignacao) VALUES ('Mn', '0.01', 'EPSO Microtop');
INSERT INTO quimico (nomeComercial, percentagem, fatorProducaodesignacao) VALUES ('Mg', '0.096', 'EPSO Top');		
INSERT INTO quimico (nomeComercial, percentagem, fatorProducaodesignacao) VALUES ('S', '0.13', 'EPSO Top');				
INSERT INTO quimico (nomeComercial, percentagem, fatorProducaodesignacao) VALUES ('CaCO3', '0.882', 'Biocal CaCo3');		
INSERT INTO quimico (nomeComercial, percentagem, fatorProducaodesignacao) VALUES ('MgCO3', '0.019', 'Biocal CaCo3');				
INSERT INTO quimico (nomeComercial, percentagem, fatorProducaodesignacao) VALUES ('CaCO3', '0.717', 'Biocal Composto');		
INSERT INTO quimico (nomeComercial, percentagem, fatorProducaodesignacao) VALUES ('MgCO3', '0.148', 'Biocal Composto');		
INSERT INTO quimico (nomeComercial, percentagem, fatorProducaodesignacao) VALUES ('MgO', '0.079', 'Biocal Composto');		

INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (1, 'Prunus domestica', 'Ameixoeira', 'RAINHA CLAUDIA CARANGUEJEIRA', 'Permanente', NULL, 'Novembro a dezembro', 'Fevereiro a março', 'Julho a agosto');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (2, 'Prunus domestica', 'Ameixoeira', 'PRESIDENT', 'Permanente', NULL, 'Novembro a dezembro', 'Fevereiro a março', 'Julho a agosto');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (3, 'Prunus domestica', 'Ameixoeira', 'STANLEY', 'Permanente', NULL, 'Novembro a dezembro', 'Fevereiro a março', 'Julho a agosto');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (4, 'Prunus domestica', 'Ameixoeira', 'ANGELENO', 'Permanente', NULL, 'Novembro a dezembro', 'Fevereiro a março', 'Julho a agosto');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (5, 'Prunus domestica', 'Ameixoeira', 'BLACK BEAUTY', 'Permanente', NULL, 'Novembro a dezembro', 'Fevereiro a março', 'Julho a agosto');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (6, 'Prunus domestica', 'Ameixoeira', 'BLACK STAR', 'Permanente', NULL, 'Novembro a dezembro', 'Fevereiro a março', 'Julho a agosto');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (7, 'Prunus domestica', 'Ameixoeira', 'BLACK GOLD', 'Permanente', NULL, 'Novembro a dezembro', 'Fevereiro a março', 'Julho a agosto');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (8, 'Prunus domestica', 'Ameixoeira', 'BLACK DIAMOND', 'Permanente', NULL, 'Novembro a dezembro', 'Fevereiro a março', 'Julho a agosto');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (9, 'Prunus domestica', 'Ameixoeira', 'BLACK AMBER', 'Permanente', NULL, 'Novembro a dezembro', 'Fevereiro a março', 'Julho a agosto');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (10, 'Prunus domestica', 'Ameixoeira', 'BLACK SPLENDOR', 'Permanente', NULL, 'Novembro a dezembro', 'Fevereiro a março', 'Julho a agosto');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (11, 'Prunus domestica', 'Ameixoeira', 'FORTUNA', 'Permanente', NULL, 'Novembro a dezembro', 'Fevereiro a março', 'Julho a agosto');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (12, 'Prunus domestica', 'Ameixoeira', 'FRIAR', 'Permanente', NULL, 'Novembro a dezembro', 'Fevereiro a março', 'Julho a agosto');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (13, 'Prunus domestica', 'Ameixoeira', 'EL DORADO', 'Permanente', NULL, 'Novembro a dezembro', 'Fevereiro a março', 'Julho a agosto');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (14, 'Prunus domestica', 'Ameixoeira', 'ELEPHANT HEART', 'Permanente', NULL, 'Novembro a dezembro', 'Fevereiro a março', 'Julho a agosto');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (15, 'Prunus domestica', 'Ameixoeira', 'GOLDEN JAPAN', 'Permanente', NULL, 'Novembro a dezembro', 'Fevereiro a março', 'Julho a agosto');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (16, 'Prunus domestica', 'Ameixoeira', 'HARRY PITCHON', 'Permanente', NULL, 'Novembro a dezembro', 'Fevereiro a março', 'Julho a agosto');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (17, 'Prunus domestica', 'Ameixoeira', 'LAETITIA', 'Permanente', NULL, 'Novembro a dezembro', 'Fevereiro a março', 'Julho a agosto');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (18, 'Prunus domestica', 'Ameixoeira', 'METLEY', 'Permanente', NULL, 'Novembro a dezembro', 'Fevereiro a março', 'Julho a agosto');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (19, 'Prunus domestica', 'Ameixoeira', 'MIRABELLE DE NANCY', 'Permanente', NULL, 'Novembro a dezembro', 'Fevereiro a março', 'Julho a agosto');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (20, 'Prunus domestica', 'Ameixoeira', 'QUEEN ROSE', 'Permanente', NULL, 'Novembro a dezembro', 'Fevereiro a março', 'Julho a agosto');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (21, 'Prunus domestica', 'Ameixoeira', 'RED BEAUT', 'Permanente', NULL, 'Novembro a dezembro', 'Fevereiro a março', 'Julho a agosto');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (22, 'Prunus domestica', 'Ameixoeira', 'SANTA ROSA', 'Permanente', NULL, 'Novembro a dezembro', 'Fevereiro a março', 'Julho a agosto');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (23, 'Prunus domestica', 'Ameixoeira', 'SHIRO', 'Permanente', NULL, 'Novembro a dezembro', 'Fevereiro a março', 'Julho a agosto');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (24, 'Prunus domestica', 'Ameixoeira', 'SUNGOLD', 'Permanente', NULL, 'Novembro a dezembro', 'Fevereiro a março', 'Julho a agosto');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (25, 'Prunus domestica', 'Ameixoeira', 'WILSON PERFECTION', 'Permanente', NULL, 'Novembro a dezembro', 'Fevereiro a março', 'Julho a agosto');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (26, 'Prunus domestica', 'Ameixoeira', 'AUTUMN GIANT', 'Permanente', NULL, 'Novembro a dezembro', 'Fevereiro a março', 'Julho a agosto');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (27, 'Prunus armeniaca', 'Damasqueiro', 'BULIDA', 'Permanente', NULL, 'Novembro a dezembro', 'Fevereiro a março', 'Julho a agosto');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (28, 'Prunus armeniaca', 'Damasqueiro', 'CANINO', 'Permanente', NULL, 'Novembro a dezembro', 'Fevereiro a março', 'Julho a agosto');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (29, 'Prunus armeniaca', 'Damasqueiro', 'LIABAUD', 'Permanente', NULL, 'Novembro a dezembro', 'Fevereiro a março', 'Julho a agosto');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (30, 'Prunus armeniaca', 'Damasqueiro', 'MAILLOT JAUNE', 'Permanente', NULL, 'Novembro a dezembro', 'Fevereiro a março', 'Julho a agosto');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (31, 'Prunus armeniaca', 'Damasqueiro', 'POLONAIS', 'Permanente', NULL, 'Novembro a dezembro', 'Fevereiro a março', 'Julho a agosto');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (32, 'Malus domestica', 'Macieira', 'AKANE', 'Permanente', NULL, 'Novembro a dezembro', 'Março a abril', 'Agosto a setembro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (33, 'Malus domestica', 'Macieira', 'BELGOLDEN', 'Permanente', NULL, 'Novembro a dezembro', 'Março a abril', 'Agosto a setembro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (34, 'Malus domestica', 'Macieira', 'BRAVO DE ESMOLFE', 'Permanente', NULL, 'Novembro a dezembro', 'Março a abril', 'Agosto a setembro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (35, 'Malus domestica', 'Macieira', 'CASA NOVA DE ALCOBAÇA', 'Permanente', NULL, 'Novembro a dezembro', 'Março a abril', 'Agosto a setembro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (36, 'Malus domestica', 'Macieira', 'EROVAN', 'Permanente', NULL, 'Novembro a dezembro', 'Março a abril', 'Agosto a setembro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (37, 'Malus domestica', 'Macieira', 'FUJI', 'Permanente', NULL, 'Novembro a dezembro', 'Março a abril', 'Agosto a setembro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (38, 'Malus domestica', 'Macieira', 'GRANNY SMITH', 'Permanente', NULL, 'Novembro a dezembro', 'Março a abril', 'Agosto a setembro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (39, 'Malus domestica', 'Macieira', 'GOLDEN DELICIOUS', 'Permanente', NULL, 'Novembro a dezembro', 'Março a abril', 'Agosto a setembro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (40, 'Malus domestica', 'Macieira', 'HI-EARLY', 'Permanente', NULL, 'Novembro a dezembro', 'Março a abril', 'Agosto a setembro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (41, 'Malus domestica', 'Macieira', 'JONAGORED', 'Permanente', NULL, 'Novembro a dezembro', 'Março a abril', 'Agosto a setembro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (42, 'Malus domestica', 'Macieira', 'LYSGOLDEN', 'Permanente', NULL, 'Novembro a dezembro', 'Março a abril', 'Agosto a setembro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (43, 'Malus domestica', 'Macieira', 'MUTSU', 'Permanente', NULL, 'Novembro a dezembro', 'Março a abril', 'Agosto a setembro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (44, 'Malus domestica', 'Macieira', 'PORTA DA LOJA', 'Permanente', NULL, 'Janeiro', 'Abril a maio', 'Novembro a dezembro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (45, 'Malus domestica', 'Macieira', 'REINETTE OU CANADA', 'Permanente', NULL, 'Novembro a dezembro', 'Março a abril', 'Agosto a setembro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (46, 'Malus domestica', 'Macieira', 'REINETTE OU GRAND FAY', 'Permanente', NULL, 'Novembro a dezembro', 'Março a abril', 'Agosto a setembro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (47, 'Malus domestica', 'Macieira', 'RISCADINHA DE PALMELA', 'Permanente', NULL, 'Novembro a dezembro', 'Março a abril', 'Agosto a setembro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (48, 'Malus domestica', 'Macieira', 'ROYAL GALA', 'Permanente', NULL, 'Novembro a dezembro', 'Março a abril', 'Agosto a setembro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (49, 'Malus domestica', 'Macieira', 'REDCHIEF', 'Permanente', NULL, 'Novembro a dezembro', 'Março a abril', 'Agosto a setembro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (50, 'Malus domestica', 'Macieira', 'STARKING', 'Permanente', NULL, 'Novembro a dezembro', 'Março a abril', 'Agosto a setembro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (51, 'Malus domestica', 'Macieira', 'SUMMER RED', 'Permanente', NULL, 'Novembro a dezembro', 'Março a abril', 'Agosto a setembro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (52, 'Malus domestica', 'Macieira', 'WELL SPUR DELICIOUS', 'Permanente', NULL, 'Novembro a dezembro', 'Março a abril', 'Agosto a setembro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (53, 'Malus domestica', 'Macieira', 'NOIVA', 'Permanente', NULL, 'Novembro a dezembro', 'Março a abril', 'Agosto a setembro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (54, 'Malus domestica', 'Macieira', 'OLHO ABERTO', 'Permanente', NULL, 'Novembro a dezembro', 'Março a abril', 'Agosto a setembro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (55, 'Malus domestica', 'Macieira', 'CAMOESA ROSA', 'Permanente', NULL, 'Novembro a dezembro', 'Março a abril', 'Agosto a setembro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (56, 'Malus domestica', 'Macieira', 'MALÁPIO', 'Permanente', NULL, 'Novembro a dezembro', 'Março a abril', 'Agosto a setembro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (57, 'Malus domestica', 'Macieira', 'GRONHO DOCE', 'Permanente', NULL, 'Novembro a dezembro', 'Março a abril', 'Agosto a setembro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (58, 'Malus domestica', 'Macieira', 'PÉ DE BOI ', 'Permanente', NULL, 'Novembro a dezembro', 'Março a abril', 'Agosto a setembro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (59, 'Malus domestica', 'Macieira', 'PINOVA', 'Permanente', NULL, 'Novembro a dezembro', 'Março a abril', 'Agosto a setembro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (60, 'Malus domestica', 'Macieira', 'PARDO LINDO', 'Permanente', NULL, 'Novembro a dezembro', 'Março a abril', 'Agosto a setembro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (61, 'Malus domestica', 'Macieira', 'PIPO DE BASTO', 'Permanente', NULL, 'Novembro a dezembro', 'Março a abril', 'Agosto a setembro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (62, 'Malus domestica', 'Macieira', 'PRIMA', 'Permanente', NULL, 'Novembro a dezembro', 'Março a abril', 'Agosto a setembro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (63, 'Malus domestica', 'Macieira', 'QUERINA', 'Permanente', NULL, 'Novembro a dezembro', 'Março a abril', 'Agosto a setembro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (64, 'Malus domestica', 'Macieira', 'VISTA BELLA', 'Permanente', NULL, 'Novembro a dezembro', 'Março a abril', 'Agosto a setembro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (65, 'Malus domestica', 'Macieira', 'GOLDEN SMOOTHEE', 'Permanente', NULL, 'Novembro a dezembro', 'Março a abril', 'Agosto a setembro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (66, 'Malus domestica', 'Macieira', 'GOLDEN SUPREMA', 'Permanente', NULL, 'Novembro a dezembro', 'Março a abril', 'Agosto a setembro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (67, 'Malus domestica', 'Macieira', 'GLOSTER 69', 'Permanente', NULL, 'Novembro a dezembro', 'Março a abril', 'Agosto a setembro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (68, 'Malus domestica', 'Macieira', 'FREEDOM', 'Permanente', NULL, 'Novembro a dezembro', 'Março a abril', 'Agosto a setembro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (69, 'Pyrus pyrifolia', 'Pera Nashi', 'SNINSEIKI', 'Permanente', NULL, NULL, NULL, NULL);
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (70, 'Pyrus pyrifolia', 'Pera Nashi', 'KUMOI', 'Permanente', NULL, NULL, NULL, NULL);
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (71, 'Pyrus pyrifolia', 'Pera Nashi', 'HOSUI', 'Permanente', NULL, NULL, NULL, NULL);
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (72, 'Pyrus pyrifolia', 'Pera Nashi', 'NIJISSEIKI', 'Permanente', NULL, NULL, NULL, NULL);
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (73, 'Daucus carota subsp. Sativus', 'Cenoura', 'Carson Hybrid', 'Temporária', NULL, NULL, NULL, '80 dias');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (74, 'Daucus carota subsp. Sativus', 'Cenoura', 'Red Cored Chantenay', 'Temporária', NULL, NULL, NULL, '80 dias');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (75, 'Daucus carota subsp. Sativus', 'Cenoura', 'Danvers Half Long', 'Temporária', NULL, NULL, NULL, '80 dias');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (76, 'Daucus carota subsp. Sativus', 'Cenoura', 'Imperator 58', 'Temporária', NULL, NULL, NULL, '80 dias');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (77, 'Daucus carota subsp. Sativus', 'Cenoura', 'Sugarsnax Hybrid', 'Temporária', NULL, NULL, NULL, '80 dias');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (78, 'Daucus carota subsp. Sativus', 'Cenoura', 'Nelson Hybrid', 'Temporária', NULL, NULL, NULL, '80 dias');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (79, 'Daucus carota subsp. Sativus', 'Cenoura', 'Scarlet Nantes', 'Temporária', NULL, NULL, NULL, '80 dias');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (80, 'Lupinus luteus', 'Tremoço', 'Amarelo', 'Temporária', NULL, NULL, NULL, NULL);
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (81, 'Lupinus albus', 'Tremoço', 'Branco', 'Temporária', NULL, NULL, NULL, NULL);
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (82, 'Zea mays', 'Milho', 'MAS 24.C', 'Temporária', 'Abril a junho', NULL, NULL, 'Julho a setembro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (83, 'Zea mays', 'Milho', 'Doce Golden Bantam', 'Temporária', 'Abril a junho', NULL, NULL, 'Julho a setembro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (84, 'Brassica rapa', 'Nabo greleiro', 'Senhora Conceição', 'Temporária', 'Março a setembro', NULL, NULL, 'Junho a fevereiro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (85, 'Olea europaea', 'Oliveira', 'COBRANÇOSA', 'Permanente', NULL, NULL, NULL, 'Outubro a novembro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (86, 'Olea europaea', 'Oliveira', 'ARBEQUINA', 'Permanente', NULL, NULL, NULL, 'Outubro a novembro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (87, 'Olea europaea', 'Oliveira', 'HOJIBLANCA', 'Permanente', NULL, NULL, NULL, 'Outubro a novembro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (88, 'Olea europaea', 'Oliveira', 'NEGRINHA DO FREIXO', 'Permanente', NULL, NULL, NULL, 'Outubro a novembro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (89, 'Olea europaea', 'Oliveira', 'PICUAL', 'Permanente', NULL, NULL, NULL, 'Outubro a novembro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (90, 'Olea europaea', 'Oliveira', 'MAÇANILHA', 'Permanente', NULL, NULL, NULL, 'Outubro a novembro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (91, 'Olea europaea', 'Oliveira', 'CONSERVA DE ELVAS', 'Permanente', NULL, NULL, NULL, 'Outubro a novembro');
INSERT INTO planta (id, especie, nomeComum, variedade, tipoPlantacao, sementariaPlantacao, poda, floracao, colheita) VALUES (92, 'Olea europaea', 'Oliveira', 'Galega ', 'Permanente', NULL, NULL, NULL, 'Outubro a novembro');