//
// Created by 陈炳鑫 on 2022/3/29.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int maxConsecutiveAnswers(string s, int k) {
        return max(find(s, k, 'T'), find(s, k, 'F'));
    }

    int find(string s, int k, char c) {
        int n = s.length();
        int l = 0, r = 0;
        int ans = 0, cnt = 0;
        while (r < n) {
            if (s[r++] == c) cnt++;
            if (cnt > k) {
                while (s[l++] != c) {}
                cnt--;
            }
            if (cnt <= k)ans = max(ans, r - l);
        }
        return ans;
    }
};

int main() {
    (new Solution)->maxConsecutiveAnswers("TTFTTFTT", 1);
}