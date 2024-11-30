#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/stat.h>
#include "../USAC11/sensor.h"

// Funçao Principal:

int configurarComponente(const char *diretorio, Sensor *sensor) {
    // Aloca dinamicamente as estruturas internas
    sensor->buffer = (Buffer_Circular *)malloc(sizeof(Buffer_Circular));
    sensor->type = strdup("default_type");
    sensor->unit = strdup("default_unit");
    sensor->medianas = (int *)malloc(sizeof(sensor -> mediana_size));

    // Verifica e cria o diretório
    if (verificarDiretorio(diretorio) == 1) {
        free(sensor->buffer);
        free(sensor->type);
        free(sensor->unit);
        free(sensor->medianas);
        free(sensor);
        return -1;  // Retorna NULL indicando falha
    }

    // Resto da configuração do Sensor se necessário
    sensor->sensor_id = 1;


    return 0;  // Retorna o ponteiro para a estrutura Sensor
}





