//
// Created by 陈炳鑫 on 2022/4/5.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
private:
    unordered_set<int> s{2, 3, 5, 7, 11, 13, 17, 19, 23, 31};
public:
    int countPrimeSetBits(int left, int right) {
        int ans = 0;
        while (left <= right) {
            int cnt = 0, tmp = left;
            while (left) {
                left &= (left - 1);
                cnt++;
            }
            if(s.count(cnt)) ans++;
        }
        return ans;
    }
};