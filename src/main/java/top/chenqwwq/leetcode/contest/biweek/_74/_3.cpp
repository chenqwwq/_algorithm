//
// Created by 陈炳鑫 on 2022/3/19.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int halveArray(vector<int> &nums) {
        priority_queue<double> q;
        double sum = 0;
        for (int num: nums) {
            q.push(double(num));
            sum += num;
        }
        double target = sum / 2;
        int ans = 0;
        while (sum > target) {
            double d = q.top();
            d /= 2;
            sum -= d;
            q.pop();
            q.push(d);
            ans++;
        }
        return ans;
    }
};