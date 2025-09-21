//
// Created by chenqwwq on 2022/12/5.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

class Solution {
public:
    int secondHighest(string s) {
        int max = -1, ans = -1;
        for (char c: s) {
            if (c >= '0' && c <= '9') {
                int num = c - '0';
                if(num > max){
                    ans = max;
                    max = num;
                }else if(num != max && num > ans){
                    ans = num;
                }
            }
        }
        return ans;
    }
};