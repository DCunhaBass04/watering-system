#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int lerLinhaSensor(char* fileName, char* line, int lineNumber, int size){
	FILE *ftr = fopen(fileName, "r");
	if(ftr == NULL){
		return -1;
	}
	for(int i = 0; i < 2*lineNumber; i++){
		   fgets(line, size, ftr);
	}
    fgets(line, size, ftr);
    line[strcspn(line, "\n")] = '\0';
	fclose(ftr);
	return 0;
}

//void printMatrix(char **matrix, int size){
//	for(int i = 0; i < size; i++){
//		printf("%s\n", *(matrix + i));
//	}
//}

//int main(){
	//int size = 100;
	//char array[size];
	//int n = 0, a = 1;
	//char file[] = "/media/sf_partilha/sem3pi2023_24_g101/docs/Sprint3/ARQCP/USAC08/example.txt";
	//while(a == 1){
		//int value = lerLinhaSensor(file, array, n, size);
		//if(value != -1){
			//printf("%s\n", array);
		//} else {
			//printf("oops\n");
		//}
		//n++;
		//scanf("%d", &a);
	//}
    //
  //  return 0;
//}
