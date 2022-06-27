//
// Created by chenqwwq on 2022/5/24.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

int maxn = 5001;

class Solution {
public:
    void wiggleSort(vector<int> &nums) {
        int n = (int) nums.size();
        int cnt[maxn];
        for (int &num: cnt) num = 0;
        for (int num: nums) cnt[num]++;
        int i = 1, p = 5000;
        while (i < n) {
            if (!cnt[p]) {
                p--;
                continue;
            }
            nums[i] = p;
            cnt[p]--;
            i += 2;
        }
        i = 0;
        while (p) {
            if (!cnt[p]) {
                p--;
                continue;
            }
            nums[i] = p;
            cnt[p]--;
            i += 2;
        }
    }
};