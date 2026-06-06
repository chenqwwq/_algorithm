//
// Created by chenqwwq on 2024/5/12.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int findPermutationDifference(string s, string t) {
        int h1[26], h2[26];
        memset(h1, 0, sizeof(h1));
        memset(h2, 0, sizeof(h2));
        int cur = 0;
        for (auto c: s) h1[c - 'a'] = cur++;
        cur = 0;
        for (auto c: t) h2[c - 'a'] = cur++;
        int ans = 0;
        for (int i = 0; i < 26; i++)ans += abs(h1[i] - h2[i]);
        return ans;
    }
};

int main(int argc, char *argv[]) {
    auto pSolution = new Solution;
    pSolution->findPermutationDifference("abc", "bac");
}