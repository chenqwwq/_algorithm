#include <stdio.h>
#include <string.h>

int main(void){
    char name[40];
    name[3]= '\0';
    printf("len:%zd %zd",strlen(name),sizeof name);
    return 0;
}