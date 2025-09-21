
//
// Created by chenqwwq on 2025/6/1.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
    long long c2(long long n) {
        return n > 1 ? n * (n - 1) / 2 : 0;
    }

public:
    long long distributeCandies(int n, int limit) {
        return c2(n + 2) // 所有糖果的分配方法
               - 3 * c2(n - (limit + 1) + 2) // 至少一个分配超过 limit + 1 的方案数（包含了2、3哥超过的
               + 3 * c2(n - 2 * (limit + 1) + 2) // 至少两个分配超过 limit + 1 的方案数（因为前面减多了，所以加回去
               - c2(n - 3 * (limit + 1) + 2);// 上面加多了再减回去
    }
};