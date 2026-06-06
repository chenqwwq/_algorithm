//
// Created by chenqwwq on 2022/12/28.
//


#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int minimumLength(string s) {
        int n = (int) s.size();
        // 1. 前后缀只能包含同一个字符
        // 2. 前后缀长度可以不同
        int l = 0, r = n - 1;
        while (l < r) {
            char c = s[l];
            if (s[r] != c) break;
            while (++l < r && s[l] == c) {}
            while (l < --r && s[r] == c) {}
        }
        return r - l + 1;
    }
};