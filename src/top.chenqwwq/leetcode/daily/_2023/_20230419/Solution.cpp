//
// Created by chenqwwq on 2023/4/19.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;
class Solution {
public:
    int maxSumAfterPartitioning(vector<int> &arr, int k) {
        int n = (int) arr.size();
        if (k == 1) return accumulate(arr.begin(), arr.end(), 0);

        // todo: 记录的是 i-j 的最大值,可以进一步优化空间
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = 0; i < n; i++) dp[i][i] = arr[i];

        for (int j = 1; j < n; j++) {
            // j > i
            for (int i = j - 1; i >= 0; i--) {
                int len = j - i + 1;
                if (len <= k) {
                    int pre = dp[i][j - 1] / (len - 1);
                    dp[i][j] = max(pre, arr[j]) * len;
                } else {
                    dp[i][j] = dp[i][j - 1] + arr[j];
                    for (int l = j - k + 1; l < j; l++) {
                        dp[i][j] = max(dp[i][j], dp[i][l-1] + dp[l][j]);
                    }
                }
            }
        }

#ifdef TEST_ENV
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ::printf("%d\t", dp[i][j]);
            }
            cout << endl;
        }
#endif
        return dp[0][n - 1];
    }
};

int main() {
    vector<int> nums{1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3};
    (new Solution)->maxSumAfterPartitioning(nums, 4);
}