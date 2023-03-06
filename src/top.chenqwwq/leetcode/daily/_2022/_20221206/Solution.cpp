//
// Created by chenqwwq on 2022/12/6.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int numDifferentIntegers(string word) {
        unordered_set < string > uset;
        int n = (int) word.length();
        string s;
        for (int i = 0; i < n; i++) {
            if (word[i] >= 'a' && word[i] <= 'z') {
                if (!s.empty()) {
                    while (s[0] == '0')s = s.substr(1);
                    uset.insert(s);
                }
                s.clear();
            } else s += word[i];
        }
        if (!s.empty()) {
            while (s[0] == '0')s = s.substr(1);
            uset.insert(s);
        }
        return (int) uset.size();
    }
};

int main(){
    (new Solution)->numDifferentIntegers("a1b01c001");
}