//
// Created by 陈炳鑫 on 2022/2/20.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    string repeatLimitedString(string s, int repeatLimit) {
        vector<int> hash(26, 0);
        for (auto c: s) hash[c - 'a']++;
        string ans;
        while (true) {
            bool flag = false;
            bool hasAdvance = false;
            for (int i = 25; i >= 0; --i) {
                if (hash[i] <= 0) continue;
                if (ans.length() != 0 && ans[ans.length() - 1] - 'a' == i) {
                    hasAdvance = true;
                    continue;
                }
                flag = true;
                int cnt = 0;
                while (cnt < repeatLimit && hash[i]-- > 0) {
                    ans += (char) (i + 'a');
                    cnt++;
                    if(hasAdvance) break;
                }
                break;
            }
            if (!flag) break;
        }
        return ans;
    }
};