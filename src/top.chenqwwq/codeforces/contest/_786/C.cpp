//
// Created by 陈炳鑫 on 2022/5/12.
//


#include <iostream>
#include <cmath>

using namespace std;

int main() {
    int t;
    string a, b;
    cin >> t;
    while (t--) {
        cin >> a;
        cin >> b;
        if (b == "a") {
            printf("1\n");
            continue;
        }
        if (b.find('a') != string::npos) {
            printf("_1\n");
            continue;
        }
        printf("%lld\n", (long long) pow(2, a.length()));
    }
    return 0;
}