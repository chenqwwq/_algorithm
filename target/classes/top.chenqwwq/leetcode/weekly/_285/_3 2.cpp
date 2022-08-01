//
// Created by 陈炳鑫 on 2022/3/20.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    vector<int> maximumBobPoints(int numArrows, vector<int> &aliceArrows) {
        int k = aliceArrows.size();
        vector<int> minArrows(k, 0);
        for (int i = 0; i < k; ++i) minArrows[i] = aliceArrows[i] + 1;
        int mmax = 0, state = -1;
        for (int i = 1; i < 1 << k; ++i) {
            int cnt = 0, grade = 0;
            for (int j = 0; j < k; ++j) {
                if ((i & (1 << j))) {
                    cnt += minArrows[j];
                    grade += j;
                }
            }
            if(cnt > numArrows) continue;
            if (grade > mmax) {
                mmax = grade;
                state = i;
            }
        }

        vector<int> ans(k, 0);
        int sum = 0;
        for (int j = 0; j < k; ++j) {
            if ((state & (1 << j))){
                ans[j] = minArrows[j];
                sum += ans[j];
            }
        }
        ans[0] += numArrows - sum;
        return ans;
    }
};