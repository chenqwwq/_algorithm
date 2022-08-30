//
// Created by chenqwwq on 2022/8/4.
//


#include "bits/stdc++.h"
#include "iostream"

using namespace std;
const int N = 1e5 + 10;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n, m, num, curr = 1;
    vector<int> cnt(N, 0), f(N, 0);
    cin >> n >> m;
    while (m--) {
        cin >> num;
        f[++cnt[num]]++;
        if (f[curr] >= n) {
            cout << '1';
            curr++;
        } else cout << '0';
    }
    cout << endl;
    return 0;
}