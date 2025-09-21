//
// Created by chenqwwq on 2025/5/15.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    vector<string> getLongestSubsequence(vector<string> &words, vector<int> &groups) {
        vector<string> ans;
        int n = groups.size();
        // 相同的取其中一个,不相同的都选入
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || groups[i] != groups[i + 1]) { // i 是连续相同段的末尾
                ans.push_back(words[i]);
            }
        }
        return ans;
    }
};