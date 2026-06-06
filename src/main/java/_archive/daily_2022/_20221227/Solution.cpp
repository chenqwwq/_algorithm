//
// Created by chenqwwq on 2022/12/27.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int minimumMoves(string s) {
        int n = (int) s.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == 'O') continue;
            ans++;
            i += 2;
        }
        return ans;
    }
};