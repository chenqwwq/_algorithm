//
// Created by chenqwwq on 2025/9/28.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    string majorityFrequencyGroup(string s) {
        int n = s.size();

        // 统计每种字符出现次数
        int cnt[26] = {0};
        for (char c : s) cnt[c - 'a']++;

        // 构造频率组
        string group[n + 1];
        for (int c = 0; c < 26; c++) if (cnt[c])
            group[cnt[c]].push_back(c + 'a');

        string ans = "";
        for (int i = n; i > 0; i--) if (group[i].size() > ans.size()) ans = group[i];
        return ans;
    }
};
