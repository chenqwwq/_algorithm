//
// Created by 陈炳鑫 on 2022/4/22.
//


#include <iostream>

using namespace std;

int main() {
    int n, m;
    cin >> n;
    while (n--) {
        cin >> m;
        int nums[m];
        for (int i = 0; i < m; ++i) scanf("%d", &nums[i]);
        int i = 2;
        for (; i < m; ++i) {
            if ((nums[i] & 1) ^ (nums[i - 2] & 1)) {
                printf("NO\n");
                break;
            }
        }
        if (i == m) printf("YES\n");
    }
    return 0;
}