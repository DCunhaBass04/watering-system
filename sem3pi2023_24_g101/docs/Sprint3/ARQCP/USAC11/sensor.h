#ifndef SENSOR_H
#define SENSOR_H

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
    int *mediana;
    int mediana_size;
    int sensor_id;
    int timeout;
    int instante;
    int write_counter;
    char erro; //0 ou 1
} Sensor; //56 bytes

// Ex sensor: 1#soil_humidity#percentage#50#10#40000

#endif
