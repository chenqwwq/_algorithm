//
// Created by 陈炳鑫 on 2022/3/19.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    string removeDuplicateLetters(string s) {
        int n = s.length();
        unordered_map<char, int> hash;
        vector<bool> exist(26, false);

        for (int i = 0; i < n; ++i) {
            if (!hash.count(s[i])) hash[s[i]] = 0;
            hash[s[i]]++;
        }
        vector<int> vec;
        for (int i = 0; i < n; ++i) {
            if (exist[s[i] - 'a']) {
                hash[s[i]]--;
                continue;
            }
            if (vec.empty()) {
                vec.push_back(i);
                exist[s[i] - 'a'] = true;
                continue;
            }
            while (!vec.empty() && s[i] < s[vec.back()] && hash[s[vec.back()]] > 1) {
                exist[s[vec.back()] - 'a'] = false;
                hash[s[vec.back()]]--;
                vec.pop_back();
            }
            vec.push_back(i);
            exist[s[i] - 'a'] = true;
        }

        string ans;
        for (int pos: vec) ans += s[pos];
        return ans;
    }
};