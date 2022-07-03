//
// Created by chenqwwq on 2022/5/21.
//


#include <iostream>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int num;
    cin >> num;
    int ans = 0, i = 1;
    while (num) {
        int cost = (i * (i + 1)) / 2;
        if (num < cost) break;
        num -= cost;
        ans++;
        i++;
    }
    printf("%d\n",ans);
    return 0;
}