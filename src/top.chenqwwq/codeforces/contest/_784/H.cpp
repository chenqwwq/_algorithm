//
// Created by 陈炳鑫 on 2022/4/23.
//


#include <iostream>
#include <vector>

using namespace std;

int main() {
    int n;
    cin >> n;
    while (n--) {
        int m, k;
        cin >> m >> k;
        int num;
        vector<int> bit(31, 0);
        for (int j = 0; j < m; ++j) {
            cin >> num;
            for (int i = 0; i <= 30; ++i) {
                bit[i] += num >> i & 1;
            }
        }
        int ans = 0;
        for (int i = 30; i >= 0; --i) {
            if (bit[i] >= m) ans |= (1 << i);
            else if (k >= m - bit[i]) {
                ans |= (1 << i);
                k -= (m - bit[i]);
            }
        }
        printf("%d\n", ans);
    }
    return 0;
}