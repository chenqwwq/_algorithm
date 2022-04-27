//
// Created by 陈炳鑫 on 2022/4/22.
//


#include <iostream>

using namespace std;

int main() {
    int n, num;
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) {
        scanf("%d", &num);
        if (num <= 1399) {
            printf("Division 4\n");
        } else if (num <= 1599) {
            printf("Division 3\n");
        } else if (num <= 1899) {
            printf("Division 2\n");
        } else {
            printf("Division 1\n");
        }
    }
    return 0;
}