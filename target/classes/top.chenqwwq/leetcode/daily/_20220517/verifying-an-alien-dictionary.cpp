//
// Created by chenqwwq on 2022/5/17.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:

    int h[26];

    bool check(string a, string b) {
        for (int i = 0; i < min(a.length(), b.length()); ++i) {
            if (h[a[i] - 'a'] > h[b[i] - 'a']) return false;
            else if (h[a[i] - 'a'] < h[b[i] - 'a']) return true;
        }
        return a.length() <= b.length();
    }

    bool isAlienSorted(vector<string> &words, string order) {
        for (int i = 0; i < 26; ++i) h[order[i] - 'a'] = i;
        for (int i = 0; i < words.size() - 1; ++i) {
            if (!check(words[i], words[i + 1])) {
                return false;
            }
        }
        return true;
    }
};