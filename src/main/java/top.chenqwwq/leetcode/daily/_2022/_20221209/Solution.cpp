//
// Created by chenqwwq on 2022/12/9.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    bool checkPowersOfThree(int n) {
        vector<int> nums;
        int k = 1;
        while (k <= n) {
            nums.push_back(k);
            k *= 3;
        }

        function<bool(int, int)> dfs;
        dfs = [&](int cur, int i) -> bool {
            if (cur == n) return true;
            if (cur > n || i >= nums.size()) return false;
            return dfs(cur + nums[i], i + 1) || dfs(cur, i + 1);
        };
        return dfs(0, 0);
    }
};

int main(){
    (new Solution)->checkPowersOfThree(27);
}