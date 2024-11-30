#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/stat.h>
#include "sensor.h"
#include "usac07/usac07.h"




int main(){

    char a[] = "Ficheiro/recebido/De/ColetorDeDados";
    char b[] = "contfig.txt";
    char c []= "DiretorioSaidaDeDados";
    int d = 10;                                                                     // Numero de leituras antes de enviar para SaidadeDeDados

    configurarComponente(c);


  return 0;
}
