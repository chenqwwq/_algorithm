//
// Created by chenqwwq on 2022/5/31.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int n;
    map<char, set<char>> mmap;
    int in[26];
    bool exist[26];

    bool sort(const string &a, const string &b) {
        int q = (int) a.length(), w = (int) b.length();
        bool first = true;
        for (int i = 0; i < max(q, w); ++i) {
            if (i < q) exist[a[i] - 'a'] = true;
            if (i < w) exist[b[i] - 'a'] = true;
            if (first && i < q && i < w && a[i] != b[i]) {
                first = false;
                if (mmap.find(a[i]) == mmap.end()) mmap[a[i]] = {};
                if (mmap[b[i]].count(a[i])) return false;
                exist[b[i] - 'a'] = true;
                if (mmap[a[i]].insert(b[i]).second) {
                    in[b[i] - 'a']++;
                }
            }
        }
        return !first || q <= w;
    }

    void init() {
        for (int &num: in) num = 0;
        for (bool &b: exist) b = false;
    }

    string alienOrder(vector<string> &words) {
        if (words.empty()) return "";
        if (words.size() == 1)return words[0];
        init();
        n = (int) words.size();
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (!sort(words[i], words[j])) return "";
            }
        }

        char stack[26];
        int pos = 0;
        for (int i = 0; i < 26; ++i) {
            if (exist[i] && !in[i]) {
                stack[pos++] = (char) ('a' + i);
                exist[i] = false;
            }
        }

        string ans;
        while (pos) {
            char c = stack[--pos];
            ans += c;
            for (auto val: mmap[c]) {
                int cc = val - 'a';
                if (exist[cc] && --in[cc] <= 0) {
                    exist[cc] = false;
                    stack[pos++] = val;
                }
            }
        }
        return ans;
    }
};