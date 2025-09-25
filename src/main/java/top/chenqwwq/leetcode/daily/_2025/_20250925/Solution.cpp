//
// Created by chenqwwq on 2025/9/25.
//


#include <bits/stdc++.h>
#include <vector>

typedef long long ll;


using namespace std;

class Solution {
    static constexpr int INF = 0x3f3f3f3f;

public:
    static int minimumTotal(const vector<vector<int> > &triangle) {
        int n = triangle.size();
        vector dp(n, vector(n, INF));
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle[i][j] + min(j - 1 >= 0 ? dp[i - 1][j - 1] : INF, dp[i - 1][j]);
            }
        }

        return *std::min_element(dp[n - 1].begin(), dp[n - 1].end());
    }
};
