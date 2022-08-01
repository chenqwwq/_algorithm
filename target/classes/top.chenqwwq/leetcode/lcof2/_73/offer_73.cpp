//
// Created by chenqwwq on 2022/1/11.
//

#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int N, H;

    int minEatingSpeed(vector<int> &piles, int h) {
        N = piles.size();
        H = h;
        if (N > h) return -1;

        int l = 1, r = 1;
        for (int cnt: piles) r = max(cnt, r);

        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (check(piles, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    bool check(vector<int> &piles, int K) {
        int days = 0;
        for (int cnt: piles) {
            days += cnt / K + (cnt % K == 0 ? 0 : 1);
        }
        return days <= H;
    }
};