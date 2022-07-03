//
// Created by chenqwwq on 2022/5/20.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

int main() {
    int t, n, m;
    cin >> t;
    while (t--) {
        cin >> n >> m;
        int nums[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                cin >> nums[i][j];
            }
        }
    }
}