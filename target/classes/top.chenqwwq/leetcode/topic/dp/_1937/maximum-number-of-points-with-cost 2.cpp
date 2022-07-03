//
// Created by 陈炳鑫 on 2022/3/29.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

typedef long long ll;

class Solution {
public:
    ll maxPoints(vector<vector<int>> &points) {
        auto n = points.size(), m = points[0].size();
        vector<vector<ll>> dp(2, vector<ll>(m));
        for (int i = 0; i < m; ++i) dp[0][i] = points[0][i];

        int flag = 1;
        for (int i = 1; i < n; ++i) {
            ll mmax = INT_MIN;
            int cur = flag ^ 1;
            for (int j = 0; j < m; ++j) {
                mmax = max(mmax, dp[cur][j] + j);
                dp[flag][j] = max(dp[flag][j], points[i][j] - j + mmax);
            }
            mmax = INT_MIN;
            for (int j = m - 1; j >= 0; --j) {
                mmax = max(mmax, dp[cur][j] - j);
                dp[flag][j] = max(dp[flag][j], points[i][j] + j + mmax);
            }

            flag ^= 1;
        }
        return *max_element(dp[flag ^ 1].begin(), dp[flag ^ 1].end());
    }
};

int main() {
    vector<vector<int>> v{{1, 2, 3},
                          {1, 5, 1},
                          {3, 1, 1}};
    cout << (new Solution)->maxPoints(v) << endl;
}