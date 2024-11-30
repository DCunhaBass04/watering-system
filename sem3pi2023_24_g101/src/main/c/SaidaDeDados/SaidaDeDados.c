#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include "alocar_estrutura_saida.h"
#include "validar_dir_saida.h"


int main(int argc, char *argv[]) {
    char *nome_ficheiro_processador = "nome.txt";
    char *filepath = concatenar_strings(argv[1], nome_ficheiro_processador);
    FILE *ficheiro_processador = fopen(filepath, "r");
    if (validar_dir_saida(argv[2]) == 0) {
        criar_dir(argv[2]);
    }
    ler_sensores_do_ficheiro(ficheiro_processador);
    return 0;
    
}

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

char* concatenar_strings(const char* str1, const char* str2) {
    size_t len1 = strlen(str1);
    size_t len2 = strlen(str2);
    size_t totalLength = len1 + len2 + 1; 
    char* result = (char*)malloc(totalLength);
    if (result != NULL) {
        strcpy(result, str1);
        strcat(result, str2);
    }
    return result;
}


