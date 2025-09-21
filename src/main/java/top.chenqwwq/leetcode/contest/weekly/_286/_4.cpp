//
// Created by 陈炳鑫 on 2022/3/27.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;


class Solution {
public:
    int maxValueOfCoins(vector<vector<int>> &v, int k) {

    }
//    int maxValueOfCoins(vector<vector<int>> &v, int k) {
//        auto n = v.size();
//        // dp[j] 表示取j个的情况
//        vector<int> dp(k + 1);
//        int cnt = 0;
//        // 从第0个栈开始推
//        for (int i = 0; i < n; ++i) {
//            cnt += v[i].size();
//            // 前缀用来求当前栈中选择多个情况
//            for (int j = 1; j < v[i].size(); ++j) v[i][j] += v[i][j - 1];
//            // 总共取j的情况
//            for (int j = min(cnt, k); j >= 0; --j) {
//                // 前面的栈中选择l个,当前的栈中选择j-l个
//                for (int l = j - 1; l >= 0 && j - l <= v[i].size(); --l) {
//                    // 当前栈中取【j - l - 1】个
//                    dp[j] = max(dp[j], dp[l] + v[i][j - l - 1]);
//                }
//            }
//        }
//        return dp[k];
//    }
};