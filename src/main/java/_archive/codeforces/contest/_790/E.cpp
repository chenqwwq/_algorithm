//
// Created by 陈炳鑫 on 2022/5/10.
//


#include <iostream>
#include <algorithm>

using namespace std;

const int mann = 1.5e5;
long long nums[mann];

int main() {
    int n, m, q, qa;
    cin >> n;
    while (n--) {
        cin >> m >> q;
        for (int i = 0; i < m; ++i) {
            cin >> nums[i];
        }
        sort(nums, nums + m, greater<>{});
        for (int i = 1; i < m; ++i) nums[i] += nums[i - 1];

        while (q--) {
            cin >> qa;
            auto p = lower_bound(nums, nums + m, qa) - nums;
            if (p == m) {
                printf("%d\n", -1);
            } else {
                printf("%ld\n", p + 1);
            }
        }
    }

    return 0;
}