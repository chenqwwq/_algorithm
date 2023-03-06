//
// Created by chenqwwq on 2022/12/17.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int minElements(vector<int> &nums, int limit, int goal) {
        ll sum = 0;
        for (int num: nums) sum += num;
        ll diff = abs(goal - sum);
        return (int)diff / limit + (diff % limit? 1:0);
    }
};