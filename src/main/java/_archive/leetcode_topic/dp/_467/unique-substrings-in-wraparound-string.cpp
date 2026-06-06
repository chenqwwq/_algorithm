//
// Created by chenqwwq on 2022/5/13.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int cnt[26];

    int findSubstringInWraproundString(string p) {
        int n = (int) p.length();
        int ans = 0, l = 0, r = 0;
        memset(cnt, 0x00, sizeof(cnt));
        while (r < n) {
            if (r == 0 || p[r] - p[r - 1] == 1 || p[r - 1] - p[r] == 25) {
                cnt[p[r] - 'a'] = max(r - l + 1, cnt[p[r] - 'a']);
            } else {
                cnt[p[r] - 'a'] = max(1, cnt[p[r] - 'a']);
                l = r;
            }
            r++;
        }
        for (int num: cnt) ans += num;
        return ans;
    }
};

int main() {
    Solution *p = new Solution;
    p->findSubstringInWraproundString("abcdefghijklmnopqrstuvwxyza");
}