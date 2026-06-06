//
// Created by chenqwwq on 2024/6/17.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int countCompleteDayPairs(vector<int> &hours) {
        int cnt = 0;
        for (int i = 0;i < hours.size();i++){
            for(int j = i+1;j < hours.size();j++){
                if ((hours[i] + hours[j]) % 24 == 0)cnt++;
            }
        }
        return cnt;
    }
};