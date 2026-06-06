//
// Created by chenqwwq on 2024/5/20.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int maxDivScore(vector<int> &nums, vector<int> &divisors) {
        int ans = 0x3f3f3f3f, max = 0;
        for (auto d: divisors) {
            int t = 0;
            for (auto n: nums) {
                if (!(n % d)) t++;
            }
            if (t > max || (t == max && d < ans)) {
                max = t;
                ans = d;
            }
        }
        return ans;
    }
};