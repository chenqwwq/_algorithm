//
// Created by chenqwwq on 2025/6/2.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    bool checkEqualPartitions(vector<int> &nums, long long target) {
        auto dfs = [&](auto &dfs, int i, long long c1, long long c2) {
            if (c1 == c2 && c1 == target && i == nums.size()) return true;
            if (i == nums.size()) return false;
            // 当前值属于c1
            if ((long long)c1 * nums[i] > target && (long long)c2 * nums[i] > target) return false;

            return ((long long) c1 * nums[i] <= target && dfs(dfs, i + 1, (long long) c1 * nums[i], c2)) ||
                   ((long long) c2 * nums[i] <= target && dfs(dfs, i + 1, c1, (long long) c2 * nums[i]));
        };

        return dfs(dfs, 0, 1, 1);
    }
};

int main() {
    vector<int> nums = {3, 1, 6, 8, 4};
    (new Solution)->checkEqualPartitions(nums, 24);
}