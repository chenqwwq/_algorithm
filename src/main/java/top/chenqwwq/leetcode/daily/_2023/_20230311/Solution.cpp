//
// Created by chenqwwq on 2023/3/11.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    vector<string> findLongestSubarray(vector<string> &array) {
        int n = (int) array.size();
        int sum = 0;
        map<int, int> mm;
        mm[0] = -1;
        int m = 0, l = -1;
        for (int i = 0; i < n; i++) {
            if ((array[i][0] >= 'A' && array[i][0] <= 'Z') || (array[i][0] >= 'a' && array[i][0] <= 'z')) sum += -1;
            else sum += 1;
            if (mm.find(sum) != mm.end()) {
                if (i - mm[sum] > m) {
                    l = mm[sum] + 1;
                    m = i - mm[sum];
                }
            } else {
                mm[sum] = i;
            }
        }

        vector<string> ans;
        for (int i = 0; i < m; i++) {
            ans.push_back(array[l + i]);
        }
        return ans;
    }
};