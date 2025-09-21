//
// Created by chenqwwq on 2025/5/27.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int longestPalindrome(vector<string> &words) {
        unordered_map<string, int> map;

        for (string s: words)map[s]++;

        int ans = 0;
        bool mid = false;
        for (auto [k, v]: map) {
            if (k[0] == k[1]) {
                ans += v / 2 * 4;
                mid = mid | (v % 2);
                continue;
            }
            string s;
            s.push_back(k[1]);
            s.push_back(k[0]);
            if (map.find(s) != map.end()) {
                ans += min(v, map[s]) * 2;
            }
        }
        return ans + (mid ? 2 : 0);
    }
};