//
// Created by chenqwwq on 2022/6/4.
//


#include "bits/stdc++.h"
#include "common.h"

#include "iostream"

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n, x1, y1, x2, y2;
    scanf("%d %d %d %d %d", &n, &x1, &y1, &x2, &y2);
    int cows[n][2];
    for (int i = 0; i <n ; ++i) scanf("%d %d",&cows[i][0],&cows[i][1]);
    long long r1 = 0, r2 = 0, a, b, d = 1ll;
    int x, y;
    for (int i = 0; i < n; ++i) {
        scanf("%d %d", &x, &y);
        a = d * (y1 - y) * (y1 - y) + d * (x1 - x) * (x1 - x);
        b = d * (y2 - y) * (y2 - y) + d * (x2 - x) * (x2 - x);
        cout << a << ":" << b << endl;
        if (r1 >= a || r2 >= b) continue;

        if (a - r1 >= b - r2) r2 = b;
        else r1 = a;
        cout << " ========================== " << r1 << ":" << r2 << endl;
    }
    printf("%lld\n", (r1 + r2));
    return 0;
}