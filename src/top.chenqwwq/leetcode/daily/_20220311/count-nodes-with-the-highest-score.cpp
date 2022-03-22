//
// Created by 陈炳鑫 on 2022/3/11.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int countHighestScoreNodes(vector<int> &parents) {
        int n = parents.size();

        vector<vector<int>> tree(n, vector<int>());
        for (int i = 0; i < n; ++i) {
            if (parents[i] == -1) continue;
            tree[parents[i]].push_back(i);
        }

        unordered_map<int, long> memo;
        std::function<long(int)> dfs;
        dfs = [&](int i) -> long {
            if (memo.find(i) != memo.end()) return memo[i];
            if (tree[i].empty()) return 1;
            long cnt = 1;
            for (int child: tree[i]) cnt += dfs(child);
            memo[i] = cnt;
            return cnt;
        };

        long mmax = 0;
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            long cur = 1;
            if (tree[i].empty()) cur = n - 1;
            else {
                long sum = 1;
                for (int child: tree[i]) {
                    long cc = dfs(child);
                    sum += cc;
                    cur *= cc;
                }
                cur *= max(1L, n - sum);
            }
            if (cur > mmax) {
                mmax = cur;
                cnt = 1;
            } else if (cur == mmax) {
                cnt++;
            }
        }
        return cnt;
    }
};

int main() {
    vector<int> p1{-1, 2, 0, 2, 0};
    (new Solution)->countHighestScoreNodes(p1);
}