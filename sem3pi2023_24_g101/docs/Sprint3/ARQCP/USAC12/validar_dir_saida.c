#include <stdio.h>
#include <stdlib.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <dirent.h>


int validar_dir_saida(const char *path) {
    DIR *dir = opendir(path);
    if (dir != NULL) {
        closedir(dir);
        return 1; 
    } else {
        return 0; 
    }
}

int criar_dir(const char *path) {
    if (mkdir(path, S_IRWXU | S_IRGRP | S_IXGRP | S_IROTH | S_IXOTH) == 0) {
        printf("Diretório não existia, foi criado com o nome fornecido: %s\n", path);
        return 0; 
    } else {
        perror("Erro ao criar diretório");
        return 1; 
    }
}


