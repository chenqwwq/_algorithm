//
// Created by 陈炳鑫 on 2022/2/27.
//


#include "stdc++.h"
#include "common.h"

using namespace std;


class Solution {
public:
    int minSteps(string s, string t) {
        vector<int> h1(26, 0), h2(26, 0);
        for (char c: s) h1[c - 'a']++;
        for (char c: t) h2[c - 'a']++;

        int ans = 0;
        for (int i = 0; i < 26; ++i) ans += abs(h1[i] - h2[i]);
        return ans;
    }
};

int main() {
    (new Solution)->minSteps("leetcode", "coats");
}