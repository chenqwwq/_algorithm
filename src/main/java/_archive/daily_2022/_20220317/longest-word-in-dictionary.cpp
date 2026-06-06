//
// Created by 陈炳鑫 on 2022/3/17.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    string longestWord(vector<string>& words) {
        sort(words.begin(), words.end(), [](const string & a, const string & b) {
            if (a.size() != b.size()) {
                return a.size() < b.size();
            } else {
                return a > b;
            }
        });
        string longest = "";
        unordered_set<string> cnt;
        cnt.emplace("");
        for (auto & word : words) {
            if (cnt.count(word.substr(0, word.size() - 1))) {
                cnt.emplace(word);
                longest = word;
            }
        }
        return longest;
    }
};