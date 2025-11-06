//
// Created by chenqwwq on 2025/10/12.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int sumDivisibleByK(vector<int> &nums, int k) {
        int hash[101] = {};

        for (int num: nums) {
            hash[num]++;
        }

        int ans = 0;
        for (int i = 0; i < 101; i++) {
            if (hash[i] == 0) continue;;
            if (hash[i] % k == 0) ans += i * hash[i];
        }
        return ans;
    }
};