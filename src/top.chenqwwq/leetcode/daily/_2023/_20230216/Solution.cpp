//
// Created by chenqwwq on 2023/2/16.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    vector<int> numberOfPairs(vector<int> &nums) {
        int hash[100];
        ::memset(hash, 0, sizeof hash);
        for (int num: nums)hash[num]++;
        vector<int> ans(2, 0);
        for (int cnt: hash) {
            ans[0] += (cnt / 2);
        }
        ans[1] = nums.size() - 2 * ans[0];
        return ans;
    }

};

int main() {
    vector<int> ans = {1, 3, 2, 1, 3, 2, 2};
    (new Solution)->numberOfPairs(ans);
}