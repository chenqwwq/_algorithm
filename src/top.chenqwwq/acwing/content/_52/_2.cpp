//
// Created by chenqwwq on 2022/5/21.
//


#include <iostream>
#include <math.h>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n;
    cin >> n;
    int nums[n];
    for (int i = 0; i < n; ++i) cin >> nums[i];
    int l = -1, r = -1;
    for (int i = 0; i < n; ++i) {
        if (nums[i] == 0) {
            r = i;
            break;
        }
    }
    for (int i = 0; i < n; ++i) {
        int ans;
        if (l != -1 && r != -1) ans = min(abs(i - l), abs(i - r));
        else if (l == -1) ans = abs(i - r);
        else ans = abs(i - l);
        printf(i != n - 1 ? "%d " : "%d", ans);
        if (r != -1 && i >= r) {
            l = r;
            r = -1;
            for (int j = l + 1; j < n; ++j) {
                if (nums[j] == 0) {
                    r = j;
                    break;
                }
            }
        }
    }
    return 0;
}