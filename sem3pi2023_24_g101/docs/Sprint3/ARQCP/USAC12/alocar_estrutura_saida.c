#include <stdlib.h>
#include <stdio.h>
#include "estrutura_saida.h"

Estrutura_Saida* alocar_estrutura_saida(int sensor_id, double write_counter, const char* type, const char* unit, double* mediana) {
    Estrutura_Saida* estrutura = (Estrutura_Saida*)malloc(sizeof(Estrutura_Saida));
    if (estrutura == NULL) {
        return NULL;
    }
    estrutura->sensor_id = sensor_id;
    estrutura->write_counter = write_counter;
    estrutura->type = (char*)malloc(strlen(type) + 1);
    estrutura->unit = (char*)malloc(strlen(unit) + 1);
    if (estrutura->type == NULL || estrutura->unit == NULL) {
        free(estrutura->type);
        free(estrutura->unit);
        free(estrutura);
        return NULL;
    }
    strcpy(estrutura->type, type);
    strcpy(estrutura->unit, unit);
    estrutura->mediana = (double*)malloc(sizeof(double));
    if (estrutura->mediana == NULL) {
        free(estrutura->type);
        free(estrutura->unit);
        free(estrutura);
        return NULL;
    }
    *(estrutura->mediana) = *mediana;
    return estrutura;
}

void libertar_estrutura_saida(Estrutura_Saida* estrutura) {
    if (estrutura != NULL) {
        free(estrutura->type);
        free(estrutura->unit);
        free(estrutura->mediana);
        free(estrutura);
    }
}

