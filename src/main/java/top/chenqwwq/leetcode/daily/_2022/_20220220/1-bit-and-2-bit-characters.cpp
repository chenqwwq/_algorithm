//
// Created by 陈炳鑫 on 2022/2/20.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    bool isOneBitCharacter(vector<int> &bits) {
        int n = bits.size();
        int i = 0;
        for (; i < n - 1; ++i) {
            if(bits[i] == 0) continue;
            else i++;
        }
        return i < n;
    }
};