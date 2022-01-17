//
// Created by chenqwwq on 2022/1/9.
//

#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:

    int longestPalindrome(vector<string> &words) {
        unordered_map<string, int> hash;
        for (string word: words) {
            hash[word]++;
        }

        int ans = 0;
        bool mid = false;
        for (auto&[k, v]: hash) {
            if (k[1] != k[0]) {
                string target = string(1, k[1])+ k[0];
                ans += 2 * min(hash[k], hash[target]);
                cout << "ans addition：" << k << 2 * min(hash[k], hash[target]) << endl;
            } else {
                if ((v & 1) == 1) {
                    mid = true;
                }
                cout << "ans addition：" << k << 4 * (v >> 1) << endl;
                ans += 4 * (v >> 1);
            }
        }
        printf("ans：%d", ans);
        return ans + (mid ? 2 : 0);
    }
};

int main() {
    Solution *pSolution = new Solution;
    vector<string> words = vector<string>{"oo", "vv", "uu", "gg", "pp", "ff", "ss", "yy", "vv", "cc", "rr", "ig",
                                          "jj", "uu", "ig", "gb", "zz", "xx", "ff", "bb", "ii", "dd", "ii", "ee",
                                          "mm", "qq", "ig", "ww", "ss", "tt", "vv", "oo", "ww", "ss", "bi", "ff",
                                          "gg", "bi", "jj", "ee", "gb", "qq", "bg", "nn", "vv", "oo", "bb", "pp",
                                          "ww", "qq", "mm", "ee", "tt", "hh", "ss", "tt", "ee", "gi", "ig", "uu",
                                          "ff", "zz", "ii", "ff", "ss", "gi", "yy", "gb", "mm", "pp", "uu", "kk",
                                          "jj", "ee"};
    pSolution->longestPalindrome(words);
}