//
// Created by chenqwwq on 2023/2/24.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int minimumOperations(vector<int> &nums) {
        int hash[101];
        ::memset(hash, 0, sizeof(hash));
        int ans = 0;
        for (int num: nums) {
            if (num && ++hash[num] == 1) {
                ans++;
            }
        }
        return ans;
    }
};