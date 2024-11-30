#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "../USAC11/sensor.h" 

void extractParameters(const char *line, Sensor *data) {
    sscanf(strstr(line, "sensor_id:") + strlen("sensor_id:"), "%d", &data->sensor_id);
    sscanf(strstr(line, "type:") + strlen("type:"), "%49[^#]", data->type);
    sscanf(strstr(line, "unit:") + strlen("unit:"), "%49[^#]", data->unit);
}

int main() {
    char line[] = "sensor_id:7#type:atmospheric_temperature#value:23.60#unit:celsius#time:18030";

    Sensor sensorData;

    sensorData.type = malloc(50);
    sensorData.unit = malloc(50);

    extractParameters(line, &sensorData);

    printf("sensor_id: %d\n", sensorData.sensor_id);
    printf("type: %s\n", sensorData.type);
    printf("unit: %s\n", sensorData.unit);

    free(sensorData.type);
    free(sensorData.unit);

    return 0;
}
