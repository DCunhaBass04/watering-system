#include <stdio.h>
#include <string.h>
#include "../USAC11/sensor.h"

void serializarSensor(Sensor *sensor, char* frase){
	if(sensor->erro == 0){
		sprintf(frase, "%d,%d,%s,%s,%d#", 
			sensor->sensor_id, sensor->write_counter, 
			sensor->type, sensor->unit, *(sensor->mediana + sensor->mediana_size - 1));
	} else {
		sprintf(frase, "%d,%d,%s,%s,error#", 
			sensor->sensor_id, sensor->write_counter, 
			sensor->type, sensor->unit);
	}
}

//int main(){
//
	//Sensor a, b;
	//int size = 3;
	//int array[size]; array[0] = 2250; array[1] = 2000; array[2] = 2160;
	//a.sensor_id = 1; a.write_counter = 1; a.type = "soil_humidity"; a.unit = "percentage"; a.mediana = array; a.mediana_size = size;
	//char frase[] = "";
	//serializarSensor(&a, frase);
	//printf("%s\n", frase);
	//b.sensor_id = 3; b.write_counter = 1; b.type = "atmospheric_humidity"; b.unit = "percentage"; b.erro = 1;
	//serializarSensor(&b, frase);
	//printf("%s\n", frase);

	//return 0;
//}
