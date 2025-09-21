//
// Created by chenqwwq on 2022/8/28.
//


#include "bits/stdc++.h"
#include "iostream"

using namespace std;

int N = (int) (3e5);

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int nums[N], n;
    cin >> n;
    for (int i = 0; i < n; i++) cin >> nums[i];
    for (int i = 1; i < n; i++) nums[i] ^= nums[i - 1];
    long long ans = 0;
    map<int, long long> c1, c2;
    c1[0] = 1;
    for (int i = 0; i < n; i++) {
        if (i & 1) {
            ans += c1[nums[i]];
            c1[nums[i]]++;
        } else {
            ans += c2[nums[i]];
            c2[nums[i]]++;
        }
    }
    cout << ans << endl;
    return 0;
}