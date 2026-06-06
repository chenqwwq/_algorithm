//
// Created by chenqwwq on 2022/12/8.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    bool squareIsWhite(string coordinates) {
        return ((coordinates[0] - 'a' + 1) ^ (coordinates[1] - '0') & 0x00000001);
    }
};