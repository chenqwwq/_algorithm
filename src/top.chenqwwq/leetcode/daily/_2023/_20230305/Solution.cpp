//
// Created by chenqwwq on 2023/3/5.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int minOperationsMaxProfit(vector<int> &customers, int boardingCost, int runningCost) {
        if (boardingCost << 2 < runningCost) return -1;
        int n = (int) customers.size();
        int ans = 0, maxProfit = 0;
        int curProfit = 0;
        // 表示当当前预备的客户数
        // 表示第几次轮转
        int cs = 0, i = 0;
        while (i < n || cs) {
            if (i < n) cs += customers[i];
            int cnt = min(4, cs);
            cs -= cnt;
            curProfit += cnt * boardingCost - runningCost;
            if (curProfit > maxProfit) {
                maxProfit = curProfit;
                ans = i;
            }
            i++;
        }
        return ans == 0 ? -1 : ans + 1;
    }
};

int main() {
    vector<int> nums{2};
    (new Solution)->minOperationsMaxProfit(nums, 2, 4);
}