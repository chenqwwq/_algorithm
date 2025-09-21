//
// Created by chenqwwq on 2024/5/20.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    long long sumDigitDifferences(vector<int> &nums) {
        int cnt[10][10];
        for (auto num: nums) {
            int cur = 0;
            while (num) {
                cnt[cur++][num % 10]++;
                num /= 10;
            }
        }
        long long ans = 0;
        for (auto &a: cnt) {
            for (int i = 0; i < 10; i++) {
                if (a[i] == 0) continue;
                for (int j = i + 1; j < 10; j++) {
                    ans += a[i] * a[j];
                }
            }
        }
        return ans;
    }
};