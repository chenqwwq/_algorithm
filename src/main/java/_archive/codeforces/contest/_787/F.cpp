//
// Created by 陈炳鑫 on 2022/5/6.
//


#include <iostream>
#include <vector>

using namespace std;

const int maxn = 2e5 + 7;
int m, k, x, y;
bool th[maxn];
int dis[maxn], ans = 0;
vector<int> graph[maxn];

bool dfs(int n, int fa, int d) {
    dis[n] = d;
    bool ret = th[n];
    for (int next: graph[n]) {
        if (fa == next) continue;
        if (dfs(next, n, d + 1)) {
            ans += 2;
            ret = true;
        }
    }
    return ret;
}

int main() {
    ios::sync_with_stdio(false);
    int n;
    cin >> n;
    while (n--) {
        ans = 0;
        scanf("%d%d%d%d", &m, &k, &x, &y);
        for (int i = 0; i <= m; ++i) graph[i].clear();
        memset(dis, 0, sizeof(dis));
        memset(th, 0, sizeof(th));
        int pos;
        th[y] = true;
        while (k--) {
            scanf("%d", &pos);
            th[pos] = true;
        }
        int u, v;
        while (--m) {
            scanf("%d%d", &u, &v);
            graph[u].push_back(v);
            graph[v].push_back(u);
        }

        dfs(x, 0, 0);
        printf("%d\n", ans - dis[y]);
    }
    return 0;
}