//
// Created by chenqwwq on 2022/6/14.
//

#include "iostream"

using namespace std;

int main() {
    int maxn = 2e5 + 10;
    int nums[maxn], pc[maxn], sc[maxn];
    pc[0] = 0;
    sc[0] = 0;
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int t, n, s;
    cin >> t;
    while (t--) {
        cin >> n >> s;
        int sum = 0;  // total sum
        for (int i = 0; i < n; ++i) {
            cin >> nums[i];
            sum += nums[i];
        }
        if (sum < s) {
            cout << "_1" << endl;
            continue;
        }
        if (sum == s) {
            cout << "0" << endl;
            continue;
        }

        for (int i = 0, a = 0; i < n; ++i) {
            // 左边消除a个1需要多少步
            if (nums[i]) pc[++a] = i + 1;
        }
        for (int i = n - 1, b = 0; i >= 0; --i) {
            // 右边消除b个1需要多少步
            if (nums[i]) sc[++b] = n - i;
        }
        int ans = 0x3f3f3f3f, target = sum - s;
        // 左右两边各占多少
        for (int i = 0; i <= target; ++i) {
            ans = min(ans, pc[i] + sc[target - i]);
        }
        cout << ans << endl;
    }
    return 0;
}