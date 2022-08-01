//
// Created by 陈炳鑫 on 2022/2/27.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int prefixCount(vector<string>& words, string pref) {
        int ans = 0;
        int n = pref.size();
        for (string word : words){
            int i = 0;
            while (i < n){
                if(word[i] != pref[i]) break;
                i++;
            }
            if(i == n) ans++;
        }
        return ans;
    }
};