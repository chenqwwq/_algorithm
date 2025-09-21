//
// Created by chenqwwq on 2022/8/1.
//


#include "bits/stdc++.h"
#include "iostream"

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    typedef long long ll;

    int n;
    cin >> n;
    int nums[n];
    for (int &num: nums) {
        cin >> num;
    }
    ll max = (ll) pow(2, 16);
    for (int i = 0; i < max; i++) {
        int ans = 0;
        for (int j = 0; j < n; j++) {
            if ((i >> j) & 1) ans = (ans + nums[j]) % 360;
            else ans = (ans - nums[j]) % 360;
        }
        if(ans == 0) {
            cout << "YES" << endl;
            return 0;
        }
    }
    cout << "NO" << endl;
    return 0;
}