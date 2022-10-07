//
// Created by chenqwwq on 2022/5/29.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int mmax = 0;
    string ans;

    string largestWordCount(vector<string> &messages, vector<string> &senders) {
        int n = (int) messages.size();
        map<string, int> cnt;
        for (int i = 0; i < n; ++i) {
            int t = 0;
            for (char c: messages[i]) {
                if (c == ' ') t++;
            }
            cnt[senders[i]] += t + 1;
            if (cnt[senders[i]] > mmax) {
                ans = senders[i];
                mmax = cnt[senders[i]];
            } else if (cnt[senders[i]] == mmax && senders[i] > ans) {
                ans = senders[i];
            }
        }
        return ans;
    }
};