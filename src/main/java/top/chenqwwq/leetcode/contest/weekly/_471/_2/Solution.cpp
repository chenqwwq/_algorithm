//
// Created by chenqwwq on 2025/10/12.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int longestBalanced(string s) {
        const int n = s.length();

        vector<vector<int> > hash(n, vector<int>(26, 0));

        for (int i = 0; i < n; i++) {
            if (i > 0) {
                for (int j = 0; j < 26; j++) {
                    hash[i][j] = hash[i - 1][j];
                }
            }
            const int idx = s[i] - 'a';
            hash[i][idx]++;
        }

        int ans = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int cnt = -1;
                bool ok = true;
                for (int k = 0; k < 26; k++) {
                    if (hash[i][k] - (j > 0 ? hash[j - 1][k] : 0) == 0) continue;
                    if (cnt == -1) cnt = hash[i][k] - (j > 0 ? hash[j - 1][k] : 0);
                    else if (cnt != hash[i][k] - (j > 0 ? hash[j - 1][k] : 0)) {
                        ok = false;
                        break;
                    }
                }
                if (ok) ans = max(ans, i - j + 1);
            }
        }
        return ans;
    }
};