//
// Created by chenqwwq on 2023/2/23.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    vector<int> circularPermutation(int n, int start) {
        int len = (int) pow(2, n);
        vector<int> ans(len, 0);
        bool exist[len];
        for (int i = 0; i < len; i++) {
            exist[i] = false;
        }
        ans[0] = start;
        auto check = [](int val) -> bool {
            int c = 0;
            while (val != 0) {
                c += val & 1;
                val >>= 1;
            }
            return c == 1;
        };
        exist[start] = true;
        function<bool(int)> dfs;
        dfs = [&](int k) -> bool {
            if (k == len) return check(ans[k - 1] ^ ans[0]);
            for (int i = 0; i < len; i++) {
                if (exist[i]) continue;
                if (check(ans[k - 1] ^ i)) {
                    exist[i] = true;
                    ans[k] = i;
                    if (dfs(k + 1)) return true;
                    exist[i] = false;
                }
            }
            return false;
        };
        dfs(1);
        return ans;
    }
};
