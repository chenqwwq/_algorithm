//
// Created by 陈炳鑫 on 2022/4/3.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int maximumCandies(vector<int> &candies, long long k) {
        auto n = candies.size();
        long long sum = 0;
        for (int num: candies)sum += num;
        if (sum < k) return 0;
        long long l = 1, r = sum / k;
        while (l < r) {
            long long mid = (l + r + 1) >> 1;
            // mid 表示小孩可以拿到的糖果
            long long cnt = 0;
            for (int i = 0; i < n; ++i) cnt += candies[i] / mid;
            // 不够分
            if (cnt < k) r = mid - 1;
            else l = mid;
        }
        return l;
    }
};

int main() {
    vector<int> v1{5, 8, 6};
    (new Solution)->maximumCandies(v1, 3);
}