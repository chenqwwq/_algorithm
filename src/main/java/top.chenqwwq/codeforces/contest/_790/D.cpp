//
// Created by 陈炳鑫 on 2022/5/10.
//


#include <iostream>
#include <cstring>

using namespace std;

long long cb[201][201];
long long a[500], b[500];

int main() {
    int n, x, y;
    cin >> n;
    while (n--) {
        cin >> x >> y;
        memset(a, 0x00, sizeof(a));
        memset(b, 0x00, sizeof(b));
        for (int i = 0; i < x; ++i) {
            for (int j = 0; j < y; ++j) {
                cin >> cb[i][j];
                a[i - j + x - 1] += cb[i][j];
                b[i + j] += cb[i][j];
            }
        }

//        for (int i = 0; i <= 2 * x - 1; ++i) {
//            printf("%d ", a[i]);
//        }
//        printf("\n");
//
//        for (int i = 0; i <= 2 * y - 1; ++i) {
//            printf("%d ", b[i]);
//        }
//        printf("\n");
        long long ans = 0;
        for (int i = 0; i < x; ++i) {
            for (int j = 0; j < y; ++j) {
                ans = max(ans, a[i - j + x - 1] + b[i + j] - cb[i][j]);
            }
        }
        printf("%lld\n", ans);
    }
    // 0,0 0,1 0,2
    // 1,0 1,1 1,2
    // 2,0 2,1 2,2
    return 0;
}