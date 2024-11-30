#ifndef ESTRUTURA_SAIDA_H
#define ESTRUTURA_SAIDA_H

typedef struct {
    int sensor_id;
    double write_counter;
    char *type;
    char *unit;
    double *mediana;
} Estrutura_Saida;

#endif