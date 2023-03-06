//
// Created by chenqwwq on 2023/1/23.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    double calculateTax(vector<vector<int>> &brackets, int income) {
        double ans = 0;
        int pre = 0;
        for (auto bracket: brackets) {
            if (income <= 0) break;
            int diff = bracket[0] - pre;
            if (diff <= income) ans += diff * ((double )bracket[1] / 100);
            else ans += income * ((double )bracket[1] / 100);
            pre = bracket[0];
        }
        return ans;
    }
};