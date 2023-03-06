//
// Created by chenqwwq on 2022/1/8.
//

#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    vector<int> grayCode(int n) {
        vector<int> ans;
        ans.push_back(0);
        ans.push_back(1);

        int delta = 2;

        for (int i = 2; i <= n; i++) {
            for (int j = delta - 1; j >= 0; j--) {
                ans.push_back(ans[j]+delta);
            }
            delta *= 2;
        }

        return ans;
    }
};