//
// Created by chenqwwq on 2022/5/20.
//


#include <iostream>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    int t, a, b;
    cin >> t;
    while (t--) {
        cin >> a >> b;
        if (!a) printf("1\n");
        else printf("%d\n", a + (b << 1) + 1);
    }
    return 0;
}