//
// Created by chenqwwq on 2024/5/26.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    string compressedString(string word) {
        int n = word.length();
        string ans;
        char cur;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (cnt == 0) {
                cur = word[i];
                cnt++;
            } else if (word[i] != cur || (word[i] == cur && ++cnt == 9)) {
                ans += to_string(cnt) + cur;
                cnt = word[i] != cur ? 1 : 0;
                cur = word[i];
            }
        }
        return ans + (cnt > 0 ? to_string(cnt) + cur : "");
    }
};