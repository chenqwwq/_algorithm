//
// Created by 陈炳鑫 on 2022/5/11.
//


#include <iostream>
#include <vector>

using namespace std;

const int maxn = 4001;
int num, ans, m;
string cs;
vector<int> child[maxn];
typedef pair<int, int> pii;

#define init() ans = 0;for (int i = 0; i < maxn; i++)child[i].clear();

void add(pii &p1, pii &p2) {
    p1.first += p2.first;
    p1.second += p2.second;
}

pii dfs(int i) {
    auto ret = cs[i] == 'W' ? make_pair(1, 0) : make_pair(0, 1);
    if (child[i].empty()) {
        return ret;
    }
    for (auto next: child[i]) {
        auto p2 = dfs(next);
        add(ret, p2);
    }
    if (ret.first == ret.second) ans++;
    return ret;
}


int main() {
    int n;
    cin >> n;
    while (n--) {
        cin >> m;
        init();
        for (int i = 0; i < m - 1; ++i) {
            cin >> num;
            child[num - 1].push_back(i + 1);
        }
        cin >> cs;
        dfs(0);
        printf("%d\n", ans);
    }
    return 0;
}