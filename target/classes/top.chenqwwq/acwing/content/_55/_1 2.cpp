//
// Created by chenqwwq on 2022/6/11.
//



#include "iostream"

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    bool exist[10];
    for (bool &k: exist) k = false;

    int n, m, q;
    cin >> n >> m;
    int a[n];
    for (int &k: a) cin >> k;
    for (int i = 0; i < m; ++i) {
        cin >> q;
        exist[q] = true;
    }

    bool first = true;
    for (int i = 0; i < n; ++i) {
        if (exist[a[i]]) {
            if (!first) cout << " ";
            first = false;
            cout << a[i];
        }
    }
    return 0;
}