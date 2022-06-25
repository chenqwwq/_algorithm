//
// Created by 陈炳鑫 on 2022/4/19.
//


#include "stdc++.h"
#include "common.h"
#include <vector>

using namespace std;

class Solution {
public:
    vector<int> lexicalOrder(int n) {
        vector<int> ans;
        function<void(int)> dfs;
        dfs = [&](int i) {
            if (i > n) return;
            const int flag = i / 10;
            while (i <= n && i / 10 == flag) {
                ans.push_back(i);
                dfs(i++ * 10);
            }
        };
        dfs(1);
        return ans;
    }
};