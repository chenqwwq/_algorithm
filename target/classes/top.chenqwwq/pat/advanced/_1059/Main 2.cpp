//
// Created by 陈炳鑫 on 2022/5/4.
//


#include <iostream>

using namespace std;
const int maxn = 1e5;

int next(int n) {
    while (++n < maxn) {
        bool flag = true;
        for (int j = 2; j < n; ++j) {
            if (!(n % j)) {
                flag = false;
                break;
            }
        }
        if (flag) return n;
    }
    return -1;
}

int main() {
    long long n;
    cin >> n;
    int base = 2;
    printf("%lld=", n);
    bool state = false;
    while (n > 1) {
        int cnt = 0;
        while (!(n % base) && n > 1) {
            if (++cnt == 1) {
                if (state) printf("*%d", base);
                else {
                    printf("%d", base);
                    state = true;
                }
            }
            n /= base;
        }
        if (cnt > 1) printf("^%d", cnt);
        if (n > 1) base = next(base);
    }
    if(!state) printf("%lld",n);
    cout << endl;
    return 0;
}