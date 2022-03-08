//
// Created by 陈炳鑫 on 2022/2/20.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    vector<long long> sumOfThree(long long num) {
        if (num % 3 != 0) return {};
        return {num / 3 - 1, num / 3, num / 3 + 1};
    }
};