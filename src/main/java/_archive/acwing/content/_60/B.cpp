//
// Created by chenqwwq on 2022/7/23.
//


#include "bits/stdc++.h"
#include "iostream"

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, k;
    cin >> n >> k;
    int nums[n];
    for (int &num: nums) cin >> num;
    sort(nums, nums + n);
    int i = 0, sum = 0;
    while (k > 0 && i < n) {
        while (i < n && nums[i] - sum <= 0)i++;
        if(i < n){
            cout << nums[i] - sum << endl;
            sum = nums[i];
            k--;
        }
    }
    while (k-- > 0) cout << 0 << endl;
    return 0;
}