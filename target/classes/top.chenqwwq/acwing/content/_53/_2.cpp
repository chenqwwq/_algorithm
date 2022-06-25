//
// Created by chenqwwq on 2022/5/28.
//


#include <iostream>

using namespace std;

int main() {
    string num;
    cin >> num;
    int n = (int) num.length();
    long long ans = 0;
    if (!((num[0] - '0') % 4)) ans++;
    for (int i = 1; i < n; ++i) {
        int a = num[i] - '0', b = num[i - 1] - '0';
        if (!(a % 4)) ans++;
        if (!((b * 10 + a) % 4)) ans += i;
    }
    printf("%lld\n", ans);
    return 0;
}