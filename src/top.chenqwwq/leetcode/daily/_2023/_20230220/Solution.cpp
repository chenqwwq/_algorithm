//
// Created by chenqwwq on 2023/2/20.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    string bestHand(vector<int> &ranks, vector<char> &suits) {
        bool flush = true;
        int cnt = 0;
        int hash[14];
        ::memset(hash, 0, sizeof hash);
        for (int i = 0; i < 5; i++) {
            if (i > 0 && suits[i - 1] != suits[i]) flush = false;
            cnt = max(cnt, ++hash[ranks[i]]);
        }
        if(flush) return "Flush";
        else if(cnt>= 3) return "Three of a Kind";
        else if(cnt >= 2) return "Pair";
        return "High Card";
    }
};