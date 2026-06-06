//
// Created by chenqwwq on 2025/10/2.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int numWaterBottles(int numBottles, int numExchange) {
        int cur = numBottles, remain = 0;
        int ans = 0;
        while (cur != 0) {
            ans += cur;
            remain += cur;
            cur = 0;
            cur += remain / numExchange;
            remain %= numExchange;
        }
        return ans;
    }
};