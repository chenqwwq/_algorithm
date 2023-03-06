//
// Created by chenqwwq on 2023/2/5.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int getMaximumConsecutive(vector<int> &coins) {
        // 当前能取到的最大值
        int cur = 0, next = 1;
        // 排序保证每次获取的都是最小的数字
        sort(coins.begin(), coins.end(), [](int a, int b) { return a < b; });
        for (auto coin: coins) {
            if (coin > next) break;
            cur = coin + next - 1;
            next = cur + 1;
        }
        return cur + 1;
    }
};