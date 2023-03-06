//
// Created by chenqwwq on 2022/12/11.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int minOperations(vector<int> &nums) {
        int pre = 0, ans = 0;
        for (int num: nums) {
            if (num > pre)pre = num;
            else {
                int now = pre + 1;
                ans += now - num;
                pre = now;
            }
        }
        return ans;
    }
};