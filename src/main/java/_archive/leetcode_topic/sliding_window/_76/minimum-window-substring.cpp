//
// Created by 陈炳鑫 on 2022/3/28.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    string minWindow(string s, string t) {
        int m = s.length(), n = t.length();
        vector<int> th(58), sh(58);
        int cnt = 0;
        for (char c: t) if (!th[c - 'A']++) cnt++;

        int l = 0, r = 0;
        int len = 0x3f3f3f3f, match = 0;
        string ans;
        while (r < m) {
            int pos = (int) s[r++] - 'A';
            if (th[pos] && ++sh[pos] == th[pos]) {
                if (++match == cnt) {
                    // 正确匹配之后开始收缩
                    while (l < r) {
                        int cur = r - l;
                        if (cur < len) {
                            len = cur;
                            ans = substring(s, l, r - 1);
                        }
                        int p = (int) s[l++] - 'A';
                        if (th[p] && --sh[p] < th[p]) {
                            match--;
                            break;
                        }
                    }
                }
            }
        }
        return ans;
    }

    static string substring(string str, int l, int r) {
        string ans;
        for (int i = l; i <= r; ++i) ans += str[i];
        return ans;
    }
};