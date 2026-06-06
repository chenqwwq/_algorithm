//
// Created by chenqwwq on 2022/12/23.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int finalValueAfterOperations(vector<string>& operations) {
        int ans = 0;
        for(string word : operations){
            if(word[1] == '-') ans--;
            else ans++;
        }
        return ans;
    }
};