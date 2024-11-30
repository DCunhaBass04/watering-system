
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include "alocar_estrutura_saida.h"
#include "validar_dir_saida.h"

void ler_sensores_do_ficheiro(FILE *ficheiro_processador) {
    char line[256];
    while (fgets(line, sizeof(line), ficheiro_processador) != NULL) {
        if (line[strlen(line) - 1] == '#') {
            // Substituir "#" por "\0" para finalizar a linha atual.
            line[strlen(line) - 1] = '\0';
            // Separar a linha atual por virgulas
            char *token = strtok(line, ",");
            if (token != NULL) {
				// Guardar os valores da linha em variáveis adequadas.
                int sensor_id = atoi(token); 
                token = strtok(NULL, ",");
                double write_counter = atof(token);
                token = strtok(NULL, ",");
                char *type = strdup(token);
                token = strtok(NULL, ",");
                char *unit = strdup(token);
                token = strtok(NULL, ",");
                double mediana = atof(token); 
				// Alocar estrutura 
                Estrutura_Saida* estrutura = alocar_estrutura_saida(sensor_id, write_counter, type, unit, mediana);
                // Libertar estrutura
				libertar_estrutura_saida(estrutura);
            }
        }
    }
}