//
// Created by 陈炳鑫 on 2022/1/6.
//

#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int peakIndexInMountainArray(vector<int> &arr) {
        // 5 6 7 8 1 2 3 4
        int n = arr.size();
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (arr[mid - 1] < arr[mid]) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }
};