//
// Created by chenqwwq on 2023/1/13.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int rearrangeCharacters(string s, string target) {
        int h[26], th[26]
        ;
        ::memset(h,0,sizeof h);
        ::memset(th,0,sizeof th);
        for (char c: s) h[c - 'a']++;

        int ans = 0x3f3f3f3f;
        for (int i = 0; i < 26; i++) {
            if(th[i] == 0) continue;
            ans = min(ans,h[i]/ th[i]);
        }
        return ans;
    }
};