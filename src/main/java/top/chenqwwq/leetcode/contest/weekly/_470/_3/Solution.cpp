//
// Created by chenqwwq on 2025/10/8.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    string removeSubstring(string s, int k) {
        vector<pair<char, int> > st; // 栈中保存 pair{字符, 连续出现次数}
        for (char b: s) {
            if (!st.empty() && st.back().first == b) {
                st.back().second++; // 连续相同括号个数 +1
            } else {
                st.emplace_back(b, 1); // 新的括号
            }

            // 栈顶的 k 个右括号与栈顶下面的 k 个左括号抵消
            if (b == ')' && st.size() > 1 && st.back().second == k && st[st.size() - 2].second >= k) {
                st.pop_back();
                st.back().second -= k;
                if (st.back().second == 0) {
                    st.pop_back();
                }
            }
        }

        string ans;
        for (auto &p: st) {
            ans += string(p.second, p.first);
        }
        return ans;
    }
};