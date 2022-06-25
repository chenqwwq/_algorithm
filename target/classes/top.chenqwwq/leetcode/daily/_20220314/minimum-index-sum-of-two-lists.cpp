//
// Created by 陈炳鑫 on 2022/3/14.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    vector<string> findRestaurant(vector<string> &list1, vector<string> &list2) {
        unordered_map<string, int> hash;
        auto n = list1.size(), m = list2.size();
        for (int i = 0; i < n; ++i) hash[list1[i]] = i;

        vector<string> ans;
        int min = INT_MAX;
        for (int i = 0; i < m; ++i) {
            if (hash.find(list2[i]) == hash.end()) continue;
            int t = i + hash[list2[i]];
            if(t == min){
                ans.push_back(list2[i]);
            }else if(t < min){
                min = t;
                ans.clear();
                ans.push_back(list2[i]);
            }
        }
        return ans;
    }
};