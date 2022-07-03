//
// Created by chenqwwq on 2022/6/3.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int consecutiveNumbersSum(int n) {
        int ans = 0;
        n *= 2;
        for (int i = 1; i * i < n; ++i) {
            if(n % i) continue;
            if(!((n / i - (i - 1)) % 2)) ans++;
        }
        return ans;
    }
};