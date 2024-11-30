main: main.o ProcessadorDeDados/ProcessadorDeDados.o SaidaDeDados/SaidaDeDados.o
	gcc -g main.o ProcessadorDeDados/ProcessadorDeDados.o SaidaDeDados/SaidaDeDados.o -z noexecstack -o main

main.o: main.c ProcessadorDeDados/ProcessadorDeDados.h SaidaDeDados/SaidaDeDados.h
	gcc -g -Wall -Wextra -fanalyzer -c main.c -o main.o
	
ProcessadorDeDados/ProcessadorDeDados.o: ProcessadorDeDados/ProcessadorDeDados.s
	gcc -g -Wall -Wextra -fanalyzer -c ProcessadorDeDados/ProcessadorDeDados.s -o ProcessadorDeDados/ProcessadorDeDados.o
	
SaidaDeDados/SaidaDeDados.o: SaidaDeDados/SaidaDeDados.c
	gcc -g -Wall -Wextra -fanalyzer -c SaidaDeDados/SaidaDeDados.c -o SaidaDeDados/SaidaDeDados.o	
	
run: main
	./main
	
clean:
	rm *.o main
