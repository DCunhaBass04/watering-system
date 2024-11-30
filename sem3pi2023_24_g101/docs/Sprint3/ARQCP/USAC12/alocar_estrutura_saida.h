#ifndef ALOCAR_ESTRUTURA_SAIDA_H
#define ALOCAR_ESTRUTURA_SAIDA_H

#include "estrutura_saida.h"

Estrutura_Saida* alocar_estrutura_saida(int sensor_id, int write_counter, const char* type, const char* unit, int mediana);
void libertar_estrutura_saida(Estrutura_Saida* estrutura);

#endif