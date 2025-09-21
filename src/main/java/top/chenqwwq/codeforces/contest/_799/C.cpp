//
// Created by chenqwwq on 2022/6/14.
//


#include "bits/stdc++.h"
#include "common.h"

#include "iostream"

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;
    string ch[8];
    while (t--) {
        for (auto &i: ch) cin >> i;
        for (int i = 1; i < 7; ++i) {
            for (int j = 1; j < 7; ++j) {
                if (ch[i][j] == '#' && ch[i - 1][j - 1] == '#' && ch[i - 1][j + 1] == '#' && ch[i + 1][j - 1] == '#' &&
                    ch[i + 1][j + 1] == '#') {
                    cout << i+1 << " " << j+1 << endl;
                }
            }
        }
    }
    return 0;
}