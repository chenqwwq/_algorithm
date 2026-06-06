//
// Created by chenqwwq on 2022/1/16.
//

#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    long long mostPoints(vector<vector<int>> &questions) {
        auto n = questions.size();
        long long dp[n];
        dp[n - 1] = questions[n - 1][0];
        for (int i = n - 2; i >= 0; --i) {
            auto question = questions[i];
            int pos = i + question[1] + 1;
            dp[i] = max(pos < n ? question[0] + dp[pos] : question[0], dp[i + 1]);
        }
        return dp[0];
    }
};

int main() {
    vector<vector<int>> vec = {{3, 2},
                               {4, 3},
                               {4, 4},
                               {2, 5}};

    (new Solution)->mostPoints(vec);

}