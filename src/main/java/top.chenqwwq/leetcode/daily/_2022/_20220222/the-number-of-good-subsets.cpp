//
// Created by 陈炳鑫 on 2022/2/22.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

typedef long long ll;

class Solution {
public:
    int mod = 1e9+7;
    int factors[10]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    unordered_map<int, unordered_map<int, ll>> memo;
    int numberOfGoodSubsets(vector<int> &nums) {
        int n = nums.size();
        vector<int> states(n, 0);
        for (int i = 0; i < n; ++i) states[i] = getState(nums[i]);
        return (int)dfs(states, 0, 0);
    }

    ll dfs(vector<int> &states, int i, int curr) {
        if (memo.find(i) != memo.end() && memo[i].find(curr) != memo[i].end()) return memo[i][curr];
        if (i >= states.size()) return curr > 1;
        ll ans = dfs(states, i + 1, curr) % mod;
        if (states[i] != -1 && (states[i] == 1 || (curr & states[i]) == 0)) ans = (ans + dfs(states, i + 1,
                                                                                             states[i] | curr) % mod);
        memo[i][curr] = ans;
        return ans;
    }

    int getState(int num) {
        if (num == 1) return -1;
        int state = 0;
        while (true) {
            for (int factor: factors) {
                if (factor > num) return state;
                if (!(num % factor)) {
                    if (state & (1 << factor)) return -1;
                    state |= (1 << factor);
                    num = (num == factor ? 0 : num / factor);
                    break;
                }
            }
        }
    }
};

int main() {
    vector<int> p1{10,11,5,1,10,1,3,1,26,11,6,1,1,15,1,7,22,1,1,1,1,1,23,1,29,5,6,1,1,29,1,1,21,19,1,1,1,2,1,11,1,15,1,22,14,1,1,1,1,6,7,1,14,3,5,1,22,1,1,1,17,1,29,2,1,15,10,1,5,7,1,1,1,30,1,30,1,21,10,1,1,1,1,1,2,6,5,7,3,1,1,19,29,1,7,13,14,1,5,26,19,11,1,1,1,1,1,1,1,1,22,15,1,1,13,1,17,1,1,1,13,6,1,10,1,1,17,1,1,3,14,7,17,1,13,1,1,1,1,1,11,1,1,6,1,1,1,1,1,2,1,30,2,26,1,1,14,1,26,29,30,1,13,21,1,1,14,21,1,23,1,15,23,21,1,30,19,19,1,10,23,3,3,17,22,2,26,1,11,1,23,1,1,1,15,1,1,13,1,1};
    Solution *pSolution = new Solution;
    cout << pSolution->numberOfGoodSubsets(p1) << endl;
}