//
// Created by chenqwwq on 2023/4/9.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    bool checkDistances(string s, vector<int> &distance) {
        int n = (int) s.length();
        vector<int> idxs(26,-1);
        for (int i = 0; i < n; i++) {
            int k = (int)s[i] - 'a';
            if(idxs[k] == -1) idxs[k] = i;
            else if(i - idxs[k] - 1 != distance[k]) return false;
        }
        return true;
    }
};