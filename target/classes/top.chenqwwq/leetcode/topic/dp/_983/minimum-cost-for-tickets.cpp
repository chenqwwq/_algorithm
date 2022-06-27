//
// Created by 陈炳鑫 on 2022/3/27.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
    const int INF = 0x3f3f3f3f;
public:
    int mincostTickets(vector<int> &v, vector<int> &c) {
        auto n = v.size();
        vector<int> d{1, 7, 30}, dp(n + 1, INF);
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= 2; ++j) {
                int cur = i - 1;
                while (cur >= 0 && v[i - 1] - v[cur] < d[j]) cur--;
                dp[i] = min(dp[i], c[j] + dp[cur + 1]);
            }
        }
        return dp[n];
    }
};

int main() {
    vector<int> v1{1, 4, 6, 7, 8, 20}, v2{2, 7, 15};
    (new Solution)->mincostTickets(v1, v2);
}
