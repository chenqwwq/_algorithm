//
// Created by 陈炳鑫 on 2022/5/12.
//


#include <iostream>
#include <cmath>

using namespace std;

int main() {
    int t, x, y;
    cin >> t;
    while (t--) {
        cin >> x >> y;
        if (y % x) {
            printf("0 0\n");
            continue;
        }
        printf("%d %d\n", 1, y / x);
    }
    return 0;
}