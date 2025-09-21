//
// Created by 陈炳鑫 on 2022/4/14.
//


#include <iostream>
#include <queue>

using namespace std;

int dis = 0x3f3f3f3f, cost = 0x3f3f3f3f;
vector<int> path;
int S, D, N, M;
vector<vector<vector<int>>> roads;

void dfs(int curr, int d, int c, vector<int> p, vector<bool> vis) {
    if (curr == D) {
        if (d < dis || (dis == d && c < cost)) {
            dis = d;
            cost = c;
            path = p;
        }
        return;
    }
    for (int i = 0; i < N; ++i) {
        if (vis[i] || roads[curr][i][0] == -1) continue;
        vis[i] = true;
        p.push_back(i);
        dfs(i, d + roads[curr][i][0], c + roads[curr][i][1], p, vis);
        p.pop_back();
        vis[i] = false;
    }
}

int main() {
    scanf("%d %d %d %d", &N, &M, &S, &D);
    roads = vector(N, vector<vector<int>>(N, vector<int>(2, -1)));
    int s, d, di, c;
    for (int i = 0; i < M; ++i) {
        scanf("%d %d %d %d", &s, &d, &di, &c);
        roads[s][d][0] = di;
        roads[s][d][1] = c;
        roads[d][s][0] = di;
        roads[d][s][1] = c;
    }
    vector<bool> vis(N, false);
    vis[S] = true;
    dfs(S, 0, 0, {S}, vis);
    for (int pos: path) printf("%d ", pos);
    printf("%d %d\n", dis, cost);
    return 0;
}