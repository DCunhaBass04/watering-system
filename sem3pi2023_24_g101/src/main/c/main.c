#include <stdio.h>
#include "ProcessadorDeDados/ProcessadorDeDados.h"
#include "SaidaDeDados/SaidaDeDados.h"

int verQualEToken(char* tokenInserido, char* tokenEsperado){
	int i = 0;
	while(*(tokenInserido + i) != '\0' && *(tokenEsperado + i) != '\0'){
		if(*(tokenInserido + i) != *(tokenEsperado + i)){
			return 0;
		}
		i++;
	}
	return 1;
}

void fazerExtract(){
	printf("\nInsira a linha fornecida pelo sensor\n");
	char linha[100];
	scanf("%s", linha);
	printf("\nInsira o token que quer ('type' não incluido).\nEx.:'sensor_id:'\n");
	char token[25];
	scanf("%s", token);
	int value = 0;
	extract_token(linha, token, &value);
	char* tokenEsperado = "value:";
	float valueFloat;
	if(verQualEToken(token, tokenEsperado) == 1){
		valueFloat = (float)value / 100;
		printf("Token value: %.2f\n", valueFloat);
		printExtractedTokenValue(linha, token, valueFloat);
	} else {
		printf("Token value: %d\n", value);
		printExtractedTokenNotValue(linha, token, value);
	}
}

void cleanArray(int * array, int size){
	for(int i = 0; i < size; i++){
		*(array + i) = 0;
	}
}

void printArray(int* array, int size){
	printf("\nEstado do array:\n");
	for(int i = 0; i < size; i++){
		printf("%d	", *(array+i));
	}
	printf("\n");
}

void inserirValor(int* array, int size, int* read, int* write){
	int valor;
	printf("Insira o valor que quer colocar o array\n");
	scanf("%d",&valor);
	enqueue_value(array, size, read, write, valor);
}

void copy_array(int* array_original, int size, int* array_copia){
	for(int i = 0; i < size; i++){
		*(array_copia + i) = *(array_original + i);
	}
}

int moverValores(int* array, int size, int* read, int* write, int* array2){
	printf("Quantos valores é que pretende mover do array original para o segundo?\n");
	int num;
	scanf("%d",&num);
	return move_num_vec(array, size, read, write, num, array2);
}

void metodosArray(){
	printf("\nDecida o tamanho do array\n");
	int size, read = 0, write = 0, option, median, num;
	scanf("%d",&size);
	int array[size];
	int array_copy[size];
	int array_copy2[size];
	cleanArray(array, size);
	do{
		printArray(array, size);
		printf("\nMenu destinado ao uso de arrays\n1 - Inserir valor no array\n2 - Copiar valores de um array para outro\n3 - Ordenar o array\n4 - Obter mediana\n\n0 - Sair\n\n");
		printf("value in write pointer: %d\n",write);
		printf("value in read pointer: %d\n",read);
		scanf("%d", &option);
		switch (option){
			case 1:
				copy_array(array, size, array_copy);
				inserirValor(array, size, &read, &write);
				printWriteOperationBuffer(array_copy, array, size, read, write);
				break;
			case 2:
				cleanArray(array_copy, size);
				copy_array(array, size, array_copy2);
				printf("Insira o número de valores que quer remover do array e copiar para outro\n");
				scanf("%d", &num);
				if(move_num_vec(array, size, &read, &write, num, array_copy) == 1){
					printArray(array_copy, size);
					printReadOperationBuffer(array_copy2, array, size, read, write, array_copy);
				} else {
					printf("É impossível mover esse número de elementos, visto que o tamanho do array é inferior ao valor inserido\n");
				}
				break;
			case 3:
				copy_array(array, size, array_copy);
				sort_array(array, size);
				printArrayAndSortedArray(array, array_copy, size);
				break;
			case 4:
				copy_array(array,size,array_copy);
				median = mediana(array_copy, size);
				printf("A mediana deste array é %d\n", median);
				printMediana(array, size, median);
				break;
			case 0:
				break;	
			default:
				printf("Por favor insira uma opção válida\n");
				break;
		}
	}while(option != 0);
	
}


int main(void) { 
	int option;
	do{
		printf("\nMain Menu:\n1 - Extrair token 'value'\n2 - Trabalhos com Arrays\n\n0 - Sair\n\n");
		scanf("%d", &option);
		switch (option){
			case 1:
				fazerExtract();
				break;
			case 2:	
				metodosArray();
				break;
			case 0:
				break;
			default:
				printf("Por favor insira uma opção válida\n");
				break;
		}
	}while(option != 0);
	return 0;
}
