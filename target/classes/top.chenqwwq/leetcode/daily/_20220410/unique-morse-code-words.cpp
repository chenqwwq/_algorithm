//
// Created by 陈炳鑫 on 2022/4/10.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
    string hash[26]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.",
                    "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
public:
    int uniqueMorseRepresentations(vector<string> &words) {
        unordered_set<string> ss;
        for (auto word: words) {
            string t;
            for (auto c: word) t += hash[c - 'a'];
            ss.insert(t);
        }
        return ss.size();
    }
};