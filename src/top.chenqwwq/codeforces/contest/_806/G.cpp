//
// Created by 沽酒 on 2022/7/13.
//

#include "iostream"

using namespace std;

int main() {
    typedef long long ll;
    const int N = 1e5 + 9;
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int t, n, k;
    int nums[N];
    ll dp[N];
    cin >> t;
    while (t--) {
        cin >> n >> k;
        for (int i = 0; i < n; i++) {
            cin >> nums[i];
            dp[i] = 0;
        }
        dp[n - 1] = max(nums[n - 1] - k, nums[n - 1] >> 1);
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = max((dp[i + 1] >> 1) + (nums[i] >> 1), dp[i + 1] + nums[i] - k);
        }
        cout << dp[0] << endl;
    }
    return 0;
}
// 5 74 89 45 18 69 67 67 11 96 23 59
