//
// Created by chenqwwq on 2024/5/26.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int numberOfPairs(vector<int>& nums1, vector<int>& nums2, int k) {
        int ans = 0;
        for(int n : nums1){
            for(int m : nums2){
                if(n % (m * k) == 0) ans++;
            }
        }
        return ans;
    }
};