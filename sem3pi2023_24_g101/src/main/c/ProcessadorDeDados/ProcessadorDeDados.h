#ifndef PROCESSADORDEDADOS_H
#define PROCESSADORDEDADOS_H
void extract_token(char* input, char* token, int* output);
void enqueue_value(int* array, int length, int* read, int* write, int value);
int move_num_vec(int* array, int length, int* read, int* write, int num, int* vec);
void sort_array(int* vec, int num);
int mediana(int* vec, int num);
#endif
