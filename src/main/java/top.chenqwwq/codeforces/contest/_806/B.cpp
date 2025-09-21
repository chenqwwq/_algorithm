//
// Created by chenqwwq on 2022/7/12.
//


#include "bits/stdc++.h"
#include "common.h"

#include "iostream"

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int t, n;
    bool vis[26];
    string str;
    cin >> t;
    while (t--) {
        for (bool &v: vis) v = false;
        cin >> n;
        cin >> str;
        long long ans = 0;
        for (int i = 0; i < n; i++) {
            if (vis[str[i] - 'A']) {
                ans++;
            } else {
                vis[str[i] - 'A'] = true;
                ans += 2;
            }
        }
        cout << ans << endl;
    }
    return 0;
}