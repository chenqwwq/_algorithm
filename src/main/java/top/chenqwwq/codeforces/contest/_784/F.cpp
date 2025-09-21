//
// Created by 陈炳鑫 on 2022/4/22.
//


#include <iostream>
#include <vector>

using namespace std;

int main() {
    int n;
    cin >> n;
    while (n--) {
        int m;
        cin >> m;
        int nums[m];
        for (int i = 0; i < m; ++i) cin >> nums[i];
        vector<int> pre(m);
        int l = -1, r = m, sl = 0, sr = 0;
        int ans = 0;
        while (l < r) {
            if (sl == sr) ans = max(ans, l + 1 + m - r);
            if (sl <= sr) sl += nums[++l];
            else sr += nums[--r];
        }
        printf("%d\n", ans);
    }
    return 0;
}