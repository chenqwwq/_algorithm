//
// Created by 陈炳鑫 on 2022/1/16.
//

#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int minMoves(int target, int maxDoubles) {
        int ans = 0;
        while (maxDoubles > 0 && target > 1) {
            if ((target & 1) == 1) {
                ans++;
                target--;
            } else {
                maxDoubles--;
                target >>= 1;
                ans++;
            }
        }
        return ans + (target - 1);
    }
};

int main() {
    Solution *pSolution = new Solution;
    pSolution->minMoves(10, 4);
}