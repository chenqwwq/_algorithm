//
// Created by 陈炳鑫 on 2022/2/20.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    vector<long long> maximumEvenSplit(long long finalSum) {
        if ((finalSum & 1) == 1) return {};
        vector<long long> ans;
        int curr = 2;
        while (curr <= finalSum) {
            ans.push_back(curr);
            finalSum -= curr;
            curr += 2;
        }
        ans.back() += finalSum;
        return ans;
    }
};