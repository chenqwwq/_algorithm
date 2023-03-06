//
// Created by chenqwwq on 2023/1/4.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int maxValue(int n, int index, int maxSum) {
        auto sum = [](long x, int cnt) {
            return x >= cnt ? (x + x - cnt + 1) * cnt / 2 : (x + 1) * x / 2 + cnt - x;
        };
        int l = 1, r = maxSum;
        while (l < r) {
            // 二分 index 位置的值
            int mid = (l + r + 1) >> 1;
            if (sum(mid-1,index) + sum(mid,n-index) <= maxSum) l = mid;
            else r = mid - 1;
        }
        return l;
    }
};

int main() {
    (new Solution)->maxValue(8, 7, 14);
}