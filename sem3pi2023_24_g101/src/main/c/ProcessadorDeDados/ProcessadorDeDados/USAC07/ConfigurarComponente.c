#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/stat.h>

// Estrutura para o buffer circular
typedef struct {
    int *read;
    int *write;
    int buffer_size;
} Buffer_Circular;

// Estrutura para o sensor
typedef struct {
    Buffer_Circular *buffer;
    char *type;
    char *unit;
    int *medianas;
    int sensor_id;
    int mediana_size;
    int timeout;
    int instante;
    int write_counter;
} Sensor;

// Ex sensor: 1#soil_humidity#percentage#50#10#40000

int verificarDiretorio(char *diretorio) {  // Ficheiro Config!!


    // Verifica se o diretório já existe
    struct stat st = {0};
    if (stat(diretorio, &st) == -1) {
        // Se não existir, tenta criar -- 0777 permissoes de diretorio , == -1 em caso de erro
        if (mkdir(diretorio, 0777) == -1) {
            printf("Erro ao criar diretório");
            return 1;
        }
    }
    return 0;
}


int verificarDiretorio(char *diretorio) {
    // Verifica se o diretório já existe
    struct stat st = {0};
    if (stat(diretorio, &st) == -1) {
        // Se não existir, tenta criar -- 0777 permissões de diretório
        if (mkdir(diretorio, 0777) == -1) {
            printf("Erro ao criar diretório\n");
            return 1;
        } else {
            printf("Diretório criado com sucesso\n");
        }
    } else {
        printf("Diretório já existe\n");
    }
    return 0;
}

Sensor *configurarComponente(const char *diretorio) {
    // Aloca dinamicamente a estrutura Sensor
    Sensor *sensor = (Sensor *)malloc(sizeof(Sensor));
    if (sensor == NULL) {
        printf("Erro ao alocar memória para Sensor");
        return NULL;  // Retorna NULL indicando falha
    }

    // Aloca dinamicamente as estruturas internas
    sensor->buffer = (Buffer_Circular *)malloc(sizeof(Buffer_Circular));
    sensor->type = strdup("default_type");
    sensor->unit = strdup("default_unit");
    sensor->medianas = (int *)malloc(sizeof(sensor -> mediana_size));

    // Verifica se a alocação foi bem-sucedida
    if (sensor->buffer == NULL || sensor->type == NULL || sensor->unit == NULL || sensor->medianas == NULL) {
        perror("Erro ao alocar memória para estruturas internas");
        free(sensor->buffer);
        free(sensor->type);
        free(sensor->unit);
        free(sensor->medianas);
        free(sensor);
        return NULL;  // Retorna NULL indicando falha
    }

    // Verifica e cria o diretório
    if (verificarDiretorio(diretorio) == 1) {
        free(sensor->buffer);
        free(sensor->type);
        free(sensor->unit);
        free(sensor->medianas);
        free(sensor);
        return NULL;  // Retorna NULL indicando falha
    }

    // Resto da configuração do Sensor se necessário
    sensor->sensor_id = 1;


    return sensor;  // Retorna o ponteiro para a estrutura Sensor
}

