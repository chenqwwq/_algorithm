//
// Created by chenqwwq on 2024/6/9.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int numberOfChild(int n, int k) {
        int i = 0;
        bool flag = true;
        while (k-- > 0) {
            if (flag) {
                if (++i >= n - 1) flag = false;
            } else {
                if (--i <= 0) flag = true;
            }
        }
        return i;
    }
};