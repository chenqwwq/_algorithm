//
// Created by chenqwwq on 2022/6/8.
//

#include "iostream"

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int tt, n;
    cin >> tt;
    while (tt--) {
        cin >> n;
        int h1 = n / 3 + (n % 3 == 0 ? 1 : 2);
        int h2 = (n - h1) / 2 + 1;
        int h3 = n - h2 - h1;
        printf("%d %d %d\n", h2, h1, h3);
    }
    return 0;
}