//
// Created by chenqwwq on 2022/1/19.
//

#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
private:
    vector<Solution *> next = vector<Solution *>(26);

    void insert(string word) {
        Solution *node = this;
        auto n = word.length();
        for (int i = n - 1; i >= 0; i--) {
            auto pos = word[i] - 'a';
            if (!node->next[pos]) {
                node->next[pos] = new Solution;
            }
            node = node->next[pos];
        }
    }

    bool find(string word) {
        Solution *node = this;
        auto n = word.length();
        for (int i = n - 1; i >= 0; i--) {
            auto pos = word[i] - 'a';
            if (!node->next[pos]) {
                return false;
            }
            node = node->next[pos];
        }
        return true;
    }

public:
    int minimumLengthEncoding(vector<string> &words) {
        auto n = words.size();
        if (n == 1) {
            return (int) words[0].length() + 1;
        }

        sort(words.begin(), words.end(), [&](string a, string b) -> bool {
            return a.length() > b.length();
        });

        int ans = 0;
        for (auto &word: words) {
            if (find(word)) {
                continue;
            }
            ans += word.length() + 1;
            insert(word);
        }
        return ans;
    }
};

int main() {
    vector<string> p1{"time", "me", "bell"};
    (new Solution)->minimumLengthEncoding(p1);
}
