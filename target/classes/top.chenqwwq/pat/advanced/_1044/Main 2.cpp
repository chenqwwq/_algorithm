//
// Created by 陈炳鑫 on 2022/4/19.
//


#include <iostream>
#include <vector>

using namespace std;

int main() {
    int n, m;
    cin >> n >> m;
    int nums[n];
    for (int i = 0; i < n; ++i) cin >> nums[i];
    int l = 0, r = 0, cur = 0;
    int mmin = 0x3f3f3f3f;
    vector<pair<int, int>> ans;
    while ((r < n && cur < m) || (l < r && cur >= m)) {
        // 窗口扩展
        if (r < n && cur < m) {
            cur += nums[r++];
        }
        if (l < r && cur >= m) {
            if (cur - m < mmin) {
                mmin = cur - m;
                ans.clear();
                ans.emplace_back(l, r - 1);
            } else if (cur - m == mmin) {
                ans.emplace_back(l, r - 1);
            }
            cur -= nums[l++];
        }
    }
    for (int i = 0; i < ans.size(); i++) {
        printf("%d-%d", ans[i].first + 1, ans[i].second + 1);
        if (i != ans.size() - 1) cout << endl;
    }
    return 0;
}