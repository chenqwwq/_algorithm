//
// Created by chenqwwq on 2025/5/27.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int differenceOfSums(int n, int m) {
        int ans = 0;
        for(int i = 0;i <= n;i++){
            if(i % m == 0) ans -= i;
            else ans += i;
        }
        return ans;
    }
};