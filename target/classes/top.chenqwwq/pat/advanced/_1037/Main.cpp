//
// Created by 陈炳鑫 on 2022/4/18.
//


#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
    int n, m;
    scanf("%d", &n);
    vector<int> cs(n);
    for (int i = 0; i < n; ++i) scanf("%d", &cs[i]);
    scanf("%d", &m);
    vector<int> ps(m);
    for (int i = 0; i < m; ++i) scanf("%d", &ps[i]);
    sort(cs.begin(), cs.end());
    sort(ps.begin(), ps.end());
    int ans = 0;
    int i = 0;
    while (i < n && i < m && cs[i] < 0 && ps[i] < 0) {
        ans += cs[i] * ps[i];
        i++;
    }
    int j1 = n - 1, j2 = m - 1;
    while (j1 >= 0 && j2 >= 0 && cs[j1] > 0 && ps[j2] > 0) {
        ans += cs[j1] * ps[j2];
        j1--;
        j2--;
    }
    printf("%d", ans);
    return 0;
}