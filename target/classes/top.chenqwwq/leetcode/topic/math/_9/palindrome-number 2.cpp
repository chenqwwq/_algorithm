//
// Created by 陈炳鑫 on 2022/3/25.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    bool isPalindrome(int x) {
        if(x < 0) return false;
        vector<int> v;
        while (x > 0) {
            v.push_back(x % 10);
            x /= 10;
        }
        for (int i = 0, j = v.size()-1; i < j; ++i, --j) {
            if(v[i] != v[j]) return false;
        }
        return true;
    }
};