//
// Created by 陈炳鑫 on 2022/5/12.
//


#include <iostream>
#include <algorithm>

using namespace std;

const int manx = 1e6 + 9;
int a[manx];

int main() {
    int t, n;
    cin >> t;
    while (t--) {
        cin >> n;
        for (int i = 0; i < n; ++i) cin >> a[i];
        int x = 0, i = 0;
        if (n % 2) {
            x = a[0];
            i = 1;
        }
        bool no = false;
        for (; i < n; i += 2) {
            if (a[i] >= x && a[i + 1] >= x) {
                x = max(a[i], a[i + 1]);
            } else no = true;
        }
        printf("%s\n",no ? "NO" : "YES");
    }
    return 0;
}