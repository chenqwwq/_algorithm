//
// Created by 陈炳鑫 on 2022/4/10.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int largestInteger(int num) {
        if (num < 10) return num;
        vector<int> odd, even;
        int tmp = num;
        while (tmp) {
            int cur = tmp % 10;
            tmp /= 10;
            if (cur & 1) odd.push_back(cur);
            else even.push_back(cur);
        }
        sort(odd.begin(), odd.end(), less<>());
        sort(even.begin(), even.end(), less<>());
        int i = 0, j = 0;
        int ans = 0;
        long long base = 1;
        while (num) {
            int cur = num % 10;
            num /= 10;
            if (cur & 1) {
                ans += (int)(base * odd[i++]);
            } else {
                ans += (int)(base * even[j++]);
            }
            base *= 10;
        }
        return ans;
    }
};