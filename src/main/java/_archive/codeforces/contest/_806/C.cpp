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
    int t, n, m;
    string str;
    int nums[101];
    cin >> t;
    while (t--) {
        cin >> n;
        for (int i = 0; i < n; i++) cin >> nums[i];
        for (int i = 0; i < n; i++) {
            cin >> m >> str;
            for (int j = 0; j < m; j++) {
                if (str[j] == 'D') nums[i] = nums[i] == 9 ? 0 : nums[i] + 1;
                else nums[i] = nums[i] == 0 ? 9 : nums[i] - 1;
            }
            cout << nums[i];
            if (i == n - 1) cout << endl;
            else cout << " ";
        }
    }
    return 0;
}