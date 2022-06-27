//
// Created by 陈炳鑫 on 2022/5/11.
//


#include <iostream>

using namespace std;

const int maxn = 1007;
int nums[maxn], ans;
#define init() ans= 0;

int main() {
    int t, n;
    cin >> t;
    while (t--) {
        cin >> n;
        init();
        for (int i = 0; i < n; ++i) cin >> nums[i];
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] >= nums[j]) ans++;
            }
        }
        printf("%d\n", ans);
    }
    return 0;
}