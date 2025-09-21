//
// Created by 陈炳鑫 on 2022/4/2.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int minBitFlips(int start, int goal) {
        int num = start ^ goal;
        int ans = 0;
        while (num) {
            num &= (num - 1);
            ans++;
        }
        return ans;
    }
};