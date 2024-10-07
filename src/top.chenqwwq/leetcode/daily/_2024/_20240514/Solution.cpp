//
// Created by chenqwwq on 2024/5/14.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int minimumRounds(vector<int>& tasks) {
        int ans = 0;
        map<int,int> mmap;
        for(auto task : tasks){
            mmap[task]++;
        }
        for(auto entry : mmap){
            if(entry.second < 2) return -1;
            int t = entry.second % 3;
            ans += t == 0 ? entry.second / 3 : entry.second / 3 + 1;
        }
        return ans;
    }
};