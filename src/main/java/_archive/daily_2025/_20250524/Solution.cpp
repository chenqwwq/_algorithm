//
// Created by chenqwwq on 2025/5/24.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    vector<int> findWordsContaining(vector<string> &words, char x) {
        vector<int> ans;

        for (int i = 0; i < words.size(); i++) {
            auto word = words[i];
            auto s = word.find(x);
            if (s != -1)ans.emplace_back(i);
        }
        return ans;
    }
};