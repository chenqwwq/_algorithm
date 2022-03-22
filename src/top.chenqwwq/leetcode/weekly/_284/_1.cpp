//
// Created by 陈炳鑫 on 2022/3/13.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    vector<int> findKDistantIndices(vector<int> &nums, int key, int k) {
        int n = nums.size();
        vector<int> keys;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == key) keys.push_back(i);
        }
        int mmin = 0;
        set<int> ans;
        for (int idx: keys) {
            int top = min(n-1, idx + k);
            for (int i = max(mmin, idx - k); i <= top; ++i) {
                ans.insert(i);
            }
            mmin = top;
        }
        vector<int> v;
        v.assign(ans.begin(),ans.end());
        sort(v.begin(),v.end());
        return v;
    }
};