/
// Created by chenqwwq on 2025/5/17.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int minDeletion(string s, int k) {
        vector<int> hash(26, 0);
        for (char c: s) {
            hash[c - 'a']++;
        }
        vector<int> cnts;
        for (int cnt: hash) {
            if (cnt == 0) continue;
            cnts.push_back(cnt);
        }
        sort(cnts.begin(), cnts.end());

        auto n = cnts.size();
        if (n <= k) return 0;
        int ans = 0;
        for (int i = 0; i < n - k; i++) ans += cnts[i];
        return ans;
    }
};