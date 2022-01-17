//
// Created by 陈炳鑫 on 2022/1/15.
//

#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int totalMoney(int n) {
        int x = n / 7, y = n % 7;
        int a = x * 28;
        double b = 7 * (x - 1) * (1.0 * x / 2);
        double c = (1 + y) * (1.0 * y / 2) + (x - 1) * y;
        return a + b + c;
    }
};