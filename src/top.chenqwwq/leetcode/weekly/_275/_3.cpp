//
// Created by chenqwwq on 2022/1/10.
//

#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int wordCount(vector<string> &startWords, vector<string> &targetWords) {
        unordered_set<int> hash;
        for (string &word: startWords) {
            hash.insert(getMask(word));
        }

        int ans = 0;
        for (string &target: targetWords) {
            int mask = getMask(target);
            for (char ch: target) {
                if(hash.count(mask ^ (1 << (ch - 'a')))){
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }

    int getMask(const string &word) {
        int mask = 0;
        for (char c: word) {
            mask |= 1 << (c - 'a');
        }
        return mask;
    }
};