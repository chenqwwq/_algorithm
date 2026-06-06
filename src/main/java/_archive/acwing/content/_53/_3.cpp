//
// Created by chenqwwq on 2022/5/28.
//


#include <iostream>
#include <vector>
#include <map>

using namespace std;

int n;
const int N = 1e5 + 5;
long long ans = 0;
int pt[N], st[N];
map<int, vector<int>> path;

void dfs(int idx, int sum) {
    if (st[idx] != -1) {
        ans += st[idx] - sum;
        for (int next: path[idx]) dfs(next, st[idx]);
    } else if (!path[idx].empty()) {
        int mmin = 0x3f3f3f3f;
        for (int next: path[idx]) mmin = min(mmin, st[next]);
        if (mmin < sum) {
            printf("%d\n", -1);
            exit(0);
        }
        ans += (mmin - sum);
        for (int next: path[idx]) dfs(next, mmin);
    }
}

int main() {
    cin >> n;
    pt[0] = 0;
    for (int i = 1; i < n; ++i) {
        cin >> pt[i];
        if (path.find(pt[i]) == path.end()) path[pt[i]] = {};
        path[pt[i] - 1].push_back(i);
    }
    for (int i = 0; i < n; ++i) cin >> st[i];
    dfs(0, 0);
    printf("%lld\n", ans);
    return 0;
}

