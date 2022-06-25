//
// Created by 陈炳鑫 on 2022/3/20.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int countHillValley(vector<int> &nums) {
        int n = nums.size();
        int ans = 0;
        bool up = true;
        int l = 1;
        while (l < n - 1) {
            if (nums[l] == nums[l - 1]){
                l++;
                continue;
            }
            up = nums[l] > nums[l - 1];
            int r = l;
            while (++r < n) {
                if (nums[r] == nums[l]) continue;
                if (nums[r] < nums[l] == up) ans ++;
                break;
            }
            l = r;
        }
        return ans;
    }
};

int main() {
    vector<int> v1{6,6,5,5,4,1};
    (new Solution)->countHillValley(v1);
}
