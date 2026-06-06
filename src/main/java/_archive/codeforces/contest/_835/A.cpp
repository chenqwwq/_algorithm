//
// Created by chenqwwq on 2022/11/22.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

int main() {
    int t;
    cin >> t;
    int nums[3];
    while (t--) {
        cin >> nums[0] >> nums[1] >> nums[2];
        sort(nums, nums + 3);
        cout << nums[1] << endl;
    }
    return 0;
}