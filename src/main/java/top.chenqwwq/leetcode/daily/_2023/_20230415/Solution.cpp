//
// Created by chenqwwq on 2023/4/15.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    vector<int> gardenNoAdj(int n, vector<vector<int>> &paths) {
        // 重新构造图
        // 并且记录入度为1的节点
        map<int, vector<int>> dir;
        for (int i = 1; i <= n; i++)dir[i] = {};
        for (auto path: paths) {
            dir[path[0]].push_back(path[1]);
            dir[path[1]].push_back(path[0]);
        }

        vector<int> ans(n, 0);

        for (int i = 1; i <= n; i++) {
            vector<bool> cs(5, false);
            for (auto j: dir[i]) {
                cs[ans[j-1]] = true;
            }
            for (int j = 1; j <= 4; j++) {
                if (cs[j]) continue;
                ans[i - 1] = j;
                break;
            }
        }
        return ans;
    }
};

int main() {
    vector<vector<int>> paths{{1, 2},
                              {2, 3},
                              {3, 1}};
    (new Solution)->gardenNoAdj(3, paths);
}