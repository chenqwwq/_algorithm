//
// Created by chenqwwq on 2024/6/30.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int N = 6;

    int maximumLength(vector<int> &nums, int k) {
        auto n = nums.size();
        if (n < 3) return n;
        vector<vector<int>> dp(2, vector<int>(N, 0));  // 每个余数目前的最大长度
        vector<vector<int>> d2(N, vector<int>(N, 0));        // 记录每类余数x组成余数y的最大长度

        int flag = 1, ans = 0;
        dp[0][nums[0] % k]++;
        d2[nums[0] % k][nums[0] % k]++;
        ans = 1;

        // 遍历整个数组
        for (int i = 1; i < n; i++) {
            // 计算余数
            int d = nums[i] % k;
            // j 为中间数
            for (int j = 0; j < k; j++) {
                int target = (j + d) % k;
                if (!d2[j][target])continue;
                dp[flag][j] = max(dp[flag][target], ++d2[j][target]);
                ans = max(dp[flag][j], ans);
            }
            flag ^= 1;
        }
        return ans;
    }
};

int main() {
    vector<int> nums{1, 2, 3, 4, 5};
    (new Solution)->maximumLength(nums, 2);
}