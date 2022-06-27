//
// Created by 陈炳鑫 on 2022/3/6.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:

    vector<int> sortJumbled(vector<int> &mapping, vector<int> &nums) {
        int n = nums.size();
        unordered_map<int, int> hash, pos;
        for (int i = 0; i < n; i++) {
            int num = nums[i], res = 0, base = 1;
            pos[num] = i;
            if (!num) hash[nums[i]] = mapping[0];
            else {
                while (num) {
                    res += base * mapping[num % 10];
                    base *= 10;
                    num /= 10;
                }
                hash[nums[i]] = res;
            }
        }

        sort(nums.begin(), nums.end(), [&](int n1, int n2) -> bool {
            if (hash[n1] == hash[n2]) return pos[n1] < pos[n2];
            return hash[n1] < hash[n2];
        });
        return nums;
    }
};

int main() {
    vector<int> p1{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    vector<int> p2{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    (new Solution)->sortJumbled(p1, p2);
}