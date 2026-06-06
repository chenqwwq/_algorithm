//
// Created by 陈炳鑫 on 2022/4/20.
//


#include <iostream>
#include <vector>
#include <deque>

using namespace std;

int main() {
    int n, m, k;
    scanf("%d %d %d", &n, &m, &k);
    vector<vector<bool>> path(n, vector<bool>(n, false));
    int a, b;
    for (int i = 0; i < m; ++i) {
        scanf("%d %d", &a, &b);
        path[--a][--b] = true;
        path[b][a] = true;
    }

    deque<int> dq;
    for (int i = 0; i < k; ++i) {
        scanf("%d", &a);
        vector<bool> vis(n,false);
        vis[a - 1] = true;
        int ans = 0;
        for (int j = 0; j < n; ++j) {
            if (vis[j]) continue;
            ans++;
            dq.push_back(j);
            vis[j] = true;
            while (!dq.empty()) {
                auto cur = dq.front();
                dq.pop_front();
                for (int l = 0; l < n; ++l) {
                    if (vis[l] || !path[cur][l]) continue;
                    dq.push_back(l);
                    vis[l] = true;
                }
            }
        }
        printf("%d\n", ans - 1);
    }
    return 0;
}