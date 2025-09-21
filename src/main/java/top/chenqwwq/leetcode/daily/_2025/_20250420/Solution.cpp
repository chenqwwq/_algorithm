//
// Created by chenqwwq on 2025/4/20.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int numRabbits(vector<int> &answers) {
        int hash[1001];
        memset(hash, 0, size(hash));
        for (auto cnt: answers) hash[cnt]++;
        int ans = hash[0];
        for (int i = 1; i < 1001; i++) {
            if (hash[i] == 0) continue;
            ans += (i + 1) * ((hash[i] / (i + 1)) + (hash[i] % (i + 1) == 0 ? 0 : 1));
        }
        return ans;
    }
};