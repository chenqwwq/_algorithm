//
// Created by chenqwwq on 2023/4/11.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int move[4][2]{{0,  1},
                   {1,  0},
                   {0,  -1},
                   {-1, 0}};

    bool isRobotBounded(string instructions) {
        int a = 0, b = 0;
        int direct = 0;
        for (char c: instructions) {
            if (c == 'G') {
                a += move[direct][0];
                b += move[direct][1];
            } else if (c == 'L') {
                direct = (direct + 3) % 4;
            } else {
                direct = (direct + 1) % 4;
            }
        }

        return (a == 0 && b == 0) || direct != 0;
    }
};