//
// Created by 陈炳鑫 on 2022/3/13.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int maximumTop(vector<int> &nums, int k) {
        int n = nums.size();
        vector<int> keys;
        unordered_map<int, vector<int>> keyAndIdxs;
        for (int i = 0; i <= min(n - 1, k); ++i) {
            if (keyAndIdxs.find(nums[i]) == keyAndIdxs.end()) {
                keys.push_back(nums[i]);
                keyAndIdxs[nums[i]] = vector<int>();
            }
            keyAndIdxs[nums[i]].push_back(i);
        }

        sort(keys.begin(), keys.end(), greater<int>());

        for (int num: keys) {
            for (int idx: keyAndIdxs[num]) {
                int t = k - idx;
                if (t % 2 == 0 || (t > 1 && n > 1)) {
                    return num;
                }
            }
        }
        return -1;
    }
};

int main() {
    vector<int> v1{73,63,62,16,95,92,93,52,89,36,75,79,67,60,42,93,93,74,94,73,35,86,96};
    (new Solution)->maximumTop(v1, 59);
}