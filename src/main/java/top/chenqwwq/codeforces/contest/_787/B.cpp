//
// Created by 陈炳鑫 on 2022/5/6.
//


#include <iostream>

using namespace std;

int main() {
    int n;
    cin >> n;
    while (n--) {
        int m;
        cin >> m;
        int nums[m];
        for (int i = 0; i < m; ++i) cin >> nums[i];
        if (m == 1) {
            printf("0\n");
            continue;
        }

        int ans = 0, pre = nums[m - 1];
        for (int i = m - 2; i >= 0; --i) {
            if (pre == 0) {
                ans = -1;
                break;
            }
            while (pre <= nums[i]) {
                nums[i] /= 2;
                ans++;
            }
            pre = nums[i];
        }
        printf("%d\n", ans);
    }
    return 0;
}