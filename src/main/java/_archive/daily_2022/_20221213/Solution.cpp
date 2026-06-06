//
// Created by chenqwwq on 2022/12/13.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    bool checkIfPangram(string sentence) {
        int exist[26];
        ::memset(exist,0, sizeof exist);
        int cnt = 0;
        for(char c : sentence){
            if(++exist[c-'a'] == 1) cnt++;
        }
        return cnt == 26;
    }
};