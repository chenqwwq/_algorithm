//
// Created by 陈炳鑫 on 2022/2/28.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int maximumRequests(int n, vector<vector<int>> &requests) {
        int m = requests.size(), ans = -0x3F3F3F3F;
        int mmax = 1 << m;
        for (int i = 0; i < mmax; ++i) {
            int curr = getCnt(i);
            if (curr < ans) continue;
            // check
            if(check(n,requests,i)) ans = max(ans,curr);
        }
        return ans;
    }

    bool check(int n, vector<vector<int>> &requests, int mask) {
        vector<int> states(n, 0);
        for (int i = 0; i < requests.size(); ++i) {
            if (!(mask & (1 << i))) continue;
            states[requests[i][0]]--;
            states[requests[i][1]]++;
        }
        return all_of(states.begin(),states.end(),[](int n)-> bool {return n == 0;});
    }

    int getCnt(int num) {
        int cnt = 0;
        while (num) {
            cnt++;
            num &= (num - 1);
        }
        return cnt;
    }
};