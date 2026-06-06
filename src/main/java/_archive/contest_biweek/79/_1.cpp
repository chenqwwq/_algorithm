//
// Created by chenqwwq on 2022/5/29.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    bool digitCount(string num) {
        int cnt[10];
        for (int &n: cnt) n = 0;
        for (int i = 0; i < num.length(); ++i) {
            cnt[num[i] - '0']++;
            cnt[i] -= (num[i] - '0');
        }
        return all_of(cnt, cnt + 10, [](int x) { return x == 0; });
    }
};

int main() {
    Solution *pSolution = new Solution;
    pSolution->digitCount("1210");
}