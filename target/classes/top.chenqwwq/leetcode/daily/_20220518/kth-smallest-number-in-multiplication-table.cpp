//
// Created by chenqwwq on 2022/5/18.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int cnt(int m, int n, int pos) {
        int cnt = 0;
        for (int i = 1; i <= m; ++i) {
            cnt += min(n, pos / i);
        }
        return cnt;
    }

    int findKthNumber(int m, int n, int k) {
        int l = 0, r = m * n;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (cnt(m, n, mid) >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

};