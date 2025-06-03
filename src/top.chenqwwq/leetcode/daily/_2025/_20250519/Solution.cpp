//
// Created by chenqwwq on 2025/5/21.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    string triangleType(vector<int> &nums) {
        int a = nums[0], b = nums[1], c = nums[2];
        if (a + b > c && a + c > b && b + c > a) {
            if (a == b && b == c) return "equilateral";
            if (a == b || b == c || a == c) return "isosceles";
            return "scalene";
        }
        return "none";
    }
};