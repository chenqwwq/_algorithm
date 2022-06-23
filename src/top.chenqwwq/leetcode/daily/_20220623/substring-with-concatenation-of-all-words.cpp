

//
// Created by 沽酒 on 2022/6/23.
//

#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    vector<int> findSubstring(string s, vector<string> &words) {
        // the same length
        int n = (int) words.size(), m = (int) words[0].length(), k = (int) s.length();
        int l = n * m;
        if (k < l) return {};
        map<string, int> source,target;
        for (string &word: words) source[word]++;
        vector<int> ans;
        for (int i = 0; i <= k - l; ++i) {
            target.clear();
            bool ok = true;
            for (int j = i; j < i + l; j += m) {
                auto word = s.substr(j, m);
                if (++target[word] > source[word]) {
                    ok = false;
                    break;
                }
            }
            if (!ok) continue;
            for (auto [k, v]: target) {
                if (source[k] != v) {
                    ok = false;
                    break;
                }
            }
            if (ok) ans.push_back(i);
        }
        return ans;
    }
};