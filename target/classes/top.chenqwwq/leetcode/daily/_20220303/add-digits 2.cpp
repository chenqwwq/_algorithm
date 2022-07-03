//
// Created by 陈炳鑫 on 2022/3/3.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int addDigits(int num) {
        if(num < 10) return num;
        int ans = 0;
        while (num){
            ans += (num % 10);
            num /= 10;
        }
        return addDigits(ans);
    }
};