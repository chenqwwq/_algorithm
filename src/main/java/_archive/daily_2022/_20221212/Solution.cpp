//
// Created by chenqwwq on 2022/12/12.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int beautySum(string s) {
        int n = (int) s.size();
        int hash[26], ans = 0;
        for (int i = 0; i < n; i++) {
            memset(hash, 0, sizeof hash);
            for (int j = i; j < n; j++) {
                hash[s[j] - 'a']++;
                int mmax = 0,mmin = 501;
                for(int &num : hash){
                    if(num > 0) {
                        mmax = max(mmax,num);
                        mmin = min(mmin,num);
                    }
                }
                ans += mmax - mmin;
            }
        }
        return ans;
    }
};