//
// Created by 陈炳鑫 on 2022/3/24.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

int rand7();

class Solution {
public:
    int rand10() {
        while (true) {
            int num = (rand7() - 1) * 7 + (rand7() - 1);
            if (num > 0 && num <= 40) return num % 10 + 1;
        }
    }
};