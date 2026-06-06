//
// Created by 陈炳鑫 on 2022/2/20.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int countEven(int num) {
        int ans = 0;
        for (int i = 1; i <= num; ++i) {
            if((getSum(i) & 1) == 0) ans++;
        }
        return ans;
    }

    int getSum(int sum) {
        int ans = 0;
        while (sum != 0) {
            ans += sum % 10;
            sum /= 10;
        }
        return ans;
    }
};