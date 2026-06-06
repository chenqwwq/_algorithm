//
// Created by 陈炳鑫 on 2022/4/14.
//


#include <iostream>
#include<cstdio>
#include<cstring>

using namespace std;
char word[1000];

int main() {
    scanf("%s", word);
    int n = (int) strlen(word);
    if (n < 5) {
        printf("%s", word);
        return 0;
    }
    int m = n + 2;
    int a = m / 3, b = m / 3 + m % 3;
    for (int i = 0; i < a - 1; ++i) {
        printf("%c", word[i]);
        for (int j = 0; j < b - 2; ++j) putchar(' ');
        printf("%c\n", word[n - i - 1]);
    }
    for (int i = -1; i < b - 1; ++i) putchar(word[a + i]);
    printf("\n");
    return 0;
}