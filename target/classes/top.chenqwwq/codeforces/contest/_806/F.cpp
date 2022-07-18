//
// Created by 沽酒 on 2022/7/13.
//

#include "iostream"

using namespace std;

int main() {
    const int N = 2e5 + 5;
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int t, n, nums[N], sums[N];
    cin >> t;
    while (t--) {
        cin >> n;
        for (int i = 1; i <= n; i++) {
            cin >> nums[i];
            sums[i] += sums[i - 1] + (nums[i] < i);
        }
        long long ans = 0;
        for (int i = n; i > 0; --i) {
            if (nums[i] < i) {
                ans += sums[nums[i] - 1];
            }
        }
        cout << ans << endl;
    }
}
