//
// Created by chenqwwq on 2023/2/28.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int movesToMakeZigzag(vector<int> &nums) {
        int n = (int) nums.size();
        function<int(int, int, bool)> func;
        func = [&](int num, int i, bool less) -> int {
            if (i >= n) return 0;
            if (num <= nums[i] && less) return nums[i] - num + 1 + func(num - 1, i + 1, false);
            if (num >= nums[i] && !less) return num - nums[i] + 1 + func(nums[i], i + 1, true);
            return func(nums[i], i + 1, !less);
        };
        return min(func(0, 0, false), func(1001, 0, true));
    }
};

int main() {
    vector<int> param{7, 4, 8, 9, 7, 7, 5};
    (new Solution)->movesToMakeZigzag(param)；
}