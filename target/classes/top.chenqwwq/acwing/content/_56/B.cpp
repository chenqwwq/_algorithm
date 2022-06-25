//
// Created by chenqwwq on 2022/6/18.
//


#include "stdc++.h"
#include "common.h"

#include "iostream"
#include "algorithm"

using namespace std;

int main() {
    int INF = 0x3f3f3f3f;
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, k;
    cin >> n >> k;
    int nums[n];
    for (int &num: nums) cin >> num;
    sort(nums, nums + n);

    int ans = 0;
    int mmax = -INF, cnt = 0;
    for (int num: nums) {
        if (num - mmax > k) {
            ans += cnt;
            mmax = num;
            cnt = 1;
        } else if (mmax == num) {
            cnt++;
        } else {
            mmax = num;
            cnt = 1;
        }
    }
    cout << ans + cnt << endl;
    return 0;
}