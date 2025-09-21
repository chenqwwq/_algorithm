//
// Created by 陈炳鑫 on 2022/4/11.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int ans = 1, base = 10, cnt = 0, pre = 1;
        // 计算概率,首位1～9,后续0~9（去除首位选择的），后续每次少一位
        while (cnt++ < n) {
            int tmp = min(base--, 9) * pre;
            ans += tmp;
            pre = tmp;
        }
        return ans;
    }
};

int main() {
    (new Solution)->countNumbersWithUniqueDigits(2);
}