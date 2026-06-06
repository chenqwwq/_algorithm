//
// Created by chenqwwq on 2023/3/27.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int countSubstrings(string s, string t) {
        int n = (int) s.length(), m = (int) t.length();
        int ans = 0;
        for (int i = 0; i < n; i++) { // s 的末尾下标
            for (int j = 0; j < m; j++) { // t 的末尾下标
                int cnt = 0;
                for (int k = 0; i >= k && j >= k; k++) {
                    if (s[i - k] != t[j - k]) cnt++;
                    if (cnt > 1) break;
                    else if (cnt == 1) ans++;
                }
            }
        }
        return ans;
    }

    int countSubstrings1(string s, string t) {
        int n = (int) s.length(), m = (int) t.length();
        vector<vector<int>> dpl(n + 1, vector<int>(m + 1, 0));
        vector<vector<int>> dpr(n + 1, vector<int>(m + 1, 0));
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                dpr[i][j] = dpr[i + 1][j + 1] + (s[i] == t[j] ? 0 : 1);
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {

            }
        }
    }
};