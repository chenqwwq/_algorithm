//
// Created by 陈炳鑫 on 2022/3/27.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    vector<vector<int>> threeSum(vector<int> &nums) {
        auto n = nums.size();
        if (nums.empty() || nums.size() < 3) return {};
        sort(nums.begin(), nums.end());
        vector<vector<int>> ans;
        for (int i = 0; i < n; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int target = -nums[i];
            int l = i + 1, r = n - 1;
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum < target) {
                    while (++l < r && nums[l] == nums[l - 1]) {}
                } else if (sum > target) {
                    while (l < --r && nums[r] == nums[r + 1]) {}
                } else {
                    ans.push_back({nums[i], nums[l], nums[r]});
                    while (++l < r && nums[l] == nums[l - 1]) {}
                    while (l < --r && nums[r] == nums[r + 1]) {}
                }
            }
        }
        return ans;
    }
};

int main() {
    vector<int> v1{-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};
    (new Solution)->threeSum(v1);
}