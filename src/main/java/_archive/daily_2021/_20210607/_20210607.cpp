//
// Created by chen on 2021/6/7.
//

using namespace std;

#include "vector"

class Solution {
    int ans = 0;
public:
    int findTargetSumWays(vector<int> &nums, int target) {
        dfs(nums, 0, target);
        return ans;
    }

private:
    void dfs(vector<int> &nums, int curr, int target) {
        if (curr >= nums.size()) {
            if (target == 0) {
                ans++;
            }
            return;
        }
        dfs(nums, curr + 1, target + nums[curr]);
        dfs(nums, curr + 1, target - nums[curr]);
    }
};

