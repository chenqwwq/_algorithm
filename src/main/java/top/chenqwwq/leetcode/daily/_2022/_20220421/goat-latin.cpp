//
// Created by 陈炳鑫 on 2022/4/21.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    string toGoatLatin(string sentence) {
        stringstream ss(sentence);
        string ans, word;
        for (int i = 1; i < INT_MAX; ++i) {
            ss >> word;
            if (word.empty()) break;
            bool flag = false;
            for (char c: {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}) {
                if (word[0] == c) {
                    flag = true;
                    word += "ma";
                    break;
                }
            }
            if (!flag) word = word.substr(1, word.length() - 1) + word.substr(0, 1) + "ma";
            for (int j = 0; j < i; ++j) word += 'a';
            if (i == 1)ans += word;
            else ans += " " + word;
            word.clear();
        }
        return ans;
    }
};