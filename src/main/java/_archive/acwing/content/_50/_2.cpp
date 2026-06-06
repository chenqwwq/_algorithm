//
// Created by 陈炳鑫 on 2022/5/7.
//


#include <iostream>

using namespace std;

int main() {
    int n, m, a, b;
    cin >> n;
    int x1 = -1, y1 = 0x3f3f3f3f;
    for (int i = 0; i < n; ++i) {
        cin >> a >> b;
        x1 = max(x1, a);
        y1 = min(y1, b);
    }
    cin >> m;
    int x2 = -1, y2 = 0x3f3f3f3f;
    for (int i = 0; i < m; i++) {
        cin >> a >> b;
        x2 = max(x2, a);
        y2 = min(y2, b);
    }

    printf("%d\n", max(0, max(x1 - y2, x2 - y1)));
    return 0;
}