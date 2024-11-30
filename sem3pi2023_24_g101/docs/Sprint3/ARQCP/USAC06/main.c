#include <stdio.h>
#include "asm.h"

char string[] = "sensor_id:8#type:atmospheric_temperature#value:21.60#unit:celsius#time:2470030";

int n = 0;

char token[] = "value:";
int x = 0;
int* output = &x;

int main(){
    int value = extract_token(string, token, output);
    printf("Token value: %d\n", *output);
    printf("Return value: %d\n", value);
    return 0;
}

