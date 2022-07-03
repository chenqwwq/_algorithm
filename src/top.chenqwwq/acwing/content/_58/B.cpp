//
// Created by chenqwwq on 2022/7/2.
//


#include "iostream"

using namespace std;
typedef long long ll;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n;
    cin >> n;
    ll nums[n];
    int dp[n],ans = 0;
    for (int i = 0; i < n; i++) {
        cin >> nums[i];
        dp[i] = 1;
        for (int j = i - 1; j >= 0; --j) {
            if (nums[i] <= nums[j] * 2) {
                dp[i] = max(dp[i], dp[j] + 1);
                break;
            }
        }
        ans = max(ans,dp[i]);
    }
    // 10
    //1 2 5 6 7 10 21 23 24 49
    cout << ans << endl;
    return 0;
}