//
// Created by 陈炳鑫 on 2022/2/21.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    string pushDominoes(string dominoes) {
        vector<string> roll(2, dominoes);
        int n = dominoes.size();
        bool end = true;
        while (end) {
            bool hc = false;
            for (int i = 0; i < n; ++i) {
                if (roll[0][i] != '.') continue;
                bool pr = i - 1 >= 0 && roll[0][i - 1] == 'R', pl = i + 1 < n && roll[0][i + 1] == 'L';
                if (pl && pr) continue;
                else if (pl) roll[1][i] = 'L', hc = true;
                else if (pr) roll[1][i] = 'R', hc = true;
            }
            if (!hc) end = false;
            roll[0] = roll[1];
        }
        return roll[0];
    }
};