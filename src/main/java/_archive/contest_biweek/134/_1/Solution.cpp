//
// Created by chenqwwq on 2024/7/13.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int numberOfAlternatingGroups(vector<int> &colors) {
        int ans = 0;
        for (int i = 1; i < colors.size() - 1; i++) {
            if (colors[i - 1] != colors[i] && colors[i] != colors[i + 1]) {
                ans++;
            }
        }
        if (colors[0] != colors[colors.size() - 1] && colors[0] != colors[1]) ans++;
        if (colors[colors.size() - 1] != colors[colors.size() - 2] && colors[colors.size() - 1] != colors[0]) ans++;
        return ans;
    }
};