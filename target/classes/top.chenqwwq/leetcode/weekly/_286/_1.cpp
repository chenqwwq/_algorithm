//
// Created by 陈炳鑫 on 2022/3/27.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    vector<vector<int>> findDifference(vector<int>& nums1, vector<int>& nums2) {
        unordered_set<int>s1(nums1.begin(),nums1.end()),s2(nums2.begin(),nums2.end());
        vector<vector<int>>ans(2, vector<int>());
        for (int num : s1){
            if(s2.find(num) == s2.end()) ans[0].push_back(num);
        }
        for (int num : s2){
            if(s1.find(num) == s1.end()) ans[1].push_back(num);
        }
        return ans;
    }
};