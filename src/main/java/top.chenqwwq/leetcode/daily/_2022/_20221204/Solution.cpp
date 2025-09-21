//
// Created by chenqwwq on 2022/12/4.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int inf = 0x3f3f3f3f;

    int closestCost(vector<int> &baseCosts, vector<int> &toppingCosts, int target) {
        int x = *min_element(baseCosts.begin(), baseCosts.end());
        if (x >= target) return x;

        // 按照需要的价格枚举 而不是枚举各种状态
        bool dp[target + 1];
        for (bool &b: dp) b = false;
        int ans = inf;

        // 按照基料初始化状态
        for (int cost: baseCosts) {
            if (cost <= target) dp[cost] = true;
            else ans = min(ans, cost);
        }

        // 选择某种配料进行转移
        for (int topping: toppingCosts) {
            // 枚举1份还是2份
            for (int i = 0; i < 2; i++) {
                // 枚举最终价格
                for (int t = target; t > 0; t--) {
                    // 添加之后价格大于 target
                    if (dp[t] && t + topping > target) ans = min(ans, t + topping);
                    if (t > topping) dp[t] |= dp[t - topping];
                }
            }
        }

        for (int i = target; i >= max(0, target * 2 - ans); i--) {
            if (dp[i]) return i;
        }
        return ans;
    }
};

int main() {
    vector<int> p1{3,10},p2{2,5};
    (new Solution)->closestCost(p1, p2, 9);
}