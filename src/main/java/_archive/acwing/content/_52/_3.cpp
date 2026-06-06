//
// Created by chenqwwq on 2022/5/21.
//


#include "iostream"
#include <cmath>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    double k = 2;
    int t;
    double d;
    cin >> t;
    while (t--) {
        cin >> d;
        if (d * d < 4 * d) {
            printf("N\n");
            continue;
        }
        double a = (sqrt(d * d - 4 * d) + d) / k;
        printf("Y %.10f %.10f\n", a, d - a);
    }
    return 0;
}