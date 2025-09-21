//
// Created by chenqwwq on 2022/6/12.
//

#include "iostream"

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;
    int nums[n + m], g[n + m], gg[m];
    for (int i = 0; i < n + m; ++i) cin >> nums[i];
    for (int i = 0, j = 0; i < n + m; ++i) {
        cin >> g[i];
        if (g[i]) gg[j++] = nums[i];
    }

    int ans[m];
    for (int i = 0; i < m; i++) ans[i] = 0;

    for (int i = 0, t = 0; i < n + m; ++i) {
        if (g[i]) {
            t++;
            continue;
        }
        if (t - 1 < 0) {
            ans[t]++;
        } else if (t >= m) {
            ans[t - 1]++;
        } else if (nums[i] - gg[t - 1] <= gg[t] - nums[i]) {
            ans[t - 1]++;
        } else {
            ans[t]++;
        }
    }

    cout << ans[0];
    for (int i = 1; i < m; i++) {
        cout << " " << ans[i];
    }
    cout << endl;

    return 0;
}