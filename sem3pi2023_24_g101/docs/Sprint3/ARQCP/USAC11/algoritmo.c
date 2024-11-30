#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <time.h>
#include "sensor.h"
#include "../USAC07/ConfigurarComponente.h"
#include "../USAC08/ReceberDados.h"
#include "../USAC09/InserirDados.h"
#include "../USAC10/SerializarInformacao.h"
//#include "../USAC05/Mediana.h"

void criarArquivoSensors(Sensor *sensores, int num, char* outputPath, char** matrix){
	char* outputFile = outputPath;
	    // variables to store the date and time components
    int hours, minutes, seconds, day, month, year;
 
    time_t now;
    
    time(&now);
 
    // Convert to local time format and print to stdout
    ctime(&now);
 
    struct tm *local = localtime(&now);
 
    hours = local->tm_hour;         // get hours since midnight (0-23)
    minutes = local->tm_min;        // get minutes passed after the hour (0-59)
    seconds = local->tm_sec;        // get seconds passed after a minute (0-59)
 
    day = local->tm_mday;            // get day of month (1 to 31)
    month = local->tm_mon + 1;      // get month of year (0 to 11)
    year = local->tm_year + 1900;   // get year since 1900
    
    sprintf(outputFile, "%04d", year);
    sprintf(outputFile, "%02d", month);
    sprintf(outputFile, "%02d", day);
    sprintf(outputFile, "%02d", hours);
    sprintf(outputFile, "%02d", minutes);
    sprintf(outputFile, "%02d", seconds);

}

int numLinhasConfig(const char* fileName){
	FILE *fp;
    int count = 0; 
    char c;
 
    // Open the file
    fp = fopen(fileName, "r");
 
    // Check if file exists
    if (fp == NULL)
    {
        printf("Could not open file %s", fileName);
        return -1;
    }
 
    // Extract characters from file and store in character c
    for (c = getc(fp); c != EOF; c = getc(fp))
        if (c == '\n') // Increment count if this character is newline
            count = count + 1;
 
    // Close the file
    fclose(fp);
 
    return count;
}

void algoritmoProcessadorDeDados(const char *diretorioConfig, char* fileName, char* output, int valor) {
	int numeroSensores = numLinhasConfig(diretorioConfig);
    Sensor *sensores = (Sensor *)malloc(numeroSensores * sizeof(Sensor *));
    int saida;

    // Inicializar sensores dinamicamente
    for (int i = 0; i < numeroSensores; ++i) {
        saida = configurarComponente(diretorioConfig, &sensores[i]);
        if (saida == -1) {
            // Lidar com falha na configuração do sensor
            fprintf(stderr, "Falha ao configurar o sensor %d\n", i);
            exit(EXIT_FAILURE);
        }
    }

    int contadorLeitura = 0;
    char linha[100];

    while (1) {
        contadorLeitura = 0;
        for (int i = 0; i < valor; ++i) {
            lerLinhaSensor(fileName, linha, i, 100);
            extractParameters(linha, &sensores[i]);
            // Incrementar contador de leitura
            contadorLeitura++;
            sleep(2);
        }
		char* linhas[numeroSensores];
        // Calcular mediana e serializar informações para cada sensor
        for (int i = 0; i < numeroSensores; ++i) {
            // Calcular mediana
            calcularMediana(sensores[i]);

            // Incrementar contador de escrita
            sensores[i].write_counter++;

            // Serializar informações
            serializarSensor(&sensores[i], linhas[i]);
        }

        // Criar arquivo e escrever todas as informações dos sensores
        criarArquivoSensors(sensores, numeroSensores, output, linhas);
    }
    free(sensores);
}

int main(int argc, char **argv) {
    // Chame a função do Processador de Dados
    int valor;
    sscanf(argv[4], "%d", &valor);
    algoritmoProcessadorDeDados(argv[2], argv[1], argv[3], valor);

    return 0;
}



//Algorithm 1: An algorithm with caption

//while 1 do Contadorleitura ← 0; repeat
//Read data from sensor ; received from ColectorDedados  Extract info;
//Insert info into sensor Data Struct;   configurar componente
//until ContadorLeitura=d; foreach sensor do
//Compute median; write counter ← write counter + 1;
//serialize info;
//end
//create the ’AAAAMMDDHHMMSS sensors.txt’ file and write all sensors info ; sent to SaidaDeDados
//end
