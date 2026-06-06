//
// Created by chenqwwq on 2025/4/20.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    vector<long long> resultArray(vector<int> &nums, int k) {
        auto n = nums.size();
        vector<long long> hash(k, 0);
        vector<long long> tmp(k, 0);
        long long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int cur = sum % k;
            for (int j = 0; j < k; j++) tmp[j] = 0;
            for (int j = 0; j < k; j++) {
                if (!hash[j]) continue;
                if (cur >= j) tmp[cur - j] += hash[j];
                else tmp[cur + k - j] += hash[j];
            }
            for (int j = 0; j < k; j++) hash[j] += tmp[j];
            hash[cur]++;
        }
        return hash;
    }
};

int main() {
    vector<int> nums = {1, 2, 3, 4, 5};
    (new Solution)->resultArray(nums, 3);
}