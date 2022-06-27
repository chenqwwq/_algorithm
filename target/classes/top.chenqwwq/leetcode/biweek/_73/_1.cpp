//
// Created by 陈炳鑫 on 2022/3/6.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int mostFrequent(vector<int> &nums, int key) {
        int n = nums.size();
        unordered_map<int, int> hash;
        for (int i = 0; i < n - 1; i++) if (nums[i] == key) hash[nums[i + 1]]++;
        int target = -1, cnt = -1;
        for (auto[k, v]: hash) {
            if(v > cnt){
                target = k;
                cnt = v;
            }
        }
        return target;
    }
};