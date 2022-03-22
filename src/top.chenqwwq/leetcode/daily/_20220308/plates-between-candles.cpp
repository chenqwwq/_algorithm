//
// Created by 陈炳鑫 on 2022/3/8.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    vector<int> platesBetweenCandles(string s, vector<vector<int>> &queries) {
        int n = s.length(),m = queries.size();
        vector<int> left(n, 0), right(n, 0), sums(n + 1, 0);
        for (int i = 0, j = n - 1, l = -1, r = -1; i < n; ++i, --j) {
            if (s[i] == '|') l = i;
            if (s[j] == '|') r = j;
            left[i] = l;
            right[j] = r;
            sums[i + 1] = sums[i] + (s[i] == '*' ? 1 : 0);
        }

        vector<int> ans(m, 0);
        for (int i = 0; i < m; ++i) {
            int x = queries[i][0], y = queries[i][1];
            if (right[x] != -1 && right[x] <= left[y]) ans[i] = sums[left[y]] - sums[right[x]];
        }
        return ans;
    }
};

int main() {
    vector<vector<int>> p1{{2, 5},
                           {5, 9}};
    (new Solution)->platesBetweenCandles("**|**|***|", p1);
}