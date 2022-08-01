//
// Created by 陈炳鑫 on 2022/3/22.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    bool winnerOfGame(string colors) {
        auto n = colors.size();
        int ac = 0, bc = 0;
        int a = 0, b = 0;
        for (int i = 0; i < n; ++i) {
            if (colors[i] == 'A') {
                if (b >= 3) bc += (b - 2);
                b = 0;
                a++;
            } else {
                if (a >= 3) ac += (a - 2);
                a = 0;
                b++;
            }
        }
        if (a >= 3) ac += (a - 2);
        if (b >= 3) bc += (b - 2);
        return ac > bc;
    }
};