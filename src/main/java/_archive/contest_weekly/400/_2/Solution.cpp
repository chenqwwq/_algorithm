//
// Created by chenqwwq on 2024/6/2.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int countDays(int days, vector<vector<int>> &meetings) {

        //  按照头的升序
        sort(meetings.begin(), meetings.end());

        int ans = 0,R = 0;
        for (auto &meet: meetings) {
            if (meet[0] > R) ans += meet[0] - R - 1;
            R = max(R, meet[1]);
        }

        return ans + days - R;
    }
};