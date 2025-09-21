//
// Created by chenqwwq on 2022/11/22.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

int main() {
    int N = 2e5 + 10, INF = 0x3f3f3f3f;
    int t, n, pre, num;
    bool incr, ok;
    cin >> t;
    while (t--) {
        incr = false;
        ok = true;
        pre = INF;
        cin >> n;
        for (int i = 0; i < n; i++) {
            cin >> num;
            if (pre < num) incr = true;
            else if (pre > num && incr)ok = false;
            pre = num;
        }
        cout << (ok ? "YES" : "NO") << endl;
    }
    return 0;
}