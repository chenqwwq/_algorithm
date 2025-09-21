//
// Created by 陈炳鑫 on 2022/4/19.
//


#include <iostream>
#include <vector>
#include <functional>

using namespace std;

int main() {
    int n;
    scanf("%d", &n);
    int nums[n];
    for (int i = 0; i < n; ++i) scanf("%d", &nums[i]);
    vector<int> ans;
    function<bool(int l, int r, bool flag)> dfs;
    dfs = [&](int l, int r, bool flag) -> bool {
        if (l > r)return true;
        if (l == r) {
            ans.push_back(nums[l]);
            return true;
        }
        int mid = nums[l];
        int i = l;
        if (flag) {
            while (i + 1 <= r && nums[i + 1] <= mid) i++;
            if (!dfs(l + 1, i, flag)) return false;
            for (int j = i + 1; j <= r; ++j) if (nums[j] < mid) return false;
            if (!dfs(i + 1, r, flag)) return false;
        } else {
            while (i + 1 <= r && nums[i + 1] >= mid) i++;
            if (!dfs(l + 1, i, flag)) return false;
            for (int j = i + 1; j <= r; ++j) if (nums[j] > mid) return false;
            if (!dfs(i + 1, r, flag)) return false;
        }
        ans.push_back(mid);
        return true;
    };
    if (dfs(0, n - 1, true)) {
        printf("%s\n", "YES");
        printf("%d", ans[0]);
        for (int i = 1; i < n; ++i) {
            printf(" %d", ans[i]);
        }
        cout << endl;
    } else {
        ans.clear();
        if (dfs(0, n - 1, false)) {
            printf("%s\n", "YES");
            printf("%d", ans[0]);
            for (int i = 1; i < n; ++i) {
                printf(" %d", ans[i]);
            }
            cout << endl;
        } else printf("NO\n");
    }
    return 0;
}