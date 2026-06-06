//
// Created by chenqwwq on 2024/6/24.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int minimumOperations(vector<int> &nums) {
        int ans = 0;
        for (auto num: nums) {
            ans += num % 3 == 0 ? 0 : min(3 - (num % 3), (num % 3) );
        }
        return ans;
    }
};