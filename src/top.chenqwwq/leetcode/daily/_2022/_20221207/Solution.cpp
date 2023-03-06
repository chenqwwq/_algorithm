//
// Created by chenqwwq on 2022/12/7.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int minOperations(vector<int> &nums1, vector<int> &nums2) {
        int N = 13;
        int n = (int) nums1.size(), m = (int) nums2.size();
        if (n * 6 < m || m * 6 < n) return -1;
        int s1 = accumulate(nums1.begin(), nums1.end(), 0), s2 = accumulate(nums2.begin(), nums2.end(), 0);
        int diff = s1 - s2;
        int cnt[6]{0, 0, 0, 0, 0, 0};
    }
};