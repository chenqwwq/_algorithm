//
// Created by chenqwwq on 2022/7/9.
//


#include "iostream"
#include "unordered_map"
#include "vector"
#include "functional"

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    unordered_map<int, vector<int>> mmap;
    int n, m, x, y;
    cin >> n >> m;
    while (m--) {
        cin >> x >> y;
        x--;
        y--;
        mmap[x].push_back(y);
        mmap[y].push_back(x);
    }

    vector<bool> vis(n, false);
    function<bool(int, int, int)> dfs;
    dfs = [&](int cur, int pre, int start) -> bool {
        if (vis[cur])return false;
        vis[cur] = true;
        if (mmap[cur].size() != 2) return false;
        int next = mmap[cur][0] == pre ? mmap[cur][1] : mmap[cur][0];
        return next == start || dfs(next, cur, start);
    };
    int ans = 0;
    for (int i = 0; i < n; i++) {
        if (vis[i]) continue;
        if (dfs(i, i, i)) ans++;
    }
    cout << ans << endl;
    return 0;
}