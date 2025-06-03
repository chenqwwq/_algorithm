//
// Created by chenqwwq on 2025/5/14.
//


#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int MOD = 1e9 + 7;

    unordered_map<int,int> kmemo;

    int getH(int t) {
        if(kmemo.find(t) != kmemo.end()) return kmemo[t];
        if (t < 26) return 1;
        int ret = ((getH(t - 26) % MOD) + (getH(t - 25) % MOD)) % MOD;
        return kmemo[t] = ret;
    }

    int lengthAfterTransformations(string s, int t) {
        int ans = 0;
        for (char c: s) {
            int k = c - 'a' + t;
            ans = (ans + (getH(k))) % MOD;
        }
        return ans;
    }
};