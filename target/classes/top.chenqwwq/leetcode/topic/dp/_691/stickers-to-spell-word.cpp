//
// Created by chenqwwq on 2022/5/16.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

// 状态压缩

class Solution {
public:
    int minStickers(vector<string> &ss, string t) {
        int n = (int) t.length();
        int maxn = 1 << n,INF = 0x3f3f3f3f;
        vector<int> memo(maxn, -1);
        function<int(int)> dfs = [&](int sta) -> int {
            if (sta == maxn - 1) return 0;
            if (memo[sta] != -1) return memo[sta];
            int ans = INF;
            for (const string& s: ss) {
                int nsta = sta;
                for (char c: s) {
                    for (int i = 0; i < n; i++) {
                        if (c == t[i] && !((nsta >> i) & 1)) {
                            nsta |= (1 << i);
                            break;
                        }
                    }
                }
                // sta 的状态可以由 nsta 转化而来
                if (sta != nsta) ans = min(ans, dfs(nsta) + 1);
            }
            return memo[sta] = ans;
        };
        // 从0开始恢复到 (1 << (n+1)) - 1
        int ans = dfs(0);
        return ans == INF ? -1 : ans;
    }
};