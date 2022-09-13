//
// Created by chenqwwq on 2022/9/3.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n, m;
    cin >> n >> m;
    int nums[n][m];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) cin >> nums[i][j];
    }

    int target[m];
    for (int q = 0; q < m; q++) target[q] = q + 1;
    for (int i = 0; i < m; i++) {
        for (int j = i; j < m; j++) {
            swap(target[i], target[j]);
            // check
            bool ok = true;
            for (int a = 0; a < n; a++) {
                int cnt = 0;
                for (int b = 0; b < m; b++) {
                    if (target[b] == nums[a][b])cnt++;
                }
                if (cnt < m - 2){
                    ok = false;
                    break;
                }
            }
            if(ok) {
                cout << "YES" << endl;
                return 0;
            }
            swap(target[j], target[i]);
        }
    }
    cout << "NO" << endl;
    return 0;
}