//
// Created by chenqwwq on 2023/4/14.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    vector<bool> camelMatch(vector<string> &queries, string pattern) {
        auto check = [](string q, string p) -> bool {
            int n = (int) q.length(), m = (int) p.length();
            int i = 0, j = 0;
            while (i < n && j < m) {
                if (q[i] == p[j]) {
                    i++;
                    j++;
                } else if (q[i] >= 'a' && q[i] <= 'z') {
                    i++;
                } else {
                    return false;
                }
            }
            if (j != m) return false;
            while (i < n) {
                if (q[i] >= 'A' && q[i] <= 'Z') return false;
                i++;
            }
            return true;
        };

        vector<bool> ans(queries.size(), false);
        for(int i = 0;i < queries.size();i++){
            ans[i] = check(queries[i],pattern);
        }
        return ans;
    }
};