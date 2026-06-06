//
// Created by 陈炳鑫 on 2022/5/6.
//


#include <iostream>

using namespace std;

int main() {
    int n, a, b, c, x, y;
    cin >> n;
    while (n--) {
        cin >> a >> b >> c >> x >> y;
        if (c >= (max(0, x - a) + max(0, y - b))) printf("YES\n");
        else printf("NO\n");
    }
    return 0;
}