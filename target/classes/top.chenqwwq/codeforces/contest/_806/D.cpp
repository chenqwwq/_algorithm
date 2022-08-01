//
// Created by chenqwwq on 2022/7/12.
//


#include "bits/stdc++.h"
#include "common.h"

#include "iostream"
#include "set"

using namespace std;

int main() {
    const int N = 1e5+1;
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int t, n;
    string ss[N];
    set < string > exists;
    cin >> t;
    while (t--) {
        exists.clear();
        cin >> n;
        for (int i = 0; i < n; i++) {
            cin >> ss[i];
            exists.insert(ss[i]);
        }
        for (int i = 0; i < n; i++) {
            string s = ss[i];
            int len = (int) s.length();
            bool ok = false;
            for (int j = 1; j < len; j++) {
                if (exists.count(s.substr(0, j)) && exists.count(s.substr(j, len - j))) {
                    ok = true;
                    break;
                }
            }
            cout << (ok ? '1' : '0');
        }
        cout << endl;
    }
    return 0;
}