//
// Created by chenqwwq on 2023/3/26.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    bool findSubarrays(vector<int> &nums) {
        int n = (int) nums.size();
        set<int> hash;
        for (int i = 0; i < n - 1; i++) {
            int sum = nums[i] + nums[i+1];
            if(hash.find(sum) != hash.end()) return true;
            hash.insert(sum);
        }
        return false;
    }
};