//
// Created by chenqwwq on 2022/8/30.
//

#include "bits/stdc++.h"
#include "iostream"
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int t, n;
    string s, k;
    cin >> t;
    while (t--) {
        cin >> n >> s >> k;
        bool eq = true;
        for (int i = 0; i < n; i++) {
            if (s[i] == k[i]) continue;
            if ((s[i] == 'G' || s[i] == 'B') && (k[i] == 'G' || k[i] == 'B')) continue;
            eq = false;
            break;
        }
        cout << (eq ? "YES" : "NO") << endl;
    }
    return 0;
}