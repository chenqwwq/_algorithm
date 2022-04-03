//
// Created by 陈炳鑫 on 2022/3/28.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    bool hasAlternatingBits(int n) {
        while (n != 0) {
            if (!((n & 1) ^ ((n >> 1) & 1))) return false;
            n >>= 1;
        }
        return true;
    }
};