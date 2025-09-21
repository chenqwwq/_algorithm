//
// Created by chenqwwq on 2024/6/30.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int maximumLength(vector<int> &nums) {
        auto n = nums.size();
        if(n < 3) return n;
        int c1 = 0, c2 = 0, c3 = 0, c4 = 0;
        bool f1 = true, f2 = true;
        for (int i = 0; i < n; i++) {
            if (nums[i] & 1) {
                c1++;
                if (f1) {
                    c3++;
                    f1 = !f1;
                }
                if (!f2) {
                    c4++;
                    f2 = !f2;
                }
            } else {
                c2++;
                if (f2) {
                    c4++;
                    f2 = !f2;
                }
                if (!f1) {
                    c3++;
                    f1 = !f1;
                }
            }
        }

        return max(max(c1, c2), max(c3, c4));
    }
};