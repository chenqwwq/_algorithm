//
// Created by chenqwwq on 2022/1/6.
//

#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int mySqrt(int x) {
        int l = 1, r = x;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (mid <= x / mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }
};