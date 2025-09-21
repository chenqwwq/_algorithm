//
// Created by 陈炳鑫 on 2022/3/28.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int maximumSwap(int num) {
        vector<int> nums;
        while (num) {
            nums.push_back(num % 10);
            num /= 10;
        }
        vector<int> ss(nums.begin(), nums.end());
        std::sort(ss.begin(), ss.end(), less<int>{});
        int n = nums.size();
        for (int i = n - 1; i >= 0; --i) {
            if (ss[i] != nums[i]) {
                for (int j = 0; j < i; ++j) {
                    if (nums[j] == ss[i]) {
                        swap(nums[j], nums[i]);
                        break;
                    }
                }
                break;
            }
        }
        int base = 1, ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += nums[i] * base;
            base *= 10;
        }
        return ans;
    }
};

int main() {
    (new Solution)->maximumSwap(2736);
}
